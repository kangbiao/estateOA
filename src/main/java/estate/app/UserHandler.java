package estate.app;

import estate.common.util.LogUtil;
import estate.entity.database.AppUserEntity;
import estate.entity.json.BasicJson;
import estate.service.AppUserService;
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
        request.getSession().setAttribute("phone",phone);
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
        BasicJson basicJson=new BasicJson(false);

        return basicJson;
    }
}
