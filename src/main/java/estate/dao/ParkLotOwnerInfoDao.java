package estate.dao;

import estate.entity.database.ParklotOwnerInfoEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-16.
 *
 */
public interface ParkLotOwnerInfoDao
{
    /**
     * 通过车位id返回该车位对应的所用用户绑定关系
     * @param id
     * @return
     */
    ArrayList<ParklotOwnerInfoEntity> getByParkLotID(Integer id);
}
