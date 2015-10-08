package estate.service.impl;

import estate.common.util.LogUtil;
import estate.dao.AppUserDao;
import estate.dao.BillDao;
import estate.dao.FeeItemOrderDao;
import estate.dao.PropertyDao;
import estate.entity.database.AppUserEntity;
import estate.entity.database.BillEntity;
import estate.entity.database.FeeItemOrderEntity;
import estate.entity.database.PropertyEntity;
import estate.exception.UserTypeErrorException;
import estate.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
@Service("billService")
public class BillServiceImpl implements BillService
{
    @Autowired
    private BillDao billDao;
    @Autowired
    private PropertyDao propertyDao;
    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    private FeeItemOrderDao feeItemOrderDao;

    @Override
    public ArrayList<BillEntity> getBillByPropertyID(Integer id)
    {
        return billDao.getByPropertyID(id,null);
    }

    @Override
    public ArrayList<BillEntity> getBillByAppUserPhone(String phone,Byte status)
    {
        ArrayList<BillEntity> billEntities=new ArrayList<>();

        //通过电话获取用户类型
        AppUserEntity appUserEntity=appUserDao.getByPhone(phone);
        if (appUserEntity==null)
        {
            return null;
        }

        //先获取该用户所有的物业
        ArrayList<PropertyEntity> propertyEntities;
        try
        {
            propertyEntities = propertyDao.getPropertiesByPhoneRole(phone,appUserEntity.getUserRole());
        }
        catch (UserTypeErrorException e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }

        //遍历该用户绑定的物业,获取每个物业的账单
        for (PropertyEntity propertyEntity:propertyEntities)
        {
            ArrayList<BillEntity> billEntityArrayList=billDao.getByPropertyID(propertyEntity.getId(),status);
            billEntities.addAll(billEntityArrayList.stream().collect(Collectors.toList()));
        }
        return billEntities;
    }

    @Override
    public void generateBillByPropertyID(Integer id)
    {
        ArrayList<FeeItemOrderEntity> feeItemOrderEntities =feeItemOrderDao.getFeeItemOrdersByPropertyID(id);
        if (feeItemOrderEntities==null)
        {
            return;
        }
        for (FeeItemOrderEntity feeItemOrderEntity:feeItemOrderEntities)
        {
            LogUtil.E("feeitemid" + feeItemOrderEntity.getFeeItemId() + "   propertyid:" + id);
        }
    }
}
