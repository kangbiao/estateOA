package estate.app;

import estate.common.UserType;
import estate.common.util.LogUtil;
import estate.entity.database.AppUserEntity;
import estate.entity.database.PropertyEntity;
import estate.entity.display.PropertyAppUser;
import estate.entity.json.BasicJson;
import estate.service.PropertyService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-9.
 *
 */
@RestController
@RequestMapping(value = "/api/property")
public class PropertyHandler
{

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getMyPropery",method = RequestMethod.GET)
    public BasicJson getMyProperty(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String phone= (String) request.getSession().getAttribute("phone");
        try
        {
            ArrayList<PropertyEntity> propertyEntities=propertyService.getProperitiesByAppUserPhone(phone);
            if (propertyEntities==null)
            {
                LogUtil.E("获取用户绑定物业时程序错误");
                basicJson.getErrorMsg().setDescription("未绑定任何物业");
                return basicJson;
            }
            basicJson.setJsonString(propertyEntities);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取物业信息失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/checkBind")
    public BasicJson checkBind(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        int role= (int) httpSession.getAttribute("role");
        if (role!= UserType.OWNER)
        {
            basicJson.getErrorMsg().setDescription("非业主用户不能审核绑定");
            return basicJson;
        }
        try
        {
            String phone= (String) httpSession.getAttribute("phone");
            ArrayList<PropertyAppUser> propertyAppUsers=new ArrayList<>();
            ArrayList<PropertyEntity> propertyEntities= propertyService.getPropertyByOwnerPhone(phone);
            for (PropertyEntity propertyEntity:propertyEntities)
            {
                PropertyAppUser propertyAppUser=new PropertyAppUser();
                ArrayList<AppUserEntity> appUserEntities=userService.getBindUserByPropertyID(propertyEntity.getId(),
                        Byte.valueOf("0"));
                if (appUserEntities!=null)
                {
                    propertyAppUser.setPropertyEntity(propertyEntity);
                    propertyAppUser.setAppUserEntities(appUserEntities);
                    propertyAppUsers.add(propertyAppUser);
                }
            }
            if (propertyAppUsers.size()>0)
                basicJson.setJsonString(propertyAppUsers);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setDescription("获取绑定信息出错");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

}
