package estate.service;

import estate.entity.database.ComplainEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface ComplainService
{
    /**
     * 返回投诉列表
     * @param tableFilter
     * @return
     */
    TableData getList(TableFilter tableFilter);

    /**
     *处理投诉
     * @param complainEntity
     */
    void dealComplain(ComplainEntity complainEntity);

}
