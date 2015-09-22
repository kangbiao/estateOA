package estate.dao;

import estate.entity.database.BuildingEntity;

/**
 * Created by kangbiao on 15-9-22.
 */
public interface BuildingDao
{
    /**
     * 通过楼栋编码获取楼栋的所有信息
     * @param code
     * @return
     */
    BuildingEntity getByCode(String code);
}
