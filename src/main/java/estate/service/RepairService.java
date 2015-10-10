package estate.service;

import estate.entity.database.RepairEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

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
    String setRepairMan(RepairEntity repairEntity);

    /**
     * 通过用户的电话获取用户的报修信息
     * @param phone
     * @param status
     * @return
     */
    ArrayList<RepairEntity> getRepairByPhone(String phone,Byte status);
}
