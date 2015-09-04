package estate.common.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by kangbiao on 15-8-28.
 * hibernate的工具类
 */
public class HibernateUtil
{
    private static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration configuration=new Configuration().configure();
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        }
        catch (Throwable ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
