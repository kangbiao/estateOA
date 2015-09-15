package estate.service;

import estate.entity.database.RepairEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-15.
 * 维修服务
 */
public interface RepairService
{
    TableData getList(TableFilter tableFilter);

    /**
     * 设置维修人员,设置后还要向维修人员异步发送短信通知
     * @param repairEntity
     */
    void setRepairMan(RepairEntity repairEntity);

}
