package estate.dao.impl;

import estate.dao.BuildingDao;
import estate.entity.database.BuildingEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kangbiao on 15-9-22.
 *
 */
@Repository("buildingDao")
public class BuildingDaoImpl implements BuildingDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public BuildingEntity getByCode(String code)
    {
        Session session=getSession();
        String hql="from BuildingEntity b where b.buildingCode=:code";
        List list=session.createQuery(hql).setString("code",code).list();
        if (list.size()==1)
            return (BuildingEntity)list.get(0);
        else
            return null;
    }
}
