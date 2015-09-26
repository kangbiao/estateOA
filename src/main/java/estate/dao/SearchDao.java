package estate.dao;

import estate.entity.database.VillageEntity;
import estate.entity.json.Select2;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-25.
 *
 */
public interface SearchDao
{
    ArrayList<VillageEntity> villageSearch(String name);

    /**
     * 通过用户的电话匹配返回相应的用户
     * @param phone
     * @return
     */
    ArrayList<Select2> ownerSearch(String phone);
}
