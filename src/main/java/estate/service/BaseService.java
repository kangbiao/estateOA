package estate.service;

import java.io.Serializable;

/**
 * Created by kangbiao on 15-9-16.
 * 基础的
 */
public interface BaseService
{
    Integer save(Object object);

    Object get(Integer id,Object object);

    Object get(Serializable id,Class cls);

    Object get(Integer id,Class object);

    void delete(Object object);

}
