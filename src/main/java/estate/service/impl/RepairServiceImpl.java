package estate.service.impl;

import estate.dao.RepairDao;
import estate.entity.database.RepairEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-15.
 */
@Service("repairService")
public class RepairServiceImpl implements RepairService
{
    @Autowired
    private RepairDao repairDao;

    public TableData getList(TableFilter tableFilter)
    {
        return repairDao.getList(tableFilter);
    }

    public void setRepairMan(RepairEntity repairEntity)
    {

        //TODO 写入数据库成功后调用短信发送接口
    }
}
