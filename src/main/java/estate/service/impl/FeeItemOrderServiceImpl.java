package estate.service.impl;

import estate.dao.BaseDao;
import estate.service.FeeItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-24.
 *
 */
@Service("feeItemOrderService")
public class FeeItemOrderServiceImpl implements FeeItemOrderService
{
    @Autowired
    private BaseDao baseDao;

    @Override
    public ArrayList<Object> getFeeItemsByPropertyID(Integer id)
    {

        return null;
    }
}
