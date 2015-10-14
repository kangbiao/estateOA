package estate.controller;

import estate.entity.database.ParkingLotEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-10-14.
 * 车位控制器
 */
@RestController
@RequestMapping("/web/parkLot")
public class ParkLotController
{

    /**
     * 获取datatable数据
     * @param tableFilter
     * @param request
     * @return
     */
    @RequestMapping(value = "/getList")
    public TableData getList(TableFilter tableFilter,HttpServletRequest request)
    {
        TableData tableData=new TableData();

        tableData.setStatus(true);
        return tableData;
    }


    /**
     * 增加车位信息
     * @param parkingLotEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/add")
    public BasicJson add(ParkingLotEntity parkingLotEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 根据车位id删除车位
     * @param parkLotID
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{parkLotID}")
    public BasicJson delete(@PathVariable Integer parkLotID,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();

        basicJson.setStatus(true);
        return basicJson;
    }




}
