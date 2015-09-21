package estate.app;

import estate.entity.json.BasicJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-21.
 * 个人信息查看和修改,绑定业主
 */
@RestController
@RequestMapping("api/user")
public class UserHandler
{
    /**
     * 绑定业主
     * @param request
     * @return
     */
    @RequestMapping("/bind")
    public BasicJson bindOwner(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);

        return basicJson;
    }
}
