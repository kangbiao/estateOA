package estate.dao;

import estate.entity.database.ConsoleUserEntity;

/**
 * Created by kangbiao on 15-9-16.
 */
public interface ConsoleUserDao
{
    ConsoleUserEntity getConsoleUserByPhone(String phone);


}
