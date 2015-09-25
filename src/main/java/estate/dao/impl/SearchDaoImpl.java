package estate.dao.impl;

import estate.dao.SearchDao;
import estate.entity.database.VillageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbiao on 15-9-25.
 */
@Repository("searchDao")
public class SearchDaoImpl implements SearchDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public ArrayList<VillageEntity> villageSearch(String name)
    {
        Session session=getSession();
        ArrayList<VillageEntity> entities=new ArrayList<>();
        String hql="select v.name as name,v.id as villageId from VillageEntity v where v.name like (:name)";
        List list=session.createQuery(hql).setString("name","%"+name+"%").list();
        for (Object object:list)
        {
            Object[] objects=(Object[])object;
            VillageEntity villageEntity=new VillageEntity();
            villageEntity.setVillageId((Integer)objects[1]);
            villageEntity.setName((String)objects[0]);
            entities.add(villageEntity);
        }
        return entities;
    }
}
