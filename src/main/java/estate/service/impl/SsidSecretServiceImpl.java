package estate.service.impl;

import estate.dao.BaseDao;
import estate.dao.SsidSecretDao;
import estate.entity.database.SsidSecretEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
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
    @Autowired
    BaseDao baseDao;

    @Override
    public SsidSecretEntity getSelfBySsid(String ssid)
    {
        return ssidSecretDao.getBySSID(ssid);
    }

    @Override
    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData=ssidSecretDao.getList(tableFilter);
        tableData.setRecordsTotal(baseDao.count("SsidSecretEntity"));
        return tableData;

    }
}
