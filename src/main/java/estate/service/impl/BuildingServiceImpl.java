package estate.service.impl;

import estate.dao.BaseDao;
import estate.dao.BuildingDao;
import estate.entity.database.BuildingEntity;
import estate.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-22.
 *
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService
{
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private BuildingDao buildingDao;

    @Override
    public Integer getIDByCode(String code)
    {
        BuildingEntity buildingEntity=buildingDao.getByCode(code);
        if (buildingEntity!=null)
        {
            return buildingEntity.getBuildingId();
        }
        else
        {
            return null;
        }
    }
}
