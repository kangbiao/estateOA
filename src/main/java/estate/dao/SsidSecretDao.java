package estate.dao;

import estate.entity.database.SsidSecretEntity;

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
}
