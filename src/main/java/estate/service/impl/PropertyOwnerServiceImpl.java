package estate.service.impl;

import estate.common.UserType;
import estate.dao.PropertyOwnerInfoDao;
import estate.dao.UserDao;
import estate.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
