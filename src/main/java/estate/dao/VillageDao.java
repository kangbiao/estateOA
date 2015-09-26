package estate.dao;

import estate.entity.database.VillageEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-26.
 *
 */
public interface VillageDao
{
    /**
     * select2的格式将所有的园区返回
     * @return
     */
    ArrayList<VillageEntity> getAllVillage();
}
