package estate.controller;

import estate.entity.json.BasicJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthController
{

    public BasicJson login(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();


        return basicJson;
    }
}
