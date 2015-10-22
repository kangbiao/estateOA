package estate.dao;

import estate.entity.database.PropertyEntity;
import estate.entity.database.PropertyOwnerInfoEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-26.
 *
 */
public interface PropertyOwnerInfoDao
{
    /**
     * 通过物业id查询是否有绑定
     * @param id
     * @return
     */
    PropertyOwnerInfoEntity getByPropertyID(Integer id);

    /**
     * 通过业主的电话返回该业主名下的所有物业信息实体
     * @param phone
     * @return
     */
    ArrayList<PropertyEntity> getPropertiesByOwnerPhone(String phone);


    void deleteByPhonePropertyID(String phone,Integer id);

    /**
     * 通过电话返回物业和用户的绑定关系
     * @param phone
     * @return
     */
    ArrayList<PropertyOwnerInfoEntity> getByPhone(String phone);


    /**
     * 通过物业id和状态返回
     * @param propertyID
     * @param status
     * @return
     */
    ArrayList<PropertyOwnerInfoEntity> getBindBypropertyIDStatus(Integer propertyID,Byte status);

    /**
     * 通过电话和物业id获取绑定关系
     * @param phone
     * @param propertyID
     * @return
     */
    PropertyOwnerInfoEntity getByPhonePropertyID(String phone , Integer propertyID);


}
