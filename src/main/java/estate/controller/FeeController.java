package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.database.FeeItemEntity;
import estate.entity.database.RuleEntity;
import estate.entity.json.BasicJson;
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

    @RequestMapping(value = "/add")
    public BasicJson addFeeItem(HttpServletRequest request)
    {
        RuleEntity ruleEntity=new RuleEntity();
        FeeItemEntity feeItemEntity=new FeeItemEntity();

        //处理时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
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

        ruleEntity.setUnit(request.getParameter("unit_type"));
        ruleEntity.setUnitPrice(request.getParameter("fee_unit_price"));
        ruleEntity.setOverdueUnit(request.getParameter("overdue_unit_type"));
        ruleEntity.setOverdueUnitPrice(request.getParameter("overdue_unit_price"));


        System.out.println(date.getTime());

//        ruleEntity.setStartTime(request.getParameter("sa"));

        BasicJson basicJson=new BasicJson(false);


        return basicJson;
    }
}
