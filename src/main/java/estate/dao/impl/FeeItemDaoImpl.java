package estate.dao.impl;

import estate.dao.FeeItemDao;
import estate.entity.database.FeeItemEntity;
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

    public TableData getList(TableFilter tableFilter,int feeType)
    {
        Session session=getSession();
        TableData tableData=new TableData(true);
        ArrayList<FeeItemEntity> entities=new ArrayList<FeeItemEntity>();
        Query query;

        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql="from FeeItemEntity f , RuleEntity r where r.ruleId=f.ruleId and f.name like (?) and f.feeTypeId=?";
            query=session.createQuery(hql).setString(0,"%"+tableFilter.getSearchValue()+"%").setInteger(1,feeType);
        }
        else
        {
            String hql = "from FeeItemEntity f , RuleEntity r where r.ruleId=f.ruleId and f.feeTypeId=?";
            query = session.createQuery(hql).setInteger(0,feeType);
        }
        Integer count=query.list().size();
        query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter.getLength());
        List list=query.list();
        for (Object aList : list)
        {
            Object[] objects = (Object[]) aList;
            FeeItemEntity feeItemEntity=(FeeItemEntity) objects[0];
            String[] array=feeItemEntity.getName().split(";");
            feeItemEntity.setName(array[0]);
            try
            {
                feeItemEntity.setPayStartTime(array[1]);
                feeItemEntity.setPayEndTime(array[2]);
            }
            catch (Exception ignored){}
            entities.add(feeItemEntity);
        }
        tableData.setRecordsTotal(this.count(feeType));
        tableData.setRecordsFiltered(count);
        tableData.setJsonString(entities);
        return tableData;
    }

    public Integer count(int feeType)
    {
        Session session=getSession();
        String hql="select count(*) from FeeItemEntity f where f.feeTypeId=?";
        return ((Long)session.createQuery(hql).setInteger(0,feeType).uniqueResult()).intValue();
    }
}
