package estate.dao.impl;

import estate.dao.RepairDao;
import estate.entity.database.RepairEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 *
 * Created by kangbiao on 15-9-15.
 */
@Repository("repairDao")
public class RepairDaoImpl implements RepairDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    public TableData getList(TableFilter tableFilter)
    {
        Session session=getSession();
        TableData tableData=new TableData();
        ArrayList<RepairEntity> entities;
        Query query;

        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql="from RepairEntity r where r.title like (?)";
            query=session.createQuery(hql).setString(0,"%"+tableFilter.getSearchValue()+"%");
        }
        else
        {
            String hql = "from RepairEntity r";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        entities=(ArrayList<RepairEntity>)query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter
                .getLength()).list();

        tableData.setRecordsTotal(this.count());
        tableData.setRecordsFiltered(count);
        tableData.setJsonString(entities);
        return tableData;
    }

    public Integer count()
    {
        Session session=getSession();
        String hql="select count(*) from RepairEntity";
        return ((Long)session.createQuery(hql).uniqueResult()).intValue();
    }

    public void setRepairMan(RepairEntity repairEntity)
    {

    }
}
