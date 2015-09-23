package estate.service.impl;

import estate.dao.ApartmentDao;
import estate.dao.BaseDao;
import estate.entity.database.ApartmentEntity;
import estate.entity.database.PropertyEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-23.
 *
 */
@Service("apartmentService")
public class ApartmentServiceImpl implements ApartmentService
{
    @Autowired
    private ApartmentDao apartmentDao;
    @Autowired
    private BaseDao baseDao;

    @Override
    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData=apartmentDao.getList(tableFilter);
        tableData.setRecordsTotal(baseDao.count("ApartmentEntity"));
        return tableData;
    }

    @Override
    public Integer saveApartment(PropertyEntity propertyEntity, ApartmentEntity apartmentEntity)
    {
        Integer propertyID= baseDao.save(propertyEntity);
        apartmentEntity.setPropertyId(propertyID);
        return baseDao.save(apartmentEntity);
    }
}
