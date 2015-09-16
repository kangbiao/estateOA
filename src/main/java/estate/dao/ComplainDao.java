package estate.dao;

import estate.entity.database.ComplainEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-16.
 * 用户投诉dao
 */
public interface ComplainDao
{
    ComplainEntity get(Integer id);

    Integer save(ComplainEntity complainEntity);

    void delete(ComplainEntity complainEntity);

    TableData getList(TableFilter tableFilter);


}
