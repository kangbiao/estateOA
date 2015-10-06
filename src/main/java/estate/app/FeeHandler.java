package estate.app;

import estate.entity.json.BasicJson;
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

    /**
     * 获取用户绑定的所有物业的张账单
     * @return
     */
    public BasicJson getBill(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();

        return basicJson;
    }
}
