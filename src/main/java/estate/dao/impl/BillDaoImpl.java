package estate.dao.impl;

import estate.dao.BillDao;
import estate.entity.database.BillEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
@Repository("billDao")
public class BillDaoImpl implements BillDao
{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public ArrayList<BillEntity> getByPropertyID(Integer id)
    {
        Session session=getSession();
        String hql="from BillEntity t where t.propertyId=:id";
        List list=session.createQuery(hql).setInteger("id", id).list();
        return (ArrayList<BillEntity>) list;
    }
}
