package estate.dao;

import estate.entity.database.TenantEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-9.
 *
 */
public interface TenantDao
{
    ArrayList<TenantEntity> getTenantByPropertyID(Integer id);
}
