package estate.controller;

import estate.common.UserType;
import estate.common.util.Convert;
import estate.common.util.LogUtil;
import estate.entity.database.AppUserEntity;
import estate.entity.database.OwnerEntity;
import estate.entity.database.PropertyEntity;
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
import java.util.ArrayList;

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

    /**
     * 增加业主信息
     * @return
     */
    @RequestMapping(value = "/addOwner",method = RequestMethod.POST)
    public BasicJson addOwner(OwnerEntity ownerEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        ownerEntity.setAuthenticationTime(Convert.time2num(request.getParameter("authTime")));

        if(userService.getUserInfoBYPhone(ownerEntity.getPhone(), UserType.OWNER)!=null)
        {
            basicJson.getErrorMsg().setDescription("该电话已经存在!");
            return basicJson;
        }

        try
        {
            baseService.save(ownerEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("1028330");
            basicJson.getErrorMsg().setDescription("添加用户信息出错\n详细信息:"+e.getMessage());
            return basicJson;
        }

//        basicJson.setJsonString(ownerEntity);
        basicJson.setStatus(true);
        return basicJson;
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
        try
        {
            return userService.getOwnerList(tableFilter);
        }
        catch (Exception e)
        {
            TableData tableData=new TableData(false);
            tableData.getErrorMsg().setDescription(e.getMessage());
            return tableData;
        }

    }

    /**
     * 通过用户的电话和类型返回该用户关联的所有物业信息
     * @param userType
     * @param phone
     * @return
     */
    @RequestMapping(value = "/{userType}/getPropertiesByPhone/{phone}",method = RequestMethod.GET)
    public BasicJson getPropertiesByOwnerId(@PathVariable String userType,@PathVariable String phone)
    {
        BasicJson basicJson=new BasicJson(false);
        int type;
        switch (userType)
        {
            case "owner":
                type=UserType.OWNER;
                break;
            case "appuser":
                type=UserType.APPUSER;
                break;
            default:
                basicJson.getErrorMsg().setDescription("请求参数错误!");
                return basicJson;
        }
        try
        {
            basicJson.setJsonString(userService.getPropertiesByPhone(phone,type));
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setCode("21233210");
            basicJson.getErrorMsg().setDescription("获取物业信息失败\n错误详情:"+e.getMessage());
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 通过用户类型和电话删除用户
     * 本来应该通过id删除的,但是物业业主信息表是通过业主的电话关联
     * @param userType
     * @param phone
     * @return
     */
    @RequestMapping(value = "/{userType}/delete/{phone}")
    public BasicJson deleteOwner(@PathVariable String userType,@PathVariable String phone)
    {
        BasicJson basicJson=new BasicJson(false);
        int type;
        switch (userType)
        {
            case "owner":
                type=UserType.OWNER;
                break;
            case "appuser":
                type=UserType.APPUSER;
                break;
            default:
                basicJson.getErrorMsg().setDescription("请求参数错误!");
                return basicJson;
        }
        try
        {
            //如果用户类型是业主的话,需要判断该业主是否绑定物业,若绑定了则不允许删除
            if (type==UserType.OWNER)
            {
                ArrayList<PropertyEntity> entities = (ArrayList<PropertyEntity>) userService.getPropertiesByPhone
                        (phone,type);
                if (entities.size() > 0)
                {
                    basicJson.getErrorMsg().setDescription("该业主已绑定物业,不能删除");
                    return basicJson;
                }
            }

            userService.deleteUserByPhone(phone,type);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setCode("21233210");
            basicJson.getErrorMsg().setDescription("查询失败\n错误详情:"+e.getMessage());
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
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

    /**
     *根据业主的id查看业主的详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/ownerInfo/{id}")
    public BasicJson getOwnerInfoByID(@PathVariable Integer id)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            basicJson.setJsonString(userService.getOnerInfoByID(id));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("100660");
            basicJson.getErrorMsg().setDescription("获取业主信息错误");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 改变appuser的状态,是否禁用该用户.
     * @param request
     * @return
     */
    @RequestMapping(value = "/appUserStatus" ,method = RequestMethod.POST)
    public BasicJson disableAppUser(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        String phone=request.getParameter("phone");
        String statusStr=request.getParameter("status");
        int status;
        switch (statusStr)
        {
            case "enable":
                status = 1;
                break;
            case "disable":
                status = -1;
                break;
            default:
                basicJson.getErrorMsg().setDescription("参数错误!");
                return basicJson;
        }
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
            appUserEntity.setStatus(status);
            try
            {
                userService.changeAppUserStatus(appUserEntity);
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
