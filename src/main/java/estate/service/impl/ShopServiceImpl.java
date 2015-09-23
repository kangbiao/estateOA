package estate.service.impl;

import estate.dao.BaseDao;
import estate.dao.ShopDao;
import estate.entity.database.PropertyEntity;
import estate.entity.database.ShopEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by kangbiao on 15-9-23.
 *
 */
@Repository("shopService")
public class ShopServiceImpl implements ShopService
{
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private BaseDao baseDao;

    @Override
    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData = shopDao.getList(tableFilter);
        tableData.setRecordsTotal(baseDao.count("ShopEntity"));
        return tableData;
    }

    @Override
    public Integer saveShop(PropertyEntity propertyEntity, ShopEntity shopEntity)
    {
        Integer propertyID=baseDao.save(propertyEntity);
        shopEntity.setPropertyId(propertyID);
        return baseDao.save(shopEntity);
    }
}
