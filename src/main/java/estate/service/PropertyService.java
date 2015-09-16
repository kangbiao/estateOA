package estate.service;

import estate.entity.database.PropertyEntity;
import estate.entity.display.Property;

import java.util.Set;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface PropertyService
{
    Integer save(PropertyEntity propertyEntity);

    void delete(PropertyEntity propertyEntity);

    Property get(Integer id);

    Set<Property> getPropertiesByString(String string);

}
