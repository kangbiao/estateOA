package estate.service.impl;

import estate.common.RepairStatus;
import estate.common.util.Message;
import estate.dao.BaseDao;
import estate.dao.RepairDao;
import estate.entity.database.RepairEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
@Service("repairService")
public class RepairServiceImpl implements RepairService
{
    @Autowired
    private BaseDao baseDao;

    @Autowired
    private RepairDao repairDao;

    public TableData getList(TableFilter tableFilter)
    {
        return repairDao.getList(tableFilter);
    }

    public String setRepairMan(RepairEntity repairEntity)
    {
        RepairEntity repairEntity1=(RepairEntity)baseDao.get(repairEntity.getId(), repairEntity);
        if (repairEntity1==null)
            return "设置失败,请重试";
        repairEntity1.setRepirmanPhone(repairEntity.getRepirmanPhone());
        repairEntity1.setStatus(RepairStatus.PROCESSING);
        baseDao.save(repairEntity1);
        return Message.send(repairEntity.getRepirmanPhone(), "位于location1的用户:下水道坏了,请上门维修");
    }

    @Override
    public ArrayList<RepairEntity> getRepairByPhone(String phone, Byte status)
    {
        return repairDao.getByPhone(phone,status);
    }
}
