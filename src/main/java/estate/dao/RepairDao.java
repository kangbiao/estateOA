package estate.dao;

import estate.entity.database.RepairEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
public interface RepairDao
{
    TableData getList(TableFilter tableFilter);

    Integer count();

    void setRepairMan(RepairEntity repairEntity);
}
