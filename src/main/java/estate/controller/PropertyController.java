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
 * 增加物业,增加园区,增加楼栋,查看物业
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
    @Autowired
    private FeeItemOrderService feeItemOrderService;

    /**
     * 增加物业信息
     * @param villageEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addVillage")
    public BasicJson addVillage(VillageEntity villageEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            baseService.save(villageEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("10294320");
            basicJson.getErrorMsg().setDescription("添加出错,请重试.\n错误详情:"+e.getMessage());
            return basicJson;
        }

        basicJson.setStatus(true);
        basicJson.setJsonString(villageEntity);
        return basicJson;
    }

    /**
     * 增加楼栋信息
     * @param buildingEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addBuilding")
    public BasicJson addBuilding(BuildingEntity buildingEntity ,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        basicJson.setJsonString(buildingEntity);
        try
        {
            baseService.save(buildingEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("2130900");
            basicJson.getErrorMsg().setDescription("楼栋信息添加失败\n详细信息:"+e.getMessage());
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 增加物业信息
     * @param propertyEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/add")
    public BasicJson addProperty(PropertyEntity propertyEntity, HttpServletRequest request)
    {
        BasicJson basicJson = new BasicJson(false);

        PropertyOwnerInfoEntity propertyOwnerInfoEntity = new PropertyOwnerInfoEntity();
        propertyOwnerInfoEntity.setPropertyEntity(propertyEntity);
        propertyOwnerInfoEntity.setOwnerPhone(request.getParameter("ownerPhone"));
        propertyOwnerInfoEntity.setBuildingId(Integer.valueOf(request.getParameter("buildingId")));
        propertyOwnerInfoEntity.setOpenDoorAllowed(Byte.valueOf("0"));
        basicJson.setJsonString(propertyEntity);
        try
        {
            propertyService.save(propertyOwnerInfoEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("1023240");
            basicJson.getErrorMsg().setDescription("添加信息失败:" + e.getMessage());
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 直接获取所有园区
     * @param request
     * @return
     */
    @RequestMapping(value = "/villageList")
    public BasicJson villageList(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            basicJson.setJsonString(propertyService.getAllVillage());
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("1234230");
            basicJson.getErrorMsg().setDescription("获取园区信息失败\n错误详情:"+e.getMessage());
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }


    /**
     * 根据园区的id获取该园区下面所有的楼栋
     * @param villageId
     * @return
     */
    @RequestMapping(value = "/buildingList/{villageId}")
    public BasicJson buildingList(@PathVariable Integer villageId)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            basicJson.setJsonString(propertyService.getBuildingsByValliageId(villageId));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("1234230");
            basicJson.getErrorMsg().setDescription("获取园区信息失败\n错误详情:"+e.getMessage());
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }


    /**
     * 获取物业信息列表
     *
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/propertyList")
    public TableData getPropertyList(TableFilter tableFilter, HttpServletRequest request)
    {
        if (request.getParameter("search[value]") != null)
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
     *
     * @param type       费用(fee),业主(owner)
     * @param propertyID 物业id
     * @return
     */
    @RequestMapping(value = "/{type}/{propertyID}")
    public BasicJson getOwnerInfoByPropertyID(@PathVariable String type, @PathVariable Integer propertyID)
    {
        BasicJson basicJson = new BasicJson(false);

        switch (type)
        {
            case "fee":
                basicJson.setJsonString(feeItemOrderService.getFeeItemsByPropertyID(propertyID));
                break;
            case "owner":
                PropertyOwnerInfoEntity propertyOwnerInfoEntity = (PropertyOwnerInfoEntity) propertyService
                        .getByProperID(propertyID);
                if (propertyOwnerInfoEntity == null)
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


    /**************************以下代码为待删除代码,不参与业务逻辑***************************/
    /**
     * 获取商户信息列表
     *
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/shopList")
    public TableData getShopList(TableFilter tableFilter, HttpServletRequest request)
    {
        if (request.getParameter("search[value]") != null)
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
     *
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/apartmentList")
    public TableData getApartmentList(TableFilter tableFilter, HttpServletRequest request)
    {
        if (request.getParameter("search[value]") != null)
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
     * 增加商户信息
     *
     * @param propertyEntity
     * @param shopEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addShop")
    public BasicJson addShop(PropertyEntity propertyEntity, ShopEntity shopEntity, HttpServletRequest request)
    {
        BasicJson basicJson = new BasicJson(false);
        try
        {
            shopService.saveShop(propertyEntity, shopEntity);
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
     *
     * @param propertyEntity
     * @param apartmentEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addApartment")
    public BasicJson addApartment(PropertyEntity propertyEntity, ApartmentEntity apartmentEntity, HttpServletRequest
            request)
    {
        BasicJson basicJson = new BasicJson(false);
        try
        {
            apartmentService.saveApartment(propertyEntity, apartmentEntity);
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
