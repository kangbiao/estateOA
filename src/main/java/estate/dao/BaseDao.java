package estate.dao;

/**
 * Created by kangbiao on 15-9-16.
 * 定义每个DAO具有的基础的增删改查操作
 */
public interface BaseDao
{
    /**
     * 包含基础的增加和更新操作,适用于单个对象
     * @param object
     * @return
     */
    Integer save(Object object);

    /**
     * 根据ID获取某个对象
     * @param id
     * @return
     */
    Object get(Integer id,Object object);


    /**
     * 根据对象信息删除某个对象
     * @param object
     */
    void delete(Object object);


    /**
     * 根据sql语句计算总数
     * @param sql
     * @return
     */
    Integer count(String sql);

}
