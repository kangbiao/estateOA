package estate.controller;

import estate.entity.database.RepairEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.BaseService;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
@RestController
@RequestMapping("/web/repair")
public class RepairController
{
    @Autowired
    private RepairService repairService;
    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/list")
    public TableData getList(TableFilter tableFilter,HttpServletRequest request)
    {
        if (request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");

        return repairService.getList(tableFilter);
    }

    @RequestMapping(value = "/setRepairMan")
    public BasicJson setRepairMan(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        RepairEntity repairEntity=new RepairEntity();
        repairEntity.setId(Integer.valueOf(request.getParameter("repairID")));
        repairEntity.setRepirmanPhone(request.getParameter("repair"));
        try
        {
            String msg=repairService.setRepairMan(repairEntity);
            if (!msg.equals("succ"))
            {
                basicJson.getErrorMsg().setDescription(msg);
                return basicJson;
            }
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setCode("100015");
            basicJson.getErrorMsg().setDescription("操作失败");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/delete/{repairID}")
    public BasicJson deleteRepair(@PathVariable Integer repairID,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        if (repairID==null)
        {
            basicJson.getErrorMsg().setDescription("参数错误");
            return basicJson;
        }
        RepairEntity repairEntity=new RepairEntity();
        try
        {
            repairEntity.setId(repairID);
            baseService.delete(repairEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("删除失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }
}
