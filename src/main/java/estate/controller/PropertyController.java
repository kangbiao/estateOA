package estate.controller;

import estate.common.UserType;
import estate.common.util.LogUtil;
import estate.entity.database.*;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.exception.EntityTypeErrorException;
import estate.exception.PropertyNotBindFeeItemException;
import estate.exception.UserTypeErrorException;
import estate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

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
    @Autowired
    private BillService billService;

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
        try
        {
            if (propertyService.getByCode(propertyEntity.getCode())!=null)
            {
                basicJson.getErrorMsg().setDescription("该编号已存在!");
                return basicJson;
            }
        }
        catch (EntityTypeErrorException e)
        {
            LogUtil.E("内部参数错误:"+e.getMessage());
            basicJson.getErrorMsg().setDescription("内部参数错误,请查看日志文件");
            return basicJson;
        }
        propertyService.getAllProperty();
        try
        {
            baseService.save(propertyEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("1023240");
            basicJson.getErrorMsg().setDescription("添加物业信息失败:" + e.getMessage());
            return basicJson;
        }
        basicJson.setStatus(true);
        basicJson.setJsonString(propertyEntity.getId());
        return basicJson;
    }

    /**
     * 修改物业信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify")
    public BasicJson modifyProperty(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        PropertyEntity propertyEntity;
        try
        {
            Integer id= Integer.valueOf(request.getParameter("id"));
            propertyEntity= (PropertyEntity) baseService.get(id,PropertyEntity.class);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("未获取到正确的参数信息!\n"+e.getMessage());
            return basicJson;
        }
        try
        {
            propertyEntity.setLocation(request.getParameter("location"));
            propertyEntity.setPropertySquare(new BigDecimal(request.getParameter("propertySquare")).setScale(2,
                    BigDecimal.ROUND_HALF_UP));
            propertyEntity.setStatus(Byte.valueOf(request.getParameter("status")));
            propertyEntity.setType(Byte.valueOf(request.getParameter("type")));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("参数解析错误\n"+e.getMessage());
            return basicJson;
        }
        try
        {
            baseService.save(propertyEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("修改出错\n"+e.getMessage());
            return basicJson;
        }

        basicJson.setStatus(true);
        basicJson.setJsonString(propertyEntity);
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
                try
                {
                    basicJson.setJsonString(userService.getUserInfoByProperityID(propertyID, UserType.OWNER));
                }
                catch (UserTypeErrorException e)
                {
                    LogUtil.E(e.getMessage());
                    basicJson.setJsonString("获取业主信息失败:"+e.getMessage());
                    return basicJson;
                }
                break;
            default:
                basicJson.getErrorMsg().setDescription("参数错误!");
                return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }


    @RequestMapping(value = "/getMoreInfo/{propertyID}")
    public BasicJson getMoreInfoByPropertyID(@PathVariable Integer propertyID)
    {
        BasicJson basicJson =new BasicJson();
        ArrayList<Object> objects=new ArrayList<>();
        try
        {
            PropertyEntity propertyEntity= (PropertyEntity) baseService.get(propertyID,PropertyEntity.class);
            objects.add(propertyEntity);
            objects.add(userService.getUserInfoByProperityID(propertyID, UserType.OWNER));
            basicJson.setJsonString(objects);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取物业信息失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/generateBill/{propertyID}")
    public BasicJson generateBill(@PathVariable Integer propertyID)
    {
        BasicJson basicJson=new BasicJson();
        try
        {
            billService.generateBillByPropertyID(propertyID);
        }
        catch (PropertyNotBindFeeItemException p)
        {
            basicJson.getErrorMsg().setDescription(p.getMessage());
            return basicJson;
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setDescription("生成账单失败");
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
