package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.database.FeeItemEntity;
import estate.entity.database.RuleEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kangbiao on 15-9-14.
 *
 */

@RestController
@RequestMapping("/fee")
public class FeeController
{
    @Autowired
    FeeService feeService;

    /**-------------以下为物业费增删改查------------------*/

    @RequestMapping(value = "/estateAdd")
    public BasicJson addFeeItem(HttpServletRequest request)
    {
        RuleEntity ruleEntity=new RuleEntity();
        FeeItemEntity feeItemEntity=new FeeItemEntity();
        BasicJson basicJson=new BasicJson(false);

        //处理时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try
        {
            date = simpleDateFormat.parse(request.getParameter("start_time"));
            ruleEntity.setStartTime(date.getTime());
            date = simpleDateFormat.parse(request.getParameter("end_time"));
            ruleEntity.setEndTime(date.getTime());
        }
        catch (ParseException e)
        {
            LogUtil.E(e.getMessage());
        }

        //将post过来的费用信息保存在实体里面
        ruleEntity.setUnit(request.getParameter("unit_type"));
        ruleEntity.setUnitPrice(request.getParameter("fee_unit_price"));
        ruleEntity.setOverdueUnit(request.getParameter("overdue_unit_type"));
        ruleEntity.setOverdueUnitPrice(request.getParameter("overdue_unit_price"));
        feeItemEntity.setRuleEntity(ruleEntity);
        feeItemEntity.setName(request.getParameter("fee_name"));

        // TODO 判断物业费项目是否唯一

        try
        {
            feeService.estateFeeAdd(feeItemEntity);
        }
        catch (Exception e)
        {
            LogUtil.E("费用信息写入数据库失败");
            basicJson.getErrorMsg().setCode("1000550");
            basicJson.getErrorMsg().setDescription("费用信息增加失败,请重试");
            return basicJson;
        }

        basicJson.setStatus(true);
        basicJson.setJsonString(feeItemEntity);
        return basicJson;
    }

    @RequestMapping(value = "/estateList")
    public TableData feeList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        TableData tableData=new TableData(false);
        try
        {
            return feeService.feeList(tableFilter);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            tableData.getErrorMsg().setCode("1000520");
            tableData.getErrorMsg().setDescription("获取费用列表失败,请重试");
            return tableData;
        }

    }


    /**-------------以下为服务费增删改查------------------*/




    /**-------------以下为车位费增删改查------------------*/


}
