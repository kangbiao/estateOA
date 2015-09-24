package estate.controller;

import estate.common.UserType;
import estate.common.util.LogUtil;
import estate.entity.database.*;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-23.
 * 商户管理,住宅管理
 */
@RestController
@RequestMapping("/property")
public class PropertyController
{
    @Autowired
    private ShopService shopService;
    @Autowired
    private BaseService baseService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    protected UserService userService;

    /**
     * 获取商户信息列表
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/shopList")
    public TableData getShopList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        try
        {
            return shopService.getList(tableFilter);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }
    }

    /**
     * 获取住宅信息的列表
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/apartmentList")
    public TableData getApartmentList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        try
        {
            return apartmentService.getList(tableFilter);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }
    }

    /**
     * 获取物业信息列表
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/propertyList")
    public TableData getPropertyList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        try
        {
            return propertyService.getList(tableFilter);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }
    }

    /**
     * 根据物业ID获取更多物业信息
     * @param type 费用(fee),业主(owner)
     * @param propertyID 物业id
     * @return
     */
    @RequestMapping(value = "/{type}/{propertyID}")
    public BasicJson getOwnerInfoByPropertyID(@PathVariable String type,@PathVariable Integer propertyID)
    {
        BasicJson basicJson=new BasicJson(false);

        switch (type)
        {
            case "fee":
                FeeItemOrderEntity feeItemOrderEntity=(FeeItemOrderEntity)baseService.get(propertyID,FeeItemOrderEntity
                        .class);
                if (feeItemOrderEntity==null)
                {
                    basicJson.getErrorMsg().setDescription("该物业未绑定费用信息");
                    return basicJson;
                }
                basicJson.setJsonString("");
                break;
            case "owner":
                PropertyOwnerInfoEntity propertyOwnerInfoEntity=(PropertyOwnerInfoEntity)baseService.get(propertyID,
                        PropertyOwnerInfoEntity.class);
                if (propertyOwnerInfoEntity==null)
                {
                    basicJson.getErrorMsg().setDescription("该物业未绑定业主信息");
                    return basicJson;
                }
                basicJson.setJsonString(userService.getUserInfoBYPhone(propertyOwnerInfoEntity.getOwnerPhone(),
                        UserType.OWNER));
                break;
            default:
                basicJson.getErrorMsg().setDescription("参数错误!");
                return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 增加商户信息
     * @param propertyEntity
     * @param shopEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addShop")
    public BasicJson addShop(PropertyEntity propertyEntity,ShopEntity shopEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            shopService.saveShop(propertyEntity,shopEntity);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setDescription("添加失败,请重试!");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 增加住宅信息
     * @param propertyEntity
     * @param apartmentEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addApartment")
    public  BasicJson addApartment(PropertyEntity propertyEntity,ApartmentEntity apartmentEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            apartmentService.saveApartment(propertyEntity,apartmentEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("添加住宅信息失败,请重试");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

}
