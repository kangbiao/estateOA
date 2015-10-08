package estate.service.impl;

import estate.common.UserType;
import estate.common.enums.Entity;
import estate.common.util.Convert;
import estate.dao.*;
import estate.entity.database.*;
import estate.entity.display.Property;
import estate.entity.json.Select2;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.exception.AppUserNotExitException;
import estate.exception.EntityTypeErrorException;
import estate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
@Service("propertyService")
public class PropertyServiceImpl implements PropertyService
{
    @Autowired
    private PropertyDao propertyDao;
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private PropertyOwnerInfoDao propertyOwnerInfoDao;
    @Autowired
    private VillageDao villageDao;
    @Autowired
    private BuildingDao buildingDao;

    public Integer save(PropertyOwnerInfoEntity object)
    {
        PropertyEntity propertyEntity = object.getPropertyEntity();
        Integer id = baseDao.save(propertyEntity);
        object.setPropertyId(id);
        return baseDao.save(object);
    }

    public Property get(Integer id)
    {
        Property property = new Property();
        PropertyEntity propertyEntity = propertyDao.get(id);
        property.setStatus(Convert.propertyStatus2string(propertyEntity.getStatus()));
        property.setCode(propertyEntity.getCode());
        property.setLocation(propertyEntity.getLocation());
        property.setPropertySquare(String.valueOf(propertyEntity.getPropertySquare()));
        return property;
    }

    public Set<Property> getPropertiesByString(String string)
    {
        //TODO 需要检查物业ID是否存在,不存在则不返回

        List<Integer> ids = Convert.string2ints(string, ";");
        Set<Property> properties = new HashSet<>();
        for (Integer id : ids)
        {
            properties.add(this.get(id));
        }
        return properties;
    }

    @Override
    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData = propertyDao.getList(tableFilter);
        tableData.setRecordsTotal(baseDao.count("PropertyEntity"));
        return tableData;
    }

    @Override
    public Object getByProperID(Integer id)
    {
        return propertyOwnerInfoDao.getByPropertyID(id);
    }

    @Override
    public Object getAllVillage()
    {
        ArrayList<Select2> entities = new ArrayList<>();
        ArrayList<VillageEntity> list = villageDao.getAllVillage();
        for (VillageEntity villageEntity : list)
        {
            Select2 select2 = new Select2(String.valueOf(villageEntity.getId()), villageEntity.getName());
            entities.add(select2);
        }
        return entities;
    }

    @Override
    public Object getBuildingsByValliageId(Integer id)
    {
        ArrayList<Select2> entities = new ArrayList<>();
        ArrayList<BuildingEntity> list=buildingDao.getAllBuildingsByVillageId(id);
        for (BuildingEntity buildingEntity:list)
        {
            Select2 select2=new Select2(String.valueOf(buildingEntity.getId()),buildingEntity.getBuildingName());
            entities.add(select2);
        }
        return entities;
    }

    @Override
    public Object getPropertyByBuildingId(Integer buildingID)
    {
        ArrayList<Select2> entities=new ArrayList<>();
        ArrayList<PropertyEntity> list=propertyDao.getPropertyByBuildingID(buildingID);
        for (PropertyEntity propertyEntity:list)
        {
            Select2 select2=new Select2(String.valueOf(propertyEntity.getId()),propertyEntity.getLocation());
            entities.add(select2);
        }

        return entities;
    }

    @Override
    public ArrayList<Object> getProperitiesByAppUserPhone(String phone) throws Exception
    {
        AppUserEntity appUserEntity=new AppUserEntity();
        appUserEntity= (AppUserEntity) baseDao.get(phone,AppUserEntity.class);
        if (appUserEntity==null)
            throw new AppUserNotExitException("该app用户不存在!");
        int userRole=appUserEntity.getUserRole();
        switch (userRole)
        {
            case UserType.FAMILY:
                //TODO 如果用户为家庭用户

                break;
            case UserType.TENANT:
                break;
            case UserType.OWNER:
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public PropertyEntity getByCode(String code) throws EntityTypeErrorException
    {
        return (PropertyEntity) baseDao.getByCode(code, Entity.PROPERTY);
    }

    @Override
    public boolean checkOwnerPropertyExit(String phone, Integer id)
    {
        ArrayList<PropertyEntity> propertyEntities=propertyOwnerInfoDao.getPropertiesByOwnerPhone(phone);
        for (PropertyEntity propertyEntity:propertyEntities)
        {
            if (Objects.equals(propertyEntity.getId(), id))
                return false;
        }
        return true;
    }

    //TODO 项目验收,待删除
    @Override
    public ArrayList<Select2> getAllProperty()
    {
        ArrayList<PropertyEntity> properties=propertyDao.getAllProperty();
        ArrayList<Select2> items=new ArrayList<>();
        for (PropertyEntity propertyEntity:properties)
        {
            Select2 select2=new Select2();
            select2.setId(String.valueOf(propertyEntity.getId()));
            select2.setText(propertyEntity.getLocation());
            items.add(select2);
        }
        return items;

    }
}
