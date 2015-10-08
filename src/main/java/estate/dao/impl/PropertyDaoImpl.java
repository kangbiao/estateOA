package estate.dao.impl;

import estate.common.UserType;
import estate.common.util.LogUtil;
import estate.dao.BaseDao;
import estate.dao.PropertyDao;
import estate.entity.database.PropertyEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.exception.UserTypeErrorException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
@Repository("propertyDao")
public class PropertyDaoImpl implements PropertyDao
{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private BaseDao baseDao;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    public Integer save(PropertyEntity object)
    {
        return null;
    }

    public PropertyEntity get(Integer id)
    {
        return (PropertyEntity)getSession().get(PropertyEntity.class, id);
    }

    public void delete(PropertyEntity object)
    {

    }

    @Override
    public TableData getList(TableFilter tableFilter)
    {
        Session session=getSession();
        TableData tableData=new TableData();
        ArrayList<PropertyEntity> entities;
        Query query;

        if (!tableFilter.getSearchValue().equals(""))
        {
            String hql="from PropertyEntity n where n.code like (?)";
            query=session.createQuery(hql).setString(0,"%"+tableFilter.getSearchValue()+"%");
        }
        else
        {
            String hql = "from PropertyEntity n";
            query = session.createQuery(hql);
        }
        Integer count=query.list().size();
        entities=(ArrayList<PropertyEntity>)query.setFirstResult(tableFilter.getStart()).setMaxResults(tableFilter
                .getLength()).list();
        tableData.setRecordsFiltered(count);
        tableData.setJsonString(entities);
        return tableData;
    }

    @Override
    public ArrayList<PropertyEntity> getPropertyByBuildingID(Integer id)
    {
        Session session=getSession();
        String hql="from PropertyEntity t where t.buildingId=:id";
        List list=session.createQuery(hql).setInteger("id", id).list();
        return (ArrayList<PropertyEntity>) list;
    }

    @Override
    public ArrayList<PropertyEntity> getPropertiesByPhoneRole(String phone, int role) throws UserTypeErrorException
    {
        Session session=getSession();
        String hql;
        switch (role)
        {
            case UserType.FAMILY:
                hql="select p from FamilyEntity t ,PropertyEntity p where t.phone=:phone and p.id=t.propertyId";
                break;
            case UserType.TENANT:
                hql="select p from TenantEntity t ,PropertyEntity p where t.phone=:phone and p.id=t.propertyId";
                break;
            case UserType.OWNER:
                hql="select t.propertyEntity from PropertyOwnerInfoEntity t where t.ownerPhone=:phone";
                LogUtil.E(hql);
                break;
            default:
                throw new UserTypeErrorException("用户类型错误!");
        }
        List list=session.createQuery(hql).setString("phone",phone).list();
        return (ArrayList<PropertyEntity>) list;
    }

    @Override
    public ArrayList<PropertyEntity> getAllProperty()
    {
        Session session=getSession();
        String hql="from PropertyEntity";
        List list=session.createQuery(hql).list();

        return (ArrayList<PropertyEntity>) list;
    }


}
