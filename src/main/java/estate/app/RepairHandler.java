package estate.app;

import estate.common.RepairStatus;
import estate.entity.json.BasicJson;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public BasicJson addRepair(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();

        basicJson.setStatus(true);
        return basicJson;
    }
}
