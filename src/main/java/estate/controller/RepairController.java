package estate.controller;

import estate.entity.database.PictureEntity;
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
import java.util.Arrays;

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

    /**
     * 设置维修人员
     * @param request
     * @return
     */
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

    /**
     * 删除报修
     * @param repairID
     * @param request
     * @return
     */
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

    /**
     * 根据维修id获取该维修所有的图片路径
     * @param repairID
     * @param request
     * @return
     */
    @RequestMapping(value = "/getPathsByID/{repairID}")
    public BasicJson getPathByID(@PathVariable Integer repairID,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String baseUrl=request.getContextPath()+"/file/picture/";

        try
        {
            RepairEntity repairEntity = (RepairEntity) baseService.get(repairID, RepairEntity.class);

            StringBuilder paths = new StringBuilder();

            for (String idString : Arrays.asList(repairEntity.getImageIdList().split(",")))
            {
                PictureEntity pictureEntity = (PictureEntity) baseService.get(Integer.valueOf(idString), PictureEntity.class);

                paths.append(baseUrl).append(pictureEntity.getName());
            }
            basicJson.setJsonString(paths.toString());

        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取图片列表失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }
}
