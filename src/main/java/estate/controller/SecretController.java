package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.database.SsidSecretEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.BaseService;
import estate.service.BuildingService;
import estate.service.SsidSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-22.
 *
 */
@RestController
@RequestMapping("/web/secret")
public class SecretController
{
    @Autowired
    BuildingService buildingService;
    @Autowired
    private SsidSecretService ssidSecretService;
    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BasicJson add(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
//        Integer buildingID=buildingService.getIDByCode(request.getParameter("building_code"));
//        if (buildingID==null)
//        {
//            basicJson.getErrorMsg().setCode("102200");
//            basicJson.getErrorMsg().setDescription("该楼栋不存在");
//            return basicJson;
//        }
        String buildingId=request.getParameter("buildingId");
        if (buildingId==null||buildingId.equals(""))
        {
            basicJson.getErrorMsg().setDescription("请选择楼栋");
            return basicJson;
        }

        SsidSecretEntity ssidSecretEntity=new SsidSecretEntity();
        ssidSecretEntity.setSecret(request.getParameter("secret"));
        ssidSecretEntity.setSsid(request.getParameter("ssid"));
        ssidSecretEntity.setBuildingId(Integer.valueOf(request.getParameter("buildingId")));

        if (ssidSecretService.getSelfBySsid(ssidSecretEntity.getSsid())!=null)
        {
            basicJson.getErrorMsg().setCode("1000200");
            basicJson.getErrorMsg().setDescription("该SSID已存在");
            return basicJson;
        }

        try
        {
            baseService.save(ssidSecretEntity);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            basicJson.getErrorMsg().setCode("102200");
            basicJson.getErrorMsg().setDescription("添加失败,请重试");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    @RequestMapping(value = "/list")
    public TableData getList(TableFilter tableFilter,HttpServletRequest request)
    {
        TableData tableData=new TableData();
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");
        try
        {
            tableData=ssidSecretService.getList(tableFilter);
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
            tableData.getErrorMsg().setCode("1938340");
            tableData.getErrorMsg().setDescription("获取失败");
        }
        return tableData;
    }
}
