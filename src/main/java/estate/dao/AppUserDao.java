package estate.dao;

import estate.entity.database.AppUserEntity;

/**
 * Created by kangbiao on 15-9-27.
 */
public interface AppUserDao
{
    AppUserEntity getByPhone(String phone);
}
