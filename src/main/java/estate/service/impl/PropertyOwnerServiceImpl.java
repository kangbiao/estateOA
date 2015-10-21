package estate.service.impl;

import estate.common.config.UserType;
import estate.dao.PropertyOwnerInfoDao;
import estate.dao.UserDao;
import estate.entity.database.PropertyOwnerInfoEntity;
import estate.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-13.
 *
 */
@Service("propertyOwnerService")
public class PropertyOwnerServiceImpl implements PropertyOwnerService
{

    @Autowired
    private PropertyOwnerInfoDao propertyOwnerInfoDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void deleteOwnerPropertyBind(String phone, Integer propertyID)
    {
        if(propertyOwnerInfoDao.getPropertiesByOwnerPhone(phone).size()==1)
        {
            userDao.deleteUserByPhone(phone, UserType.OWNER);
            userDao.deleteUserByPhone(phone, UserType.APPUSER);
        }
        propertyOwnerInfoDao.deleteByPhonePropertyID(phone, propertyID);
    }

    @Override
    public String getRoleStringByPhone(String phone)
    {
        ArrayList<PropertyOwnerInfoEntity> propertyOwnerInfoEntities=propertyOwnerInfoDao.getByPhone(phone);
        if (propertyOwnerInfoEntities!=null)
        {
            StringBuilder roleString=new StringBuilder();
            int temp=0;
            for (PropertyOwnerInfoEntity propertyOwnerInfoEntity:propertyOwnerInfoEntities)
            {
                if (temp==0)
                    roleString.append(propertyOwnerInfoEntity.getUserRole());
                else
                    roleString.append(",").append(propertyOwnerInfoEntity.getUserRole());
                temp++;
            }
            return roleString.toString();
        }

        return null;
    }

    @Override
    public ArrayList<PropertyOwnerInfoEntity> getByPhone(String phone)
    {
        return propertyOwnerInfoDao.getByPhone(phone);
    }

    @Override
    public ArrayList<PropertyOwnerInfoEntity> getBindBypropertyIDStatus(Integer propertyID, Byte status)
    {
        return propertyOwnerInfoDao.getBindBypropertyIDStatus(propertyID,status);
    }


}
