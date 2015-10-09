package estate.dao;

import estate.entity.database.FamilyEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-17.
 *
 */
public interface FamilyDao
{
    ArrayList<FamilyEntity> getFamilyEntitiesByOwnerId(Integer id);


    ArrayList<FamilyEntity> getFamilByPropertyID(Integer id);
}
