package estate.dao;

import estate.entity.database.FeeItemEntity;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
public interface FeeItemDao
{
    Integer save(FeeItemEntity feeItemEntity);

    void delete(Integer feeItemID);

    FeeItemEntity get(Integer feeItemID);

    ArrayList<FeeItemEntity> getList(TableFilter tableFilter);

}
