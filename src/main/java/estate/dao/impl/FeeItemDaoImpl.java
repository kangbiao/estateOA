package estate.dao.impl;

import estate.dao.FeeItemDao;
import estate.entity.database.FeeItemEntity;
import estate.entity.json.TableFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
@Repository("feeItemDao")
public class FeeItemDaoImpl implements FeeItemDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    public Integer save(FeeItemEntity feeItemEntity)
    {
        Session session=getSession();
        session.saveOrUpdate(feeItemEntity);
        return feeItemEntity.getFiId();
    }

    public void delete(Integer feeItemID)
    {
        Session session=getSession();
        String hql="delete from FeeItemEntity f where f.fiId=?";
        session.createQuery(hql).setInteger(0, feeItemID);
    }

    public FeeItemEntity get(Integer feeItemID)
    {
        return (FeeItemEntity)getSession().get(FeeItemEntity.class,feeItemID);
    }

    public ArrayList<FeeItemEntity> getList(TableFilter tableFilter)
    {
        Session session=getSession();
        ArrayList<FeeItemEntity> entities=new ArrayList<FeeItemEntity>();
        String hql="from FeeItemEntity f , RuleEntity r where r.ruleId=f.ruleId";
        Query query=session.createQuery(hql);
        Integer count=query.list().size();
        query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter.getLength());

        for (int i=0;i<query.list().size();i++)
        {
            Object[] objects = (Object[]) query.list().get(i);
            entities.add((FeeItemEntity)objects[0]);
        }
        return entities;
    }
}
