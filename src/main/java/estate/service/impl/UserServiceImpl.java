package estate.service.impl;

import estate.common.UserType;
import estate.common.util.Convert;
import estate.dao.BaseDao;
import estate.dao.PropertyOwnerInfoDao;
import estate.dao.UserDao;
import estate.entity.database.AppUserEntity;
import estate.entity.database.OwnerEntity;
import estate.entity.database.TenantEntity;
import estate.entity.display.Owner;
import estate.entity.display.Tenant;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.exception.UserTypeErrorException;
import estate.service.FamilyService;
import estate.service.PropertyService;
import estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private FamilyService familyService;
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private PropertyOwnerInfoDao propertyOwnerInfoDao;



    public TableData getOwnerList(TableFilter tableFilter)
    {
        TableData tableData=userDao.getOwnerList(tableFilter);
        ArrayList<OwnerEntity> entities= (ArrayList<OwnerEntity>) tableData.getJsonString();
        ArrayList<Owner> owners= new ArrayList<>();
        for (OwnerEntity ownerEntity:entities)
        {
            Owner owner=new Owner();

            owner.setName(ownerEntity.getName());
            owner.setPhone(ownerEntity.getPhone());
            owner.setIdentityCode(ownerEntity.getIdentityCode());
            owner.setPropertyIdList(ownerEntity.getPropertyIdList());
            owner.setVehicleIdIst(ownerEntity.getVehicleIdIst());
            owner.setUrgentName(ownerEntity.getUrgentName());
            owner.setUrgentPhone(ownerEntity.getUrgentPhone());

            owner.setSex(Convert.num2sex(ownerEntity.getSex()));
            owner.setIdentityType(Convert.num2idtype(ownerEntity.getIdentityType()));
            owner.setAuthenticationTime(Convert.num2time(ownerEntity.getAuthenticationTime()));
            owner.setBirthday(Convert.num2time(ownerEntity.getBirthday()));

            owner.setFamilies(familyService.getFamiliesByOwnerID(ownerEntity.getId()));
//            owner.setPropertyEntities(propertyService.getPropertiesByString(ownerEntity.getPropertyIdList()));

            owners.add(owner);

        }
        tableData.setJsonString(owners);
        return tableData;
    }

    public TableData getTenantList(TableFilter tableFilter)
    {
        TableData tableData=userDao.getTenantList(tableFilter);
        ArrayList<TenantEntity> entities = (ArrayList<TenantEntity>) tableData.getJsonString();
        ArrayList<Tenant> tenans=new ArrayList<Tenant>();

        for(TenantEntity tenantEntity:entities)
        {
            Tenant tenant=new Tenant();

            tenant.setBirthday(Convert.num2time(tenantEntity.getBirthday()));
            tenant.setSex(Convert.num2sex(tenantEntity.getSex()));
            tenant.setName(tenantEntity.getName());
            tenant.setAuthenticationTime(Convert.num2time(tenantEntity.getAuthenticationTime()));
            tenant.setStartTime(Convert.num2time(tenantEntity.getStartTime()));
            tenant.setEndTime(Convert.num2time(tenantEntity.getEndTime()));
            tenant.setIdentityType(Convert.num2idtype(tenantEntity.getIdentityType()));
            tenant.setIdentityCode(tenantEntity.getIdentityCode());
            tenant.setPhone(tenantEntity.getPhone());
            tenant.setUrgentName(tenantEntity.getUrgentName());
            tenant.setUrgentPhone(tenantEntity.getUrgentPhone());

            tenans.add(tenant);
        }
        tableData.setJsonString(tenans);
        return tableData;
    }

    public TableData getAuthenticatedUserList(TableFilter tableFilter)
    {
        return null;
    }

    @Override
    public TableData getAppUserList(TableFilter tableFilter)
    {
        return userDao.getAppUserList(tableFilter);
    }

    public Owner getOnerInfoByID(Integer id)
    {
        OwnerEntity ownerEntity=new OwnerEntity();
        Owner owner=new Owner();
        ownerEntity=(OwnerEntity)baseDao.get(id,ownerEntity);

        owner.setName(ownerEntity.getName());
        owner.setPhone(ownerEntity.getPhone());
        owner.setIdentityCode(ownerEntity.getIdentityCode());
        owner.setPropertyIdList(ownerEntity.getPropertyIdList());
        owner.setVehicleIdIst(ownerEntity.getVehicleIdIst());
        owner.setUrgentName(ownerEntity.getUrgentName());
        owner.setUrgentPhone(ownerEntity.getUrgentPhone());

        owner.setSex(Convert.num2sex(ownerEntity.getSex()));
        owner.setIdentityType(Convert.num2idtype(ownerEntity.getIdentityType()));
        owner.setAuthenticationTime(Convert.num2time(ownerEntity.getAuthenticationTime()));
        owner.setBirthday(Convert.num2time(ownerEntity.getBirthday()));

        owner.setFamilies(familyService.getFamiliesByOwnerID(ownerEntity.getId()));
        owner.setPropertyEntities(propertyService.getPropertiesByString(ownerEntity.getPropertyIdList()));

        return owner;
    }

    @Override
    public void changeAppUserStatus(AppUserEntity appUserEntity)
    {
        AppUserEntity appUserEntity1;
        appUserEntity1=(AppUserEntity)baseDao.get(appUserEntity.getPhone(), appUserEntity);
        appUserEntity1.setStatus(appUserEntity.getStatus());
        baseDao.save(appUserEntity1);
    }

    @Override
    public Object getUserInfoBYPhone(String phone,int type)
    {
        return userDao.getUserInfoBYPhone(phone, type);
    }

    @Override
    public void deleteUserByPhone(String phone, int type)
    {
        switch (type)
        {
            case UserType.OWNER:
                userDao.deleteUserByPhone(phone,type);
                break;
            case UserType.APPUSER:
                userDao.deleteUserByPhone(phone,UserType.FAMILY);
                userDao.deleteUserByPhone(phone,UserType.TENANT);
                userDao.deleteUserByPhone(phone,UserType.APPUSER);
                break;
            default:
                break;
        }
    }

    @Override
    public Object getPropertiesByPhone(String phone,int userType)
    {
        return propertyOwnerInfoDao.getPropertiesByOwnerPhone(phone);
    }

    @Override
    public ArrayList<Object> getUserInfoByProperityID(Integer id,int userType) throws UserTypeErrorException
    {
        switch (userType)
        {
            case UserType.OWNER:
                return userDao.getOwnersByPropertyID(id);
            case UserType.FAMILY:
                break;
            case UserType.TENANT:
                break;
            default:
                throw new UserTypeErrorException("用户类型错误");
        }
        return null;
    }


    @Override
    public TableData getList(TableFilter tableFilter, Object object)
    {
        TableData tableData=userDao.getTenantList(tableFilter);
        ArrayList<TenantEntity> entities = (ArrayList<TenantEntity>) tableData.getJsonString();
        ArrayList<Tenant> tenans=new ArrayList<Tenant>();

        for(TenantEntity tenantEntity:entities)
        {
            Tenant tenant=new Tenant();

            tenant.setBirthday(Convert.num2time(tenantEntity.getBirthday()));
            tenant.setSex(Convert.num2sex(tenantEntity.getSex()));
            tenant.setName(tenantEntity.getName());
            tenant.setAuthenticationTime(Convert.num2time(tenantEntity.getAuthenticationTime()));
            tenant.setStartTime(Convert.num2time(tenantEntity.getStartTime()));
            tenant.setEndTime(Convert.num2time(tenantEntity.getEndTime()));
            tenant.setIdentityType(Convert.num2idtype(tenantEntity.getIdentityType()));
            tenant.setIdentityCode(tenantEntity.getIdentityCode());
            tenant.setPhone(tenantEntity.getPhone());
            tenant.setUrgentName(tenantEntity.getUrgentName());
            tenant.setUrgentPhone(tenantEntity.getUrgentPhone());

            tenans.add(tenant);
        }
        tableData.setJsonString(tenans);
        return tableData;
    }
}
