package estate.app;

import estate.entity.json.BasicJson;
import estate.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-10-4.
 *
 */
@RestController
@RequestMapping(value = "/api/fee")
public class FeeHandler
{
    @Autowired
    private BillService billService;

    /**
     * 获取用户绑定的所有物业的张账单
     * @return
     */
    @RequestMapping(value = "/getBill")
    public BasicJson getBill(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        try
        {
            basicJson.setJsonString(billService.getBillByPropertyID(1));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取账单失败!");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }
}
