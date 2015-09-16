package estate.dao;

import estate.entity.database.ConsoleUserEntity;

/**
 * Created by kangbiao on 15-9-16.
 */
public interface ConsoleUserDao
{
    ConsoleUserEntity get(Integer id);

    void delete(ConsoleUserEntity consoleUserEntity);

    Integer save(ConsoleUserEntity consoleUserEntity);
}
