package estate.dao.impl;

import estate.dao.PropertyDao;
import estate.entity.database.PropertyEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
@Repository("propertyDao")
public class PropertyDaoImpl implements PropertyDao
{
    @Autowired
    private SessionFactory sessionFactory;

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
        return null;
    }


}
