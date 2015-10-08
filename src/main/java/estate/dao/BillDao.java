package estate.dao;

import estate.entity.database.BillEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public interface BillDao
{
    /**
     * 通过物业的id返回该物业对应的账单
     * @param id
     * @return
     */
    ArrayList<BillEntity> getByPropertyID(Integer id,Byte status);
}
