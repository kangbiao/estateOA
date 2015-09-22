package estate.service;

import estate.entity.database.SsidSecretEntity;

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

}
