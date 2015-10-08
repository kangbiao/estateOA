package estate.controller;

import estate.common.Config;
import estate.common.util.Convert;
import estate.common.util.LogUtil;
import estate.entity.database.FeeItemEntity;
import estate.entity.database.RuleEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-14.
 * 提供缴费管理的所有费用类型的增删改查
 */

@RestController
@RequestMapping("/fee")
public class FeeController
{
    @Autowired
    FeeService feeService;


    @RequestMapping(value = "/add/{feeType}")
    public BasicJson addFeeItem(@PathVariable String feeType,HttpServletRequest request)
    {
        RuleEntity ruleEntity=new RuleEntity();
        FeeItemEntity feeItemEntity=new FeeItemEntity();
        BasicJson basicJson=new BasicJson(false);

        switch (feeType)
        {
            case "estate":
                ruleEntity.setStartTime(Convert.time2num(request.getParameter("start_time")));
                ruleEntity.setEndTime(Convert.time2num(request.getParameter("end_time")));

                ruleEntity.setUnit(request.getParameter("unit_type"));
                ruleEntity.setUnitPrice(request.getParameter("fee_unit_price"));
                ruleEntity.setOverdueUnit(request.getParameter("overdue_unit_type"));
                ruleEntity.setOverdueUnitPrice(request.getParameter("overdue_unit_price"));
                feeItemEntity.setRuleEntity(ruleEntity);
                String payStartTime=String.valueOf(Convert.time2num(request.getParameter("pay_start_time")));
                String payEndTime=String.valueOf(Convert.time2num(request.getParameter("pay_end_time")));
                feeItemEntity.setName(request.getParameter("fee_name") + ";" + payStartTime + ";" + payEndTime);
                feeItemEntity.setFeeTypeId(Config.ESTATE);
                break;
            case "service":
                ruleEntity.setStartTime(Convert.time2num(request.getParameter("start_time")));
                ruleEntity.setEndTime(Convert.time2num(request.getParameter("end_time")));
                ruleEntity.setUnitPrice(request.getParameter("fee_unit_price"));
                ruleEntity.setUnit(request.getParameter("unit_type"));

                feeItemEntity.setName(request.getParameter("fee_name"));
                feeItemEntity.setDecription(request.getParameter("description"));
                feeItemEntity.setRuleEntity(ruleEntity);

                feeItemEntity.setFeeTypeId(Config.SERVICE);
                feeItemEntity.setIsPeriodic(Config.FALSE);
                basicJson.setJsonString(feeItemEntity);
                break;
            case "parkingLot":
                break;
            default:
                break;
        }

        // TODO 判断物业费项目是否唯一
        try
        {
            feeService.estateFeeAdd(feeItemEntity);
        }
        catch (Exception e)
        {
//            LogUtil.E("费用信息写入数据库失败","FeeController");
            basicJson.getErrorMsg().setCode("1000550");
            basicJson.getErrorMsg().setDescription("费用信息增加失败,请重试");
            return basicJson;
        }

        basicJson.setStatus(true);
        basicJson.setJsonString(feeItemEntity);
        return basicJson;
    }

    @RequestMapping(value = "/list/{feeType}")
    public TableData feeList(@PathVariable String feeType, TableFilter tableFilter,HttpServletRequest request)
    {
        LogUtil.E(FeeController.class.getName());
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        TableData tableData=new TableData(false);
        try
        {
            switch (feeType)
            {
                case "estate":
                    return feeService.feeList(tableFilter,Config.ESTATE);
                case "service":
                    return feeService.feeList(tableFilter,Config.SERVICE);
                default:
                    tableData.getErrorMsg().setCode("1000525");
                    tableData.getErrorMsg().setDescription("请求路径错误");
                    return tableData;
            }

        }
        catch (Exception e)
        {
//            LogUtil.E(e.getMessage(),"FeeController");
            tableData.getErrorMsg().setCode("1000520");
            tableData.getErrorMsg().setDescription("获取费用列表失败,请重试");
            return tableData;
        }
    }

    /**
     * 将物业和费用项目绑定
     * @param request
     * @return
     */
    @RequestMapping(value = "/relateBuilding")
    public BasicJson relateBuilding(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        Integer feeItemID;
        ArrayList<Integer> buildingIDs;
        try
        {
            feeItemID=Integer.valueOf(request.getParameter("feeItemID"));
            buildingIDs=Convert.string2ints(request.getParameter("buildingIDs"),",");
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("参数错误\n"+e.getMessage());
            return basicJson;
        }
        try
        {
            feeService.relateBuilding(buildingIDs,feeItemID);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
        }
        LogUtil.E(buildingIDs);
        LogUtil.E(feeItemID);
        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 删除费用信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{feeId}")
    public BasicJson feeDelete(@PathVariable Integer feeId,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        try
        {
            feeService.deleteFee(feeId);
        }
        catch (Exception e)
        {
//            LogUtil.E(e.getMessage(), "FeeController");
            basicJson.getErrorMsg().setDescription("删除出错,请重试");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

}
