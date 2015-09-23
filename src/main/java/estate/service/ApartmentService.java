package estate.service;

import estate.entity.database.ApartmentEntity;
import estate.entity.database.PropertyEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-23.
 *
 */
public interface ApartmentService
{
    TableData getList(TableFilter tableFilter);

    Integer saveApartment(PropertyEntity propertyEntity,ApartmentEntity apartmentEntity);

}
