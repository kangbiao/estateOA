package estate.dao;

import estate.entity.database.SsidSecretEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-21.
 */
public interface SsidSecretDao
{
    /**
     * 通过ssid返回SsidSecretEntity实体
     * @param ssid
     * @return
     */
    SsidSecretEntity getBySSID(String ssid);

    /**
     * 获取供datatable显示的数据
     * @param tableFilter
     * @return
     */
    TableData getList(TableFilter tableFilter);
}
