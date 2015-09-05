package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.json.BasicJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kangbiao on 15-9-3.
 *
 */
@Controller
@RequestMapping("/user")
public class UserController
{
    @RequestMapping(value = "/{userID}" ,method = RequestMethod.GET)
    public ResponseEntity<BasicJson> login(@PathVariable String userID)
    {
        BasicJson temp=new BasicJson();
        temp.setStatus(true);
        temp.setJsonString("jsonstring");
        ResponseEntity<BasicJson> responseResult = new ResponseEntity<BasicJson>(temp, HttpStatus.OK);
        System.out.println(userID);
        LogUtil.E("Fgfdgf");
        return responseResult;
    }
}
