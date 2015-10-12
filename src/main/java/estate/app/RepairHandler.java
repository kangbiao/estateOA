package estate.app;

import estate.common.RepairStatus;
import estate.common.util.LogUtil;
import estate.entity.database.RepairEntity;
import estate.entity.json.BasicJson;
import estate.service.BaseService;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value = "/api/repair")
public class RepairHandler
{

    @Autowired
    private RepairService repairService;
    @Autowired
    private BaseService baseService;

    /**
     * APP用户获取我的投诉列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getMyRepair")
    public BasicJson getMyRepair(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        String phone= (String) httpSession.getAttribute("phone");
        Byte status=null;
        if (request.getParameter("status")!=null)
        {
            try
            {
                status=Byte.valueOf(request.getParameter("status"));
                RepairStatus.checkType(status);
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
            basicJson.setJsonString(repairService.getRepairByPhone(phone,status));
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取报修信息失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 增加报修
     * @param request
     * @return
     */
    @RequestMapping(value = "/add")
    public BasicJson addRepair(RepairEntity repairEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        repairEntity.setPhone((String) httpSession.getAttribute("phone"));
        repairEntity.setTime(System.currentTimeMillis());
        repairEntity.setStatus(RepairStatus.FORPROCESS);
        if (repairEntity.getContent().length()>25)
            repairEntity.setDescription(repairEntity.getContent().substring(0,15));
        else repairEntity.setDescription(repairEntity.getContent());
        try
        {
            baseService.save(repairEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("提交报修失败");
            return basicJson;
        }

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
