package entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-8-27.
 */
public class BuildingEntity
{
    private int buildingId;
    private String buildingCode;
    private String buildingName;
    private Integer gardenId;
    private GardenEntity gardenByGardenId;
    private Collection<UnitEntity> unitsByBuildingId;

    public int getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(int buildingId)
    {
        this.buildingId = buildingId;
    }

    public String getBuildingCode()
    {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode)
    {
        this.buildingCode = buildingCode;
    }

    public String getBuildingName()
    {
        return buildingName;
    }

    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }

    public Integer getGardenId()
    {
        return gardenId;
    }

    public void setGardenId(Integer gardenId)
    {
        this.gardenId = gardenId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BuildingEntity that = (BuildingEntity) o;

        if (buildingId != that.buildingId)
            return false;
        if (buildingCode != null ? !buildingCode.equals(that.buildingCode) : that.buildingCode != null)
            return false;
        if (buildingName != null ? !buildingName.equals(that.buildingName) : that.buildingName != null)
            return false;
        if (gardenId != null ? !gardenId.equals(that.gardenId) : that.gardenId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = buildingId;
        result = 31 * result + (buildingCode != null ? buildingCode.hashCode() : 0);
        result = 31 * result + (buildingName != null ? buildingName.hashCode() : 0);
        result = 31 * result + (gardenId != null ? gardenId.hashCode() : 0);
        return result;
    }

    public GardenEntity getGardenByGardenId()
    {
        return gardenByGardenId;
    }

    public void setGardenByGardenId(GardenEntity gardenByGardenId)
    {
        this.gardenByGardenId = gardenByGardenId;
    }

    public Collection<UnitEntity> getUnitsByBuildingId()
    {
        return unitsByBuildingId;
    }

    public void setUnitsByBuildingId(Collection<UnitEntity> unitsByBuildingId)
    {
        this.unitsByBuildingId = unitsByBuildingId;
    }
}
