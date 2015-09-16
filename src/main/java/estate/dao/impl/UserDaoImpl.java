package estate.dao.impl;

import estate.dao.BaseDao;
import estate.dao.UserDao;
import estate.entity.database.AppUserEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kangbiao on 15-9-16.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao, BaseDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    public Integer save(Object object)
    {
        return null;
    }

    public Object get(Integer id)
    {
        return null;
    }

    public void delete(Object object)
    {

    }


    public AppUserEntity getUserByPhone(String phone)
    {
        return null;
    }

    public TableData getOwnerList(TableFilter tableFilter)
    {
        Session session = getSession();
        TableData tableData = new TableData(true);
        Query query;
        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql = "from OwnerEntity o where o.name like (?) or o.phone like (?)";
            query = session.createQuery(hql).setString(0, "%" + tableFilter.getSearchValue() + "%")
                    .setString(1, "%" + tableFilter.getSearchValue() + "%");
        }
        else
        {
            String hql = "from OwnerEntity o";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        List list=query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter.getLength()).list();

        tableData.setRecordsFiltered(count);
        tableData.setJsonString(list);
        tableData.setRecordsTotal(this.ownerCount());

        return tableData;
    }

    public Integer ownerCount()
    {
        Session session=getSession();
        String hql="select count(*) from OwnerEntity ";
        return ((Long)session.createQuery(hql).uniqueResult()).intValue();
    }


    public TableData getTenantList(TableFilter tableFilter)
    {
        return null;
    }

    public TableData getAuthenticatedUserList(TableFilter tableFilter)
    {
        return null;
    }
}
