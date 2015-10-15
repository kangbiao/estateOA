package estate.dao;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-10-15.
 *
 */
public interface ParkLotDao
{
    TableData getList(TableFilter tableFilter);
}
