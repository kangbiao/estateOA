package estate.service.impl;

import estate.common.config.UserType;
import estate.dao.PropertyOwnerInfoDao;
import estate.dao.UserDao;
import estate.entity.app.BindPropertyAppUser;
import estate.entity.app.BindUserInfo;
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

    @Override
    public ArrayList<BindPropertyAppUser> getBindInfoByOwnerInfo(String phone, Byte status)
    {
        ArrayList<PropertyOwnerInfoEntity> propertyOwnerInfoEntities = propertyOwnerInfoDao.getByPhone(phone);
        ArrayList<BindPropertyAppUser> bindPropertyAppUsers=new ArrayList<>();

        //若该业主没有物业,则直接返回null
        if (propertyOwnerInfoEntities==null)
            return null;

        //对业主的每个物业循环
        for (PropertyOwnerInfoEntity propertyOwnerInfoEntity:propertyOwnerInfoEntities)
        {
            if (propertyOwnerInfoEntity.getUserRole().equals(UserType.OWNER))
            {
                //获取到每个物业绑定的非业主用户
                ArrayList<PropertyOwnerInfoEntity> propertyOwnerInfoEntities1 = propertyOwnerInfoDao.
                        getBindBypropertyIDStatus(propertyOwnerInfoEntity.getPropertyId(), status);
                if (propertyOwnerInfoEntities1!=null)
                {
                    ArrayList<BindUserInfo> bindUserInfos = new ArrayList<>();
                    for (PropertyOwnerInfoEntity propertyOwnerInfoEntity1 : propertyOwnerInfoEntities1)
                    {
                        BindUserInfo bindUserInfo = new BindUserInfo();
                        bindUserInfo.setStatus(propertyOwnerInfoEntity1.getStatus());
                        bindUserInfo.setRole(propertyOwnerInfoEntity1.getUserRole());
                        bindUserInfo.setAppUserEntity(propertyOwnerInfoEntity1.getAppUserEntity());
                        bindUserInfo.setBindId(propertyOwnerInfoEntity1.getId());
                        bindUserInfos.add(bindUserInfo);
                    }

                    //若该物业有绑定关系,则添加,否则丢弃
                    if (bindUserInfos.size() > 0)
                    {
                        BindPropertyAppUser bindPropertyAppUser = new BindPropertyAppUser();
                        bindPropertyAppUser.setPropertyEntity(propertyOwnerInfoEntity.getPropertyEntity());
                        bindPropertyAppUser.setBindUserInfos(bindUserInfos);
                        bindPropertyAppUsers.add(bindPropertyAppUser);
                    }
                }
            }
        }
        if (bindPropertyAppUsers.size()>0)
        {
            return bindPropertyAppUsers;
        }

        return null;
    }


}
