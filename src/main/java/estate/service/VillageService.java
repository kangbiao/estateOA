package estate.service;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-10-15.
 *
 */
public interface VillageService
{
    /**
     * 获取datatable表格数据
     * @param tableFilter
     * @return
     */
    TableData getList(TableFilter tableFilter);
}
