package estate.service.impl;

import estate.dao.ComplainDao;
import estate.entity.database.ComplainEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-16.
 */
@Service("complainService")
public class ComplainServiceImpl implements ComplainService
{
    @Autowired
    ComplainDao complainDao;

    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData=complainDao.getList(tableFilter);

        return tableData;
    }

    public void dealComplain(ComplainEntity complainEntity)
    {

    }
}
