package estate.service;

import estate.entity.database.SsidSecretEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-21.
 *
 */
public interface SsidSecretService
{
    /**
     * 通过SSID返回整个SsidSecretEntity对象
     * @param ssid
     * @return
     */
    SsidSecretEntity getSelfBySsid(String ssid);

    /**
     *
     */
    TableData getList(TableFilter tableFilter);
}
