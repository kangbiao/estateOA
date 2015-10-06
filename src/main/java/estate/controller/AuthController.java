package estate.controller;

import estate.dao.ConsoleUserDao;
import estate.entity.database.ConsoleUserEntity;
import estate.entity.json.BasicJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private ConsoleUserDao consoleUserDao;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BasicJson login(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if (username==null||username.equals(""))
        {
            basicJson.getErrorMsg().setDescription("请输入用户名");
            return basicJson;
        }

        if (password==null||password.equals(""))
        {
            basicJson.getErrorMsg().setDescription("请输入密码");
            return basicJson;
        }

        ConsoleUserEntity consoleUserEntity=consoleUserDao.getConsoleUserByPhone(username);
        if (consoleUserEntity==null)
        {
            basicJson.getErrorMsg().setDescription("用户不存在");
            return basicJson;
        }
        if (!consoleUserEntity.getPassword().equals(password))
        {
            basicJson.getErrorMsg().setDescription("密码错误!");
            return basicJson;
        }

        basicJson.setStatus(true);
        request.getSession().setAttribute("user",consoleUserEntity);
        return basicJson;
    }
}
