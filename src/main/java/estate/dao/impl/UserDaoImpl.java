package estate.dao.impl;

import estate.common.UserType;
import estate.dao.UserDao;
import estate.entity.database.AppUserEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kangbiao on 15-9-16.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao
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
        System.out.print("dsfds");
        return null;
    }

    @Test
    public void test ()
    {
        this.getUserByPhone("18122392");
        System.out.print("dsfds");
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
        tableData.setRecordsTotal(this.count("OwnerEntity"));

        return tableData;
    }

    public Integer count(String table)
    {
        Session session=getSession();
        String hql="select count(*) from "+table;
        return ((Long)session.createQuery(hql).uniqueResult()).intValue();
    }


    public TableData getTenantList(TableFilter tableFilter)
    {
        Session session = getSession();
        TableData tableData = new TableData(true);
        Query query;
        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql = "from TenantEntity t where t.name like (?) or t.phone like (?)";
            query = session.createQuery(hql).setString(0, "%" + tableFilter.getSearchValue() + "%")
                    .setString(1, "%" + tableFilter.getSearchValue() + "%");
        }
        else
        {
            String hql = "from TenantEntity t";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        List list=query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter.getLength()).list();

        tableData.setRecordsFiltered(count);
        tableData.setJsonString(list);
        tableData.setRecordsTotal(this.count("TenantEntity"));

        return tableData;
    }



    public TableData getAuthenticatedUserList(TableFilter tableFilter)
    {
        Session session = getSession();
        TableData tableData = new TableData(true);
        Query query;
        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql = "from AuthenticatedUserEntity t where t.name like (?)";
            query = session.createQuery(hql).setString(0, "%" + tableFilter.getSearchValue() + "%");
        }
        else
        {
            String hql = "from AuthenticatedUserEntity t";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        List list=query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter.getLength()).list();

        tableData.setRecordsFiltered(count);
        tableData.setJsonString(list);
        tableData.setRecordsTotal(this.count("AuthenticatedUserEntity"));

        return tableData;
    }

    @Override
    public TableData getAppUserList(TableFilter tableFilter)
    {
        Session session = getSession();
        TableData tableData = new TableData(true);
        Query query;
        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql = "from AppUserEntity t where t.userName like (?)";
            query = session.createQuery(hql).setString(0, "%" + tableFilter.getSearchValue() + "%");
        }
        else
        {
            String hql = "from AppUserEntity t";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        List list=query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter.getLength()).list();

        tableData.setRecordsFiltered(count);
        tableData.setJsonString(list);
        tableData.setRecordsTotal(this.count("AppUserEntity"));

        return tableData;
    }

    @Override
    public Object getUserInfoBYPhone(String phone, int type)
    {
        Session session=getSession();
        String hql;
        if (type== UserType.TENANT)
            hql="from TenantEntity t where t.phone=:phone";
        else if (type==UserType.FAMILY)
            hql="from FamilyEntity t where t.phone=:phone";
        else if (type==UserType.APPUSER)
            hql="from AppUserEntity t where t.phone=:phone";
        else
            hql="from OwnerEntity t where t.phone=:phone";
        List list=session.createQuery(hql).setString("phone",phone).list();
        if (list.size()>0)
            return list.get(0);
        else
            return null;
    }

    @Override
    public void deleteUserByPhone(String phone, int type)
    {
        Session session=getSession();
        String hql;
        if (type==UserType.OWNER)
            hql="delete from OwnerEntity t where t.phone=:phone";
        else if (type==UserType.APPUSER)
            hql="delete from AppUserEntity t where t.phone=:phone";
        else if (type==UserType.TENANT)
            hql="delete from TenantEntity t where t.phone=:phone";
        else if (type==UserType.FAMILY)
            hql="delete from FamilyEntity t where t.phone=:phone";
        else
        return;
        session.createQuery(hql).setString("phone",phone).executeUpdate();
    }
}
