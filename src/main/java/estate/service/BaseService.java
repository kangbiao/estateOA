package estate.service;

/**
 * Created by kangbiao on 15-9-16.
 * 基础的
 */
public interface BaseService
{
    Integer save(Object object);

    Object get(Integer id,Object object);

    void delete(Object object);

}
