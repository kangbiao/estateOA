package estate.app;

import estate.common.UserType;
import estate.common.util.LogUtil;
import estate.entity.database.AppUserEntity;
import estate.entity.database.FamilyEntity;
import estate.entity.database.TenantEntity;
import estate.entity.json.BasicJson;
import estate.service.AppUserService;
import estate.service.BaseService;
import estate.service.PropertyService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-21.
 * 个人信息查看和修改,绑定业主
 */
@RestController
@RequestMapping("api/user")
public class UserHandler
{
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private BaseService baseService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public BasicJson login(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        LogUtil.E("phone:"+phone+"password:"+password);
        AppUserEntity appUserEntity= (AppUserEntity) appUserService.getByPhone(phone);
        if (appUserEntity==null)
        {
            basicJson.getErrorMsg().setDescription("用户不存在");
            return basicJson;
        }
        if (!password.equals(appUserEntity.getPasswd()))
        {
            basicJson.getErrorMsg().setDescription("密码错误");
            return basicJson;
        }

        basicJson.setStatus(true);
        request.getSession().setAttribute("phone", phone);
        basicJson.setJsonString(request.getSession().getId());
//        LogUtil.E(request.getSession().getId());
        return basicJson;
    }

    //TODO 全部要改
    @RequestMapping("/getVerifyCode")
    public BasicJson getVerifyCode(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        String phone=request.getParameter("phone");
        if (appUserService.getByPhone(phone)!=null)
        {
            basicJson.getErrorMsg().setDescription("手机号码已注册");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping("/regist")
    public BasicJson regist(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        AppUserEntity appUserEntity=new AppUserEntity();
        String phone=request.getParameter("phone");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");

        Object o=userService.getUserInfoBYPhone(phone, UserType.OWNER);
        if (o==null)
        {
            basicJson.getErrorMsg().setCode("0000000");
        }
        else
        {
//            appUserEntity.setUserRole(UserType.OWNER);
            basicJson.getErrorMsg().setCode("0000001");
        }

        appUserEntity.setPhone(phone);
        appUserEntity.setUserName(userName);
        appUserEntity.setPasswd(password);
        appUserEntity.setStatus(1);

        try
        {
            baseService.save(appUserEntity);
        }
        catch (Exception e)
        {
            LogUtil.E("错误:"+e.getMessage());
            basicJson.getErrorMsg().setDescription("注册失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }


    /**
     * 绑定业主
     * @param request
     * @return
     */
    @RequestMapping("/bind")
    public BasicJson bindOwner(HttpServletRequest request)
    {
        LogUtil.E("---已进入请求---");
        BasicJson basicJson=new BasicJson(false);
        Integer propertyId=Integer.valueOf(request.getParameter("id"));
        int role=Integer.valueOf(request.getParameter("role"));
        String phone=request.getParameter("phone");

        LogUtil.E("role:"+String.valueOf(role)+"phone:"+phone+"propertyId:"+propertyId);

        AppUserEntity appUserEntity= (AppUserEntity) userService.getUserInfoBYPhone(phone,UserType.APPUSER);
        appUserEntity.setUserRole(role);
        baseService.save(appUserEntity);

//        appUserEntity= (AppUserEntity) baseService.get(id,appUserEntity);

        switch (role)
        {
            case UserType.FAMILY:
                FamilyEntity familyEntity=new FamilyEntity();
                familyEntity.setPropertyId(propertyId);
                familyEntity.setPhone(appUserEntity.getPhone());
                familyEntity.setName(appUserEntity.getUserName());
                familyEntity.setAuthStatus(Byte.valueOf("0"));
                try
                {
                    baseService.save(familyEntity);
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setDescription("保存到家庭时出错");
                    return basicJson;
                }
                break;
            case UserType.TENANT:
                TenantEntity tenantEntity=new TenantEntity();
                tenantEntity.setPropertyId(propertyId);
                tenantEntity.setAuthStatus(Byte.valueOf("0"));
                tenantEntity.setPhone(appUserEntity.getPhone());
                tenantEntity.setName(appUserEntity.getUserName());
                try
                {
                    baseService.save(tenantEntity);
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setDescription("保存到租户时出错");
                    return basicJson;
                }
                break;
            default:
                basicJson.getErrorMsg().setDescription("用户类型参数错误");
                return basicJson;

        }
        basicJson.setStatus(true);
        return basicJson;
    }

    //TODO 项目验收,待删除
    @RequestMapping("/getAllProperty")
    public BasicJson getAll()
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            basicJson.setJsonString(propertyService.getAllProperty());
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription(e.getMessage());
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }
}
