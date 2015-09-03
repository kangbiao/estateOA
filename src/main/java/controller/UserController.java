package controller;

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
    public ResponseEntity<String> login(@PathVariable String userID)
    {
        String temp="fgdg";
        ResponseEntity<String> responseResult = new ResponseEntity<String>(temp, HttpStatus.OK);
        System.out.println(userID);
        return responseResult;

    }
}
