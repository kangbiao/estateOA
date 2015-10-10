package estate.app;

import estate.common.ComplainStatus;
import estate.common.util.LogUtil;
import estate.entity.json.BasicJson;
import estate.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by kangbiao on 15-10-10.
 *
 */
@RestController
@RequestMapping(value = "/api/complain")
public class ComplainHandler
{

    @Autowired
    private ComplainService complainService;

    /**
     * 获取我的投诉
     * @param request
     * @return
     */
    @RequestMapping(value = "/getMyComplain",method = RequestMethod.GET)
    public BasicJson getMyComplain(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        String phone= (String) httpSession.getAttribute("phone");
        Byte status=null;
        if (request.getParameter("status")!=null)
        {
            try
            {
                status= Byte.valueOf(request.getParameter("status"));
                ComplainStatus.checkType(status);
            }
            catch (Exception e)
            {
                basicJson.getErrorMsg().setCode("100000");
                basicJson.getErrorMsg().setDescription("客户端参数错误");
                return basicJson;
            }
        }

        try
        {
            basicJson.setJsonString(complainService.getComplainByPhone(phone,status));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取投诉失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/add")
    public BasicJson addComplain(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
//        LogUtil.E("json:"+ GsonUtil.getGson().toJson(request));
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String,MultipartFile> map= multipartRequest.getFileMap();


        for (String key: map.keySet())
        {
            MultipartFile fileItem= map.get(key);
            String fileName = fileItem.getOriginalFilename();
            LogUtil.E("FILENAME:" + fileName);
        }


        basicJson.setStatus(true);
        return basicJson;
    }

}
