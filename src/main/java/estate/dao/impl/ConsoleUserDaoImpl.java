package estate.dao.impl;

import estate.dao.ConsoleUserDao;
import estate.entity.database.ConsoleUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
@Repository("consoleUserDao")
public class ConsoleUserDaoImpl implements ConsoleUserDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    public ConsoleUserEntity get(Integer id)
    {
        return (ConsoleUserEntity)getSession().get(ConsoleUserEntity.class,id);
    }

    public void delete(ConsoleUserEntity consoleUserEntity)
    {

    }

    public Integer save(ConsoleUserEntity consoleUserEntity)
    {
        return null;
    }
}
