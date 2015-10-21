package estate.dao.impl;

import estate.common.config.UserType;
import estate.dao.BaseDao;
import estate.dao.PropertyDao;
import estate.entity.database.PropertyEntity;
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
        StringBuilder hql=new StringBuilder("from PropertyEntity t ");
        if (tableFilter.getSearchValue()!=null)
        {
            hql.append("where (t.code like(:code) or t.location like(:location)) ");
            if (tableFilter.getStatus()!=null)
            {
                hql.append("and t.status=:status ");
                if (tableFilter.getType()!=null)
                {
                    hql.append("and t.type=:type ");
                    query=session.createQuery(hql.toString())
                            .setString("code","%"+tableFilter.getSearchValue()+"%")
                            .setString("location","%"+tableFilter.getSearchValue()+"%")
                            .setByte("status", tableFilter.getStatus())
                            .setByte("type", tableFilter.getType());
                }
                else
                {
                    query=session.createQuery(hql.toString())
                            .setString("code","%"+tableFilter.getSearchValue()+"%")
                            .setString("location","%"+tableFilter.getSearchValue()+"%")
                            .setByte("status",tableFilter.getStatus());
                }
            }
            else
            {
                if (tableFilter.getType()!=null)
                {
                    hql.append("and t.type=:type ");
                    query=session.createQuery(hql.toString())
                            .setString("code","%"+tableFilter.getSearchValue()+"%")
                            .setString("location", "%"+tableFilter.getSearchValue()+"%")
                            .setByte("type",tableFilter.getType());
                }
                else
                {
                    query=session.createQuery(hql.toString())
                            .setString("code", "%" + tableFilter.getSearchValue()+"%")
                            .setString("location", "%"+tableFilter.getSearchValue()+"%");
                }
            }
        }
        else
        {
            if (tableFilter.getStatus()!=null)
            {
                hql.append("where t.status=:status ");
                if (tableFilter.getType()!=null)
                {
                    hql.append("and t.type=:type ");
                    query=session.createQuery(hql.toString())
                            .setByte("status",tableFilter.getStatus())
                            .setByte("type",tableFilter.getType());
                }
                else
                {
                    query=session.createQuery(hql.toString())
                            .setByte("status",tableFilter.getStatus());
                }
            }
            else
            {
                if (tableFilter.getType()!=null)
                {
                    hql.append("where t.type=:type ");
                    query=session.createQuery(hql.toString())
                            .setByte("type",tableFilter.getType());
                }
                else
                {
                    query=session.createQuery(hql.toString());
                }
            }
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
        if (list.size()>0)
            return (ArrayList<PropertyEntity>) list;
        return null;
    }

    @Override
    public ArrayList<PropertyEntity> getPropertiesByPhoneRole(String phone, Byte role)
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
                hql="select t.propertyEntity from PropertyOwnerInfoEntity t where t.phone=:phone";
                break;
            default:
                return null;
        }
        List list=session.createQuery(hql).setString("phone",phone).list();
        if (list.size()>0)
            return (ArrayList<PropertyEntity>) list;
        else return null;
    }

    @Override
    public ArrayList<PropertyEntity> getAllProperty()
    {
        Session session=getSession();
        String hql="from PropertyEntity";
        List list=session.createQuery(hql).list();
        if (list.size()>0)
            return (ArrayList<PropertyEntity>) list;
        return null;
    }


}
