package estate.dao;

import estate.entity.database.VillageEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-25.
 *
 */
public interface SearchDao
{
    ArrayList<VillageEntity> villageSearch(String name);
}
