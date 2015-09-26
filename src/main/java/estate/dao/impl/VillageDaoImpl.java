package estate.dao.impl;

import estate.dao.VillageDao;
import estate.entity.database.VillageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-26.
 *
 */
@Repository("villageDao")
public class VillageDaoImpl implements VillageDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ArrayList<VillageEntity> getAllVillage()
    {
        Session session=getSession();
        String hql="from VillageEntity t";
        return (ArrayList<VillageEntity>) session.createQuery(hql).list();
    }
}
