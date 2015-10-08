package estate.service.impl;

import com.google.gson.Gson;
import estate.common.FeeRuleUnit;
import estate.common.util.Convert;
import estate.common.util.LogUtil;
import estate.dao.*;
import estate.entity.database.AppUserEntity;
import estate.entity.database.BillEntity;
import estate.entity.database.FeeItemOrderEntity;
import estate.entity.database.PropertyEntity;
import estate.exception.PropertyNotBindFeeItemException;
import estate.exception.UserTypeErrorException;
import estate.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Autowired
    private BaseDao baseDao;

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
    public void generateBillByPropertyID(Integer id) throws PropertyNotBindFeeItemException
    {
        ArrayList<FeeItemOrderEntity> feeItemOrderEntities =feeItemOrderDao.getFeeItemOrdersByPropertyID(id);
        PropertyEntity propertyEntity= (PropertyEntity) baseDao.get(id,PropertyEntity.class);

        if (feeItemOrderEntities==null)
        {
            throw new PropertyNotBindFeeItemException("该物业未绑定任何费用!");
        }

        StringBuilder billInfo=new StringBuilder("");
        BillEntity billEntity=new BillEntity();

        //判断是否已经生成过账单,若是则更新
        ArrayList<BillEntity> billEntities=billDao.getByPropertyID(id, new Byte("0"));
        if (billEntities.size()>0)
        {
            for (BillEntity billEntityTemp:billEntities)
            {
                String lastGenerateTime= Convert.num2time(billEntityTemp.getBillGenerationTime(), "yyyy-MM");
                String now=Convert.num2time(System.currentTimeMillis(),"yyyy-MM");
                if (now.equals(lastGenerateTime))
                {
                    LogUtil.E("已经生成账单");
                    billEntity=billEntityTemp;
                }
            }
        }

        int temp=0;
        for (FeeItemOrderEntity feeItemOrderEntity:feeItemOrderEntities)
        {
//            Gson gson=new Gson();
//            LogUtil.E(gson.toJson(feeItemOrderEntity));
            //TODO 如果是服务费的话,生成账单后需要删除该订购
            String kv;
            if (feeItemOrderEntity.getFeeItemEntity().getRuleEntity().getUnit().equals(FeeRuleUnit.SQURE))
            {
                Double unitPrice=new Double(feeItemOrderEntity.getFeeItemEntity().getRuleEntity()
                        .getUnitPrice());
                Double aDouble=unitPrice*propertyEntity.getPropertySquare().doubleValue();
                BigDecimal sum=new BigDecimal(aDouble);
                sum=sum.setScale(2,BigDecimal.ROUND_HALF_UP);
                kv=feeItemOrderEntity.getFeeItemEntity().getName()+":"+sum;
                LogUtil.E("费用名:按面积收费"+feeItemOrderEntity.getFeeItemEntity().getName()+"   费用总价:"+sum);
            }
            else
            {
                LogUtil.E("费用名:"+feeItemOrderEntity.getFeeItemEntity().getName()+"   费用总价:"+feeItemOrderEntity
                        .getFeeItemEntity().getRuleEntity().getUnitPrice());
                kv=feeItemOrderEntity.getFeeItemEntity().getName()+":"+feeItemOrderEntity
                        .getFeeItemEntity().getRuleEntity().getUnitPrice();
            }
            if (temp==0)
            {
                billInfo.append(kv);
            }
            else
            {
                kv=";"+kv;
                billInfo.append(kv);
            }

            temp++;
        }
        billEntity.setFeeItemFee(billInfo.toString());
        billEntity.setPayStatus(new Byte("0"));
        billEntity.setPropertyId(id);
        billEntity.setBillGenerationTime(System.currentTimeMillis());

        Gson gson=new Gson();
        LogUtil.E(gson.toJson(billEntity));

        baseDao.save(billEntity);
    }
}
