package estate.dao.impl;

import estate.dao.PropertyOwnerInfoDao;
import estate.entity.database.PropertyEntity;
import estate.entity.database.PropertyOwnerInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbiao on 15-9-26.
 *
 */
@Repository("propertyOwnerInfoDao")
public class PropertyOwnerInfoDaoImpl implements PropertyOwnerInfoDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public PropertyOwnerInfoEntity getByPropertyID(Integer id)
    {
        Session session=getSession();
        String hql="from PropertyOwnerInfoEntity t where t.propertyId=:id";
        List list=session.createQuery(hql).setInteger("id", id).list();
        if (list.size()>0)
            return (PropertyOwnerInfoEntity)list.get(0);
        else
            return null;
    }

    @Override
    public ArrayList<PropertyEntity> getPropertiesByOwnerPhone(String phone)
    {
        Session session=getSession();
        String hql="select t.propertyEntity from PropertyOwnerInfoEntity t where t.phone=:phone";
        List list=session.createQuery(hql).setString("phone",phone).list();
        if (list.size()>0)
            return (ArrayList<PropertyEntity>) list;
        return null;
    }

    @Override
    public void deleteByPhonePropertyID(String phone, Integer id)
    {
        Session session=getSession();
        String hql="delete from PropertyOwnerInfoEntity t where t.propertyId=:id and t.phone=:phone";
        session.createQuery(hql).setInteger("id",id).setString("phone",phone).executeUpdate();
    }

    @Override
    public ArrayList<PropertyOwnerInfoEntity> getByPhone(String phone)
    {
        Session session=getSession();
        String hql="from  PropertyOwnerInfoEntity t where t.phone=:phone";
        List list=session.createQuery(hql).setString("phone",phone).list();
        if (list.size()>0)
            return (ArrayList<PropertyOwnerInfoEntity>) list;
        return null;
    }

    @Override
    public ArrayList<PropertyOwnerInfoEntity> getBindBypropertyIDStatus(Integer propertyID, Byte status)
    {
        Session session=getSession();
        String hql;
        List list;
        if (status==null)
        {
            hql = "from  PropertyOwnerInfoEntity t where t.propertyId=:propertyID and t.userRole!=3";
            list = session.createQuery(hql).setInteger("propertyID", propertyID).list();
        }
        else
        {
            hql = "from  PropertyOwnerInfoEntity t where t.propertyId=:propertyID and t.status=:status and t.userRole!=3";
            list = session.createQuery(hql).setInteger("propertyID", propertyID).setByte("status", status).list();
        }
        if (list.size()>0)
            return (ArrayList<PropertyOwnerInfoEntity>) list;
        return null;
    }

    @Override
    public PropertyOwnerInfoEntity getByPhonePropertyID(String phone, Integer propertyID)
    {
        Session session=getSession();
        String hql="from PropertyOwnerInfoEntity t where t.propertyId=:propertyID and t.phone=:phone";

        List list=session.createQuery(hql).setInteger("propertyID",propertyID).setString("phone",phone).list();
        if (list.size()>0)
            return (PropertyOwnerInfoEntity) list.get(0);
        return null;
    }

}
