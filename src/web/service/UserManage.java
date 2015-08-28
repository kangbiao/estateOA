package web.service;

import entity.database.UserEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kangbiao on 15-8-27.
 * 用户管理
 */
@WebServlet("/user")
public class UserManage extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    {

    }

    private boolean addUser(UserEntity userEntity)
    {
        return true;
    }

}
