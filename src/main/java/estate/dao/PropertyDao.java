package estate.dao;

import estate.entity.database.PropertyEntity;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface PropertyDao
{
    /**
     * 包含基础的增加和更新操作,适用于单个对象
     * @param object
     * @return
     */
    Integer save(PropertyEntity object);

    /**
     * 根据ID获取某个对象
     * @param id
     * @return
     */
    PropertyEntity get(Integer id);

    /**
     * 根据对象信息删除某个对象
     * @param object
     */
    void delete(PropertyEntity object);

}
