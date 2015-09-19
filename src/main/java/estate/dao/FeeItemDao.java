package estate.dao;

import estate.entity.database.FeeItemEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
public interface FeeItemDao
{
    Integer save(FeeItemEntity feeItemEntity);

    void delete(Integer feeItemID);

    FeeItemEntity get(Integer feeItemID);

    TableData getList(TableFilter tableFilter,int feeType);

    Integer count(int feeType);

}
