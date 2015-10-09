package estate.dao;

import estate.entity.database.BillEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public interface BillDao
{

    /**
     * 返回datatable形式的数据
     * @param tableFilter
     * @return
     */
    TableData getList(TableFilter tableFilter);

    /**
     * 通过物业的id返回该物业对应的账单
     * @param id
     * @return
     */
    ArrayList<BillEntity> getByPropertyID(Integer id,Byte status);
}
