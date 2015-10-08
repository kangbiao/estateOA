package estate.service;

import estate.entity.database.BillEntity;
import estate.exception.PropertyNotBindFeeItemException;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public interface BillService
{
    /**
     * 通过物业的id获取该物业对应的账单
     * @param id
     * @return
     */
    ArrayList<BillEntity> getBillByPropertyID(Integer id);

    /**
     * 通过app用户的电话获取账单信息
     * @param phone
     * @return
     */
    ArrayList<BillEntity> getBillByAppUserPhone(String phone,Byte status);

    /**
     * 根据物业id生成这个物业的账单
     * @param id
     */
    void generateBillByPropertyID(Integer id) throws PropertyNotBindFeeItemException;
}
