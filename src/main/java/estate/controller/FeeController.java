package estate.controller;

import estate.entity.database.FeeItemEntity;
import estate.entity.database.RuleEntity;
import estate.entity.json.BasicJson;
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
    @RequestMapping(value = "/add")
    public BasicJson addFeeItem(HttpServletRequest request) throws ParseException
    {
        RuleEntity ruleEntity=new RuleEntity();
        FeeItemEntity feeItemEntity=new FeeItemEntity();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(request.getParameter("start_time"));
        System.out.println(date.getTime());

//        ruleEntity.setStartTime(request.getParameter("sa"));

        BasicJson basicJson=new BasicJson(false);


        return basicJson;
    }
}
