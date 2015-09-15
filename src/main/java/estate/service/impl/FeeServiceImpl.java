package estate.service.impl;

import estate.dao.FeeItemDao;
import estate.dao.RuleDao;
import estate.entity.database.FeeItemEntity;
import estate.entity.database.RuleEntity;
import estate.entity.json.TableFilter;
import estate.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
@Service("feeService")
public class FeeServiceImpl implements FeeService
{
    @Autowired
    private RuleDao ruleDao;

    @Autowired
    private FeeItemDao feeItemDao;


    public void estateFeeAdd(FeeItemEntity feeItemEntity)
    {
        RuleEntity ruleEntity=feeItemEntity.getRuleEntity();
        Integer ruleID=ruleDao.save(ruleEntity);

        feeItemEntity.setRuleId(ruleID);
        feeItemDao.save(feeItemEntity);
    }

    public ArrayList<FeeItemEntity> feeList(TableFilter tableFilter)
    {
        return feeItemDao.getList(tableFilter);
    }
}
