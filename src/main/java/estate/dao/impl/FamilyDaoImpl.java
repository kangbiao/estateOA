package estate.dao.impl;

import estate.dao.FamilyDao;
import estate.entity.database.FamilyEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-17.
 *
 */
@Repository("familyDao")
public class FamilyDaoImpl extends SessionDaoImpl implements FamilyDao
{
    public ArrayList<FamilyEntity> getFamilyEntitiesByOwnerId(Integer id)
    {
        Session session=getSession();
        String hql="from FamilyEntity f where f.ownerId=?";
        return (ArrayList<FamilyEntity>) session.createQuery(hql).setInteger(0,id).list();
    }
}
