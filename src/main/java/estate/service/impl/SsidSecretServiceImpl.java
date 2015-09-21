package estate.service.impl;

import estate.dao.SsidSecretDao;
import estate.entity.database.SsidSecretEntity;
import estate.service.SsidSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-21.
 *
 */
@Service("ssidSecretService")
public class SsidSecretServiceImpl implements SsidSecretService
{
    @Autowired
    SsidSecretDao ssidSecretDao;

    @Override
    public SsidSecretEntity getSelfBySsid(String ssid)
    {
        return ssidSecretDao.getBySSID(ssid);
    }
}
