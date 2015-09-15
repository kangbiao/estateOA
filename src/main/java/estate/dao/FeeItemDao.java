package estate.dao;

import estate.entity.database.FeeItemEntity;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
public interface FeeItemDao
{
    Integer save(FeeItemEntity feeItemEntity);

    void delete(Integer feeItemID);

    FeeItemEntity get(Integer feeItemID);


}
