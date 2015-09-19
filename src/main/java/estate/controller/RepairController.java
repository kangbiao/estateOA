package estate.controller;

import estate.entity.database.RepairEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
@RestController
@RequestMapping("/repair")
public class RepairController
{
    @Autowired
    private RepairService repairService;

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
        repairEntity.setRepirmanId(Integer.valueOf(request.getParameter("repairManID")));
        try
        {
            repairService.setRepairMan(repairEntity);
        }
        catch (Exception e)
        {
//            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setCode("100015");
            basicJson.getErrorMsg().setDescription("操作失败");
            return basicJson;
        }
        basicJson.setStatus(true);
        return basicJson;
    }
}
