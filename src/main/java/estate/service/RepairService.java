package estate.service;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-15.
 * 维修服务
 */
public interface RepairService
{
    TableData getList(TableFilter tableFilter);

}
