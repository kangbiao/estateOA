package estate.dao.impl;

import estate.common.util.LogUtil;
import estate.dao.FeeItemOrderDao;
import estate.entity.database.FeeItemOrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbiao on 15-9-24.
 *
 */
@Repository("feeItemOrderDao")
public class FeeItemOrderDaoImpl implements FeeItemOrderDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public ArrayList<FeeItemOrderEntity> getFeeItemOrdersByPropertyID(Integer id)
    {
        Session session=getSession();
        ArrayList arrayList=new ArrayList();
        String hql="from FeeItemOrderEntity a left join a.feeItemEntity b left join b.ruleEntity c where a.propertyId=:id";
        List list=session.createQuery(hql).setInteger("id",id).list();
        for (Object aList:list)
        {
            Object[] objects=(Object[])aList;
            LogUtil.E(String.valueOf(objects.length));
            arrayList.add(objects[0]);
        }
        return (ArrayList<FeeItemOrderEntity>) arrayList;
    }
}
