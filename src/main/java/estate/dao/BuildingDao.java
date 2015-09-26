package estate.dao;

import estate.entity.database.BuildingEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-22.
 *
 */
public interface BuildingDao
{
    /**
     * 通过楼栋编码获取楼栋的所有信息
     * @param code
     * @return
     */
    BuildingEntity getByCode(String code);

    /**
     * 通过园区id获取该园区对应的所有楼栋信息
     * @param id
     * @return
     */
    ArrayList<BuildingEntity> getAllBuildingsByVillageId(Integer id);
}
