package estate.app;

import estate.common.AppUserStatus;
import estate.common.CardType;
import estate.common.SexType;
import estate.common.UserType;
import estate.common.util.*;
import estate.entity.database.AppUserEntity;
import estate.entity.database.FamilyEntity;
import estate.entity.database.OwnerEntity;
import estate.entity.database.TenantEntity;
import estate.entity.json.BasicJson;
import estate.exception.TypeErrorException;
import estate.service.AppUserService;
import estate.service.BaseService;
import estate.service.PropertyService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

import static estate.common.UserType.FAMILY;

/**
 * Created by kangbiao on 15-9-21.
 * 登陆,登出,注册(获取验证码,核对验证码,绑定业主)
 */
@RestController
@RequestMapping("api/uc")
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

    @RequestMapping(value = "/login",method = RequestMethod.GET)
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
        if (appUserEntity.getStatus().equals(AppUserStatus.DISABLE))
        {
            basicJson.getErrorMsg().setDescription("登录失败,该用户已被禁用");
            return basicJson;
        }
        if (appUserEntity.getStatus().equals(AppUserStatus.FORCHECK))
        {
            basicJson.getErrorMsg().setDescription("登录失败,待审核用户不能登陆");
            return basicJson;
        }


        basicJson.setStatus(true);
        request.getSession().setAttribute("phone", phone);
        request.getSession().setAttribute("username", appUserEntity.getUserName());
        request.getSession().setAttribute("role", appUserEntity.getUserRole());
        basicJson.setJsonString(request.getSession().getId());
        return basicJson;
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public BasicJson loginOut(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(true);
        request.getSession().removeAttribute("phone");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("role");
        return basicJson;
    }

    //TODO 全部要改
    @RequestMapping(value = "/register/getVerifyCode/{phone}",method = RequestMethod.GET)
    public BasicJson getVerifyCode(@PathVariable String phone,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        if (phone==null)
        {
            basicJson.getErrorMsg().setDescription("请输入手机号!");
            return basicJson;
        }
        if (appUserService.getByPhone(phone)!=null)
        {
            basicJson.getErrorMsg().setDescription("手机号码已注册");
            return basicJson;
        }
        String verifyCode=VerifyCodeGenerate.create();
//
        if (!Message.send(phone, "多能通用户注册验证码" + verifyCode+"(10分钟有效),消息来自:多能通安全中心").equals("succ"))
        {
            basicJson.getErrorMsg().setDescription("验证码发送失败");
            return basicJson;
        }
        LogUtil.E("code:"+verifyCode);
        request.getSession().setAttribute("verifyCode", verifyCode);
        request.getSession().setAttribute("phone", phone);
        basicJson.setStatus(true);
        basicJson.setJsonString(request.getSession().getId());
        return basicJson;
    }

    @RequestMapping(value = "/register/checkVerifyCode/{verifyCode}",method = RequestMethod.GET)
    public BasicJson checkVerifyCode(HttpServletRequest request,@PathVariable String verifyCode)
    {
        BasicJson basicJson=new BasicJson(false);
        if (verifyCode==null|| Objects.equals(verifyCode, ""))
        {
            basicJson.getErrorMsg().setDescription("请输入验证码");
            return basicJson;
        }
        if (!verifyCode.equals(request.getSession().getAttribute("verifyCode")))
        {
            LogUtil.E("session:"+request.getSession().getAttribute("verifyCode")+"  post:"+verifyCode);
            basicJson.getErrorMsg().setDescription("验证码输入错误!");
            return basicJson;
        }

        request.getSession().removeAttribute("verifyCode");
        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/register/doRegister",method = RequestMethod.GET)
    public BasicJson regist(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        AppUserEntity appUserEntity=new AppUserEntity();
        String phone= (String) request.getSession().getAttribute("phone");
        String userName=request.getParameter("nickname");
        String password=request.getParameter("password");

        appUserEntity.setPhone(phone);
        appUserEntity.setUserName(userName);
        appUserEntity.setPasswd(password);


        Object o=userService.getAppUserInfoByPhoneRole(phone, UserType.OWNER);
        if (o==null)
        {
            appUserEntity.setStatus(AppUserStatus.FORCHECK);
            basicJson.getErrorMsg().setCode("100001");
            request.getSession().setAttribute("appUser", appUserEntity);
        }
        else
        {
            appUserEntity.setStatus(AppUserStatus.ENABLE);
            appUserEntity.setUserRole(UserType.OWNER);
            basicJson.getErrorMsg().setCode("100000");
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
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 绑定业主
     * @param request
     * @return
     */
    @RequestMapping(value = "/register/bind",method = RequestMethod.POST)
    public BasicJson bindOwner(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);

        HttpSession httpSession=request.getSession();
        Integer propertyId=Integer.valueOf(request.getParameter("propertyID"));
        int role=Integer.valueOf(request.getParameter("role"));
        String phone= (String) httpSession.getAttribute("phone");

        AppUserEntity appUserEntity= (AppUserEntity)request.getSession().getAttribute("appUser");
        appUserEntity.setPhone(phone);
        appUserEntity.setUserRole(role);

        try
        {
            UserType.checkType(role);
            userService.register(appUserEntity,propertyId);
        }
        catch (TypeErrorException e)
        {
            basicJson.getErrorMsg().setDescription("用户角色参数错误!");
            return basicJson;
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("注册失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/modify/{action}")
    public BasicJson modify(@PathVariable String action,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String phone= (String) request.getSession().getAttribute("phone");
        int role= (int) request.getSession().getAttribute("role");
        switch (action)
        {
            case "password":
                AppUserEntity appUserEntity= (AppUserEntity) userService.getAppUserInfoByPhoneRole(phone, UserType
                        .APPUSER);
                String oldPassword=request.getParameter("oldPassword");
                String newPassword=request.getParameter("newPassword");
                if (!oldPassword.equals(appUserEntity.getPasswd()))
                {
                    basicJson.getErrorMsg().setDescription("原密码错误");
                    return basicJson;
                }
                appUserEntity.setPasswd(newPassword);
                try
                {
                    baseService.save(appUserEntity);
                }
                catch (Exception e)
                {
                    LogUtil.E("保存用户信息失败"+e.getMessage());
                    basicJson.getErrorMsg().setDescription("修改密码失败");
                    return basicJson;
                }
                break;
            case "getProfile":
                try
                {
                    Object o=userService.getAppUserInfoByPhoneRole(phone, role);
                    if (o==null)
                    {
                        basicJson.getErrorMsg().setDescription("获取用户信息失败");
                        return basicJson;
                    }
                    basicJson.setJsonString(o);
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setDescription("获取用户信息出错");
                    return basicJson;
                }
                break;
            case "submitProfile":
                Byte identityType,sex;
                String name,urgentName,urgentPhone,identityCode;
                Long birthday;
                try
                {
                    identityType= Byte.valueOf(request.getParameter("identityType"));
                    CardType.checkType(identityType);
                    name=request.getParameter("name");
                    birthday= Convert.time2num(request.getParameter("birthday"));
                    LogUtil.E("birthday"+request.getParameter("birthday"));
                    urgentName = request.getParameter("urgentName");
                    urgentPhone=request.getParameter("urgentPhone");
                    identityCode=request.getParameter("identityCode");
                    sex= Byte.valueOf(request.getParameter("sex"));
                    SexType.checkType(sex);
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setCode("100000");
                    basicJson.getErrorMsg().setDescription("参数错误");
                    return basicJson;
                }

                try
                {
                    if (role== FAMILY)
                    {
                        FamilyEntity familyEntity= (FamilyEntity) userService.getAppUserInfoByPhoneRole(phone, role);
                        familyEntity.setName(name);
                        familyEntity.setSex(sex);
                        familyEntity.setBirthday(birthday);
                        familyEntity.setUrgentName(urgentName);
                        familyEntity.setUrgentPhone(urgentPhone);
                        familyEntity.setIdentityType(identityType);
                        familyEntity.setIdentityCode(identityCode);
                        baseService.save(familyEntity);
                    }
                    else if (role==UserType.TENANT)
                    {
                        TenantEntity tenantEntity= (TenantEntity) userService.getAppUserInfoByPhoneRole(phone, role);
                        tenantEntity.setName(name);
                        tenantEntity.setSex(sex);
                        tenantEntity.setBirthday(birthday);
                        tenantEntity.setUrgentName(urgentName);
                        tenantEntity.setUrgentPhone(urgentPhone);
                        tenantEntity.setIdentityType(identityType);
                        tenantEntity.setIdentityCode(identityCode);
                        baseService.save(tenantEntity);
                    }
                    else if (role==UserType.OWNER)
                    {
                        OwnerEntity ownerEntity= (OwnerEntity) userService.getAppUserInfoByPhoneRole(phone, role);
                        ownerEntity.setName(name);
                        ownerEntity.setSex(sex);
                        ownerEntity.setBirthday(birthday);
                        ownerEntity.setUrgentName(urgentName);
                        ownerEntity.setUrgentPhone(urgentPhone);
                        ownerEntity.setIdentityType(identityType);
                        ownerEntity.setIdentityCode(identityCode);
                        LogUtil.E(GsonUtil.getGson().toJson(ownerEntity));
                        baseService.save(ownerEntity);
                    }

                }
                catch (Exception e)
                {
                    LogUtil.E("保存用户资料时出错"+e.getMessage());
                    basicJson.getErrorMsg().setDescription("修改密码失败");
                    return basicJson;
                }
                break;
            default:
                basicJson.getErrorMsg().setDescription("请求路径错误!");
                return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }


    @RequestMapping(value = "/findPassword/{phone}",method = RequestMethod.GET)
    public BasicJson findPassword(@PathVariable String phone,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String verifyCode=VerifyCodeGenerate.create();
        request.getSession().setAttribute("phone", phone);
        request.getSession().setAttribute("verifyCode",verifyCode);
        if (!Message.send(phone, "多能通用户注册验证码" + verifyCode+"(10分钟有效),消息来自:多能通安全中心").equals("succ"))
        {
            basicJson.getErrorMsg().setDescription("验证码发送失败,请输入合法的手机号");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/findPassword/checkVerifyCode/{verifyCode}",method = RequestMethod.GET)
    public BasicJson checkVerifyCode(@PathVariable String verifyCode,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        if (!verifyCode.equals(request.getSession().getAttribute("verifyCode")))
        {
            basicJson.getErrorMsg().setDescription("验证码错误");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * app用户获取角色
     * @param request
     * @return
     */
    @RequestMapping(value = "/getRole",method = RequestMethod.GET)
    public BasicJson getUserRole(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        try
        {
            basicJson.setJsonString(request.getSession().getAttribute("role"));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取用户角色失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }
}
