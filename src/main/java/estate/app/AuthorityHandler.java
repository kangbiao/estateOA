package estate.app;

import estate.common.util.LogUtil;
import estate.entity.database.SsidSecretEntity;
import estate.entity.json.BasicJson;
import estate.service.AuthorityService;
import estate.service.SsidSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-21.
 * 该类提供登陆认证,门禁权限认证等认证功能
 */
@RestController
@RequestMapping("api/auth")
public class AuthorityHandler
{

    @Autowired
    AuthorityService authorityService;
    @Autowired
    SsidSecretService ssidSecretService;

    @RequestMapping(value = "/getSecret/{ssid}",method = RequestMethod.GET)
    public BasicJson getSsidSecret(@PathVariable String ssid,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        SsidSecretEntity ssidSecretEntity;
        //TODO 从登陆的用户session中取出用户的电话号码
        String phone="18144240528";
        if (ssid!=null&&!ssid.equals(""))
        {
            try
            {
                ssidSecretEntity=ssidSecretService.getSelfBySsid(ssid);
                if (ssidSecretEntity==null)
                {
                    basicJson.getErrorMsg().setDescription("该ssid不存在!");
                    return basicJson;
                }
            }
            catch (Exception e)
            {
                LogUtil.E((e.getMessage()));
                basicJson.getErrorMsg().setDescription("该ssid不存在!");
                return basicJson;
            }
            LogUtil.E(ssidSecretEntity.getSecret());
        }
        else
        {
            basicJson.getErrorMsg().setCode("102133");
            basicJson.getErrorMsg().setDescription("非法的SSID值");
            return basicJson;
        }

        //取出当前用户能进入的所有楼栋的ID
        ArrayList<Integer> ids=authorityService.getAuthorityBuildingIDsByPhone(phone);
        if(ids.contains(ssidSecretEntity.getBuildingId()))
        {
            basicJson.setStatus(true);
            basicJson.setJsonString(ssidSecretEntity.getSecret());
        }
        else
        {
            basicJson.getErrorMsg().setCode("12050510");
            basicJson.getErrorMsg().setDescription("您没有访问权限");
            return basicJson;
        }
        return basicJson;
    }
}
