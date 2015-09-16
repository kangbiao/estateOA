package estate.service.impl;

import estate.common.util.Convert;
import estate.dao.PropertyDao;
import estate.entity.database.PropertyEntity;
import estate.entity.display.Property;
import estate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kangbiao on 15-9-16.
 */
@Service("propertyService")
public class PropertyServiceImpl implements PropertyService
{
    @Autowired
    private PropertyDao propertyDao;

    public Integer save(PropertyEntity propertyEntity)
    {
        return null;
    }

    public void delete(PropertyEntity propertyEntity)
    {

    }

    public Property get(Integer id)
    {
        Property property=new Property();
        PropertyEntity propertyEntity= propertyDao.get(id);
        property.setStatus(Convert.propertyStatus2string(propertyEntity.getStatus()));
        property.setCode(propertyEntity.getCode());
        property.setLocation(propertyEntity.getLocation());
        property.setPropertySquare(String.valueOf(propertyEntity.getPropertySquare()));
        return property;
    }

    public Set<Property> getPropertiesByString(String string)
    {
        List<Integer> ids=Convert.string2ints(string,";");
        Set<Property> properties=new HashSet<Property>();
        for (Integer id:ids)
        {
            properties.add(this.get(2));
        }
        return properties;
    }
}
