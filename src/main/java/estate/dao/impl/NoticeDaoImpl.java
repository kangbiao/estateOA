package estate.dao.impl;

import estate.dao.NoticeDao;
import estate.entity.database.NoticeEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
@Repository(value = "NoticeDao")
public class NoticeDaoImpl implements NoticeDao
{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public ArrayList<NoticeEntity> getSome(Integer num)
    {
        ArrayList<NoticeEntity> entities;
        Session session=getSession();
        String hql="from NoticeEntity n order by n.time desc ";
        Query query=session.createQuery(hql).setFirstResult(0).setMaxResults(num);
        entities= (ArrayList<NoticeEntity>) query.list();
        return entities;
    }

    public TableData getList(TableFilter tableFilter)
    {
        Session session=getSession();
        TableData tableData=new TableData();
        ArrayList<NoticeEntity> entities;
        Query query;

        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql="from NoticeEntity n where n.title like (?)";
            query=session.createQuery(hql).setString(0,"%"+tableFilter.getSearchValue()+"%");
        }
        else
        {
            String hql = "from NoticeEntity n";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        entities=(ArrayList<NoticeEntity>)query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter
                .getLength()).list();
        tableData.setRecordsFiltered(count);
        tableData.setJsonString(entities);
        return tableData;
    }
}
