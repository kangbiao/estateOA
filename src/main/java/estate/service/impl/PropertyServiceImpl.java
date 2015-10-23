package estate.service.impl;

import estate.common.enums.Entity;
import estate.common.util.Convert;
import estate.dao.*;
import estate.entity.database.BuildingEntity;
import estate.entity.database.PropertyEntity;
import estate.entity.database.PropertyOwnerInfoEntity;
import estate.entity.database.VillageEntity;
import estate.entity.display.Property;
import estate.entity.json.Select2;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.exception.EntityTypeErrorException;
import estate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (list==null)
            return null;
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
        if (list==null)
            return null;
        for (PropertyEntity propertyEntity:list)
        {
            Select2 select2=new Select2(String.valueOf(propertyEntity.getId()),propertyEntity.getLocation());
            entities.add(select2);
        }

        return entities;
    }

    @Override
    public ArrayList<PropertyEntity> getByBuildingID(Integer id)
    {
        return propertyDao.getPropertyByBuildingID(id);
    }


    @Override
    public ArrayList<PropertyEntity> getProperitiesByAppUserPhone(String phone)
    {
//        AppUserEntity appUserEntity;
//        appUserEntity= (AppUserEntity) baseDao.get(phone,AppUserEntity.class);
//        if (appUserEntity==null)
//            return null;
//        int userRole=appUserEntity.getUserRole();
//        return propertyDao.getPropertiesByPhoneRole(phone,userRole);
        return null;
    }

    @Override
    public PropertyEntity getByCode(String code) throws EntityTypeErrorException
    {
        return (PropertyEntity) baseDao.getByCode(code, Entity.PROPERTY);
    }


    @Override
    public ArrayList<PropertyEntity> getPropertyByPhoneRole(String phone, Byte userRole)
    {
        return propertyDao.getPropertiesByPhoneRole(phone, userRole);
    }

    @Override
    public ArrayList<PropertyEntity> getAllPropertyByVillageID(Integer id)
    {
        return propertyDao.getAllProperty();
    }

}
