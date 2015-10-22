package estate.app;

import estate.common.config.AppUserStatus;
import estate.common.config.BindStatus;
import estate.common.util.GsonUtil;
import estate.common.util.LogUtil;
import estate.entity.app.MyProperty;
import estate.entity.database.PropertyOwnerInfoEntity;
import estate.entity.json.BasicJson;
import estate.service.BaseService;
import estate.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private BaseService baseService;
    @Autowired
    private PropertyOwnerService propertyOwnerService;

    /**
     * 获取我绑定的所有物业
     * @param request
     * @return
     */
    @RequestMapping(value = "/getMyPropery",method = RequestMethod.GET)
    public BasicJson getMyProperty(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String phone= (String) request.getSession().getAttribute("phone");
        try
        {
            ArrayList<PropertyOwnerInfoEntity> propertyOwnerInfoEntities=propertyOwnerService.getByPhone(phone);
            if (propertyOwnerInfoEntities==null)
            {
                basicJson.getErrorMsg().setDescription("未绑定任何物业");
                return basicJson;
            }
            ArrayList<MyProperty> myProperties=new ArrayList<>();
            for (PropertyOwnerInfoEntity propertyOwnerInfoEntity:propertyOwnerInfoEntities)
            {
                MyProperty myProperty=new MyProperty();
                myProperty.setUserRole(propertyOwnerInfoEntity.getUserRole());
                myProperty.setStatus(propertyOwnerInfoEntity.getStatus());
                myProperty.setId(propertyOwnerInfoEntity.getId());
                myProperty.setPropertyEntity(propertyOwnerInfoEntity.getPropertyEntity());
                myProperties.add(myProperty);
            }
            basicJson.setJsonString(myProperties);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取物业信息失败");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 业主获取申请绑定到自己物业的用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/getBind")
    public BasicJson checkBind(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        String phone= (String) httpSession.getAttribute("phone");
        Byte status=null;
        if (request.getParameter("status")!=null)
        {
            try
            {
                status=Byte.valueOf(request.getParameter("status"));
                AppUserStatus.checkType(status);
            }
            catch (Exception e)
            {
                basicJson.getErrorMsg().setCode("100000");
                basicJson.getErrorMsg().setDescription("客户端参数错误");
                LogUtil.E(GsonUtil.getGson().toJson(basicJson));
                return basicJson;
            }
        }
        try
        {
            basicJson.setJsonString(propertyOwnerService.getBindInfoByOwnerInfo(phone,status));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取绑定信息出错");
            return basicJson;
        }
        LogUtil.E(GsonUtil.getGson().toJson(basicJson));

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 业主审核
     * @param operate 只能为agree或者refuse
     * @param bindID
     * @param request
     * @return
     */
    @RequestMapping(value = "/submitBind/{operate}/{bindID}",method = RequestMethod.GET)
    public BasicJson submitBind(@PathVariable String operate,@PathVariable Integer bindID,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        try
        {
            PropertyOwnerInfoEntity propertyOwnerInfoEntity= (PropertyOwnerInfoEntity) baseService.
                                                                get(bindID, PropertyOwnerInfoEntity.class);
            switch (operate)
            {
                case "agree":
                    propertyOwnerInfoEntity.setStatus(BindStatus.CHECKED);
                    baseService.save(propertyOwnerInfoEntity);
                    break;
                case "refuse":
                    baseService.delete(propertyOwnerInfoEntity);
                    break;
                default:
                    basicJson.getErrorMsg().setCode("100000");
                    basicJson.getErrorMsg().setDescription("参数错误");
                    return basicJson;
            }
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("审核操作失败");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

}
