package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.database.AppUserEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.BaseService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-3.
 *
 */
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/{userID}" ,method = RequestMethod.GET)
    public BasicJson login(@PathVariable String userID)
    {
        BasicJson temp=new BasicJson();
        temp.setStatus(true);
        temp.setJsonString("jsonstring");
        System.out.println(userID);
//        LogUtil.E("Fgfdgf");
        return temp;
    }


    /**
     * 获取业主列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/ownerList")
    public TableData getOwnerList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");

        return userService.getOwnerList(tableFilter);
    }

    /**
     * 获取认证用户的列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/authenticatedUserList")
    public TableData getTenantList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");

        try
        {
            return userService.getAuthenticatedUserList(tableFilter);
        }
        catch (Exception e)
        {
//            LogUtil.E(e.getClass()+e.getMessage());
            return null;
        }

    }

    /**
     * 获取租客列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/tenantList")
    public TableData getAuthList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");

        try
        {
            return userService.getTenantList(tableFilter);
        }
        catch (Exception e)
        {
//            LogUtil.E(e.getClass()+e.getMessage());
            return null;
        }
    }

    /**
     * 获取APP用户列表
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/appUserList")
    public TableData getAppUserList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        try
        {
            return userService.getAppUserList(tableFilter);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/disableAppUser" ,method = RequestMethod.POST)
    public BasicJson disableAppUser(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        String phone=request.getParameter("phone");
        if (phone==null)
        {
            basicJson.getErrorMsg().setCode("0");
            basicJson.getErrorMsg().setDescription("参数错误!");
            return basicJson;
        }
        else
        {
            AppUserEntity appUserEntity=new AppUserEntity();
            appUserEntity.setPhone(phone);
            appUserEntity.setUserRole(-1);
            try
            {
                baseService.save(appUserEntity);
            }
            catch (Exception e)
            {
                basicJson.getErrorMsg().setCode("10540");
                basicJson.getErrorMsg().setDescription("错误");
                return basicJson;
            }
        }
        basicJson.setStatus(true);
        return basicJson;
    }

}
