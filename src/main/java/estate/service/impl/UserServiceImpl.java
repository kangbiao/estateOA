package estate.service.impl;

import estate.common.util.Convert;
import estate.dao.PropertyDao;
import estate.dao.UserDao;
import estate.entity.database.AppUserEntity;
import estate.entity.database.OwnerEntity;
import estate.entity.display.Owner;
import estate.entity.display.Property;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.BaseService;
import estate.service.PropertyService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kangbiao on 15-9-16.
 */
@Service("userService")
public class UserServiceImpl implements UserService,BaseService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyDao propertyDao;

    public Integer save(Object object)
    {
        return null;
    }

    public Object get(Integer id)
    {
        return null;
    }

    public void delete(Object object)
    {

    }

    public boolean add(AppUserEntity userEntity)
    {
        return false;
    }

    public boolean delete(String userID)
    {
        return false;
    }



    public TableData getOwnerList(TableFilter tableFilter)
    {
        TableData tableData=userDao.getOwnerList(tableFilter);
        ArrayList<OwnerEntity> entities= (ArrayList<OwnerEntity>) tableData.getJsonString();
        ArrayList<Owner> owners=new ArrayList<Owner>();
        for (OwnerEntity ownerEntity:entities)
        {
            Owner owner=new Owner();
            Set<Property> properties=new HashSet();
            owner.setName(ownerEntity.getName());
            owner.setPhone(ownerEntity.getPhone());
            owner.setSex(Convert.num2sex(ownerEntity.getSex()));
            owner.setIdentityType(Convert.num2idtype(ownerEntity.getIdentityType()));
            owner.setIdentityCode(ownerEntity.getIdentityCode());
            owner.setAuthenticationTime(Convert.num2time(ownerEntity.getAuthenticationTime()));
            owner.setBirthday(Convert.num2time(ownerEntity.getBirthday()));
            owner.setPropertyIdList(ownerEntity.getPropertyIdList());
            owner.setVehicleIdIst(ownerEntity.getVehicleIdIst());
            owner.setUrgentName(ownerEntity.getUrgentName());
            owner.setUrgentPhone(ownerEntity.getUrgentPhone());

//            properties.add(propertyDao.get(1));
//            properties.add(propertyService.get(1));
            owner.setPropertyEntities(propertyService.getPropertiesByString(ownerEntity.getPropertyIdList()));

//            owner.setPropertyEntities(properties);

            owners.add(owner);
        }
        tableData.setJsonString(owners);
        return tableData;
    }

    public TableData getTenantList(TableFilter tableFilter)
    {
        return null;
    }

    public TableData getAuthenticatedUserList(TableFilter tableFilter)
    {
        return null;
    }
}
