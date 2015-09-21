package estate.dao.impl;

import estate.dao.SsidSecretDao;
import estate.entity.database.SsidSecretEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kangbiao on 15-9-21.
 *
 */
@Repository("ssidSecretDao")
public class SsidSecretDaoImpl implements SsidSecretDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public SsidSecretEntity getBySSID(String ssid)
    {
        Session session=getSession();
        String hql="from SsidSecretEntity s where s.ssid=:ssid";
        List list=session.createQuery(hql).setString("ssid",ssid).list();
        return (SsidSecretEntity)list.get(0);
    }
}
