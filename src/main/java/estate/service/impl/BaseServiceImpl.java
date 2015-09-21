package estate.service.impl;

import estate.dao.BaseDao;
import estate.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void delete(Object object)
    {
        baseDao.delete(object);
    }
}
