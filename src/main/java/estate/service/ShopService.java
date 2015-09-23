package estate.service;

import estate.entity.database.PropertyEntity;
import estate.entity.database.ShopEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-23.
 *
 */
public interface ShopService
{
    TableData getList(TableFilter tableFilter);

    /**
     * 保存一个商户的信息
     * @param propertyEntity
     * @param shopEntity
     * @return
     */
    Integer saveShop(PropertyEntity propertyEntity,ShopEntity shopEntity);
}
