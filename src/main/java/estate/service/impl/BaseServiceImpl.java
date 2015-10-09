package estate.service.impl;

import estate.dao.BaseDao;
import estate.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by kangbiao on 15-9-21.
 *
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService
{
    @Autowired
    private BaseDao baseDao;

    @Override
    public Integer save(Object object)
    {
        return baseDao.save(object);
    }

    @Override
    public Object get(Integer id, Object object)
    {
        return baseDao.get(id,object);
    }

    @Override
    public Object get(Serializable id, Class cls)
    {
        return baseDao.get(id,cls);
    }

    @Override
    public Object get(Integer id, Class cls)
    {
        return baseDao.get(id,cls);
    }

    @Override
    public void delete(Object object)
    {
        baseDao.delete(object);
    }
}
