package estate.dao.impl;

import estate.dao.BillDao;
import estate.entity.database.BillEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.hibernate.Query;
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
    public TableData getList(TableFilter tableFilter)
    {
        Session session=getSession();
        TableData tableData=new TableData();
        ArrayList<BillEntity> entities;
        Query query;

        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql="from BillEntity t where t.payStatus =:status";
            query=session.createQuery(hql).setByte("status", Byte.parseByte(tableFilter.getSearchValue()));
        }
        else
        {
            String hql = "from BillEntity n";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        entities=(ArrayList<BillEntity>)query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter
                .getLength()).list();
        tableData.setRecordsFiltered(count);
        tableData.setJsonString(entities);
        return tableData;
    }

    @Override
    public ArrayList<BillEntity> getByPropertyID(Integer id,Byte status)
    {
        Session session=getSession();
        List list;
        if (status!=null)
        {
            String hql="from BillEntity t where t.propertyId=:id and t.payStatus=:status";
            list=session.createQuery(hql).setInteger("id", id).setByte("status",status).list();
        }
        else
        {
            String hql="from BillEntity t where t.propertyId=:id";
            list=session.createQuery(hql).setInteger("id", id).list();
        }
        return (ArrayList<BillEntity>) list;
    }
}
