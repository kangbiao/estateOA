package estate.service.impl;

import estate.dao.BaseDao;
import estate.dao.ParkLotDao;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.ParkLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-10-15.
 *
 */
@Service("parkLotService")
public class ParkLotServiceImpl implements ParkLotService
{

    @Autowired
    private ParkLotDao parkLotDao;
    @Autowired
    private BaseDao baseDao;

    @Override
    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData=parkLotDao.getList(tableFilter);
        tableData.setRecordsTotal(baseDao.count("ParkingLotEntity"));
        return tableData;
    }
}
