package estate.dao;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-23.
 */
public interface ApartmentDao
{
    TableData getList(TableFilter tableFilter);
}
