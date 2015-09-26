package estate.dao;

import estate.entity.database.PropertyOwnerInfoEntity;

/**
 * Created by kangbiao on 15-9-26.
 *
 */
public interface PropertyOwnerInfoDao
{
    PropertyOwnerInfoEntity getByPropertyID(Integer id);

}
