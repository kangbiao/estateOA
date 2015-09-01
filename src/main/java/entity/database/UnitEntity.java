package entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-8-27.
 */
public class UnitEntity
{
    private int unitId;
    private String unitCode;
    private String unitName;
    private Integer buildingId;
    private BuildingEntity buildingByBuildingId;
    private Collection<UserEntity> usersByUnitId;

    public int getUnitId()
    {
        return unitId;
    }

    public void setUnitId(int unitId)
    {
        this.unitId = unitId;
    }

    public String getUnitCode()
    {
        return unitCode;
    }

    public void setUnitCode(String unitCode)
    {
        this.unitCode = unitCode;
    }

    public String getUnitName()
    {
        return unitName;
    }

    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }

    public Integer getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId)
    {
        this.buildingId = buildingId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UnitEntity that = (UnitEntity) o;

        if (unitId != that.unitId)
            return false;
        if (unitCode != null ? !unitCode.equals(that.unitCode) : that.unitCode != null)
            return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null)
            return false;
        if (buildingId != null ? !buildingId.equals(that.buildingId) : that.buildingId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = unitId;
        result = 31 * result + (unitCode != null ? unitCode.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (buildingId != null ? buildingId.hashCode() : 0);
        return result;
    }

    public BuildingEntity getBuildingByBuildingId()
    {
        return buildingByBuildingId;
    }

    public void setBuildingByBuildingId(BuildingEntity buildingByBuildingId)
    {
        this.buildingByBuildingId = buildingByBuildingId;
    }

    public Collection<UserEntity> getUsersByUnitId()
    {
        return usersByUnitId;
    }

    public void setUsersByUnitId(Collection<UserEntity> usersByUnitId)
    {
        this.usersByUnitId = usersByUnitId;
    }
}
