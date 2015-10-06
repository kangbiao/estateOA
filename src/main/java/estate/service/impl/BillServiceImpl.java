package estate.service.impl;

import estate.dao.BillDao;
import estate.entity.database.BillEntity;
import estate.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
@Service("billService")
public class BillServiceImpl implements BillService
{
    @Autowired
    private BillDao billDao;

    @Override
    public ArrayList<BillEntity> getBillByPropertyID(Integer id)
    {
        return billDao.getByPropertyID(id);
    }
}
