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
        return feeItemEntity.getId();
    }

    public void delete(Integer feeItemID)
    {
        Session session=getSession();
        String sql= "delete from RuleEntity r where r.ruleId=:ruleid";
        Integer ruleID=this.get(feeItemID).getRuleId();

        String hql="delete from FeeItemEntity f where f.id=:fiid";
        session.createQuery(hql).setInteger("fiid", feeItemID).executeUpdate();
        session.createQuery(sql).setInteger("ruleid",ruleID).executeUpdate();
    }

    public FeeItemEntity get(Integer feeItemID)
    {
        return (FeeItemEntity)getSession().get(FeeItemEntity.class,feeItemID);
    }

    public TableData getList(TableFilter tableFilter,int feeType)
    {
        Session session=getSession();
        TableData tableData=new TableData(true);
        ArrayList<FeeItemEntity> entities= new ArrayList<>();
        Query query;

        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql="from FeeItemEntity f , RuleEntity r where r.ruleId=f.ruleId and f.name like (:name) and f.feeTypeId=:id";
            query=session.createQuery(hql).setString("name","%"+tableFilter.getSearchValue()+"%").setInteger("id",
                    feeType);
        }
        else
        {
            String hql = "from FeeItemEntity f , RuleEntity r where r.ruleId=f.ruleId and f.feeTypeId=:id";
            query = session.createQuery(hql).setInteger("id",feeType);
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
        String hql="select count(*) from FeeItemEntity f where f.feeTypeId=:id";
        return ((Long)session.createQuery(hql).setInteger("id",feeType).uniqueResult()).intValue();
    }
}
