package estate.entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-9-4.
 */
public class GardenEntity
{
    private int gardenId;
    private String gardenCode;
    private String gardenName;
    private Collection<BuildingEntity> buildingsByGardenId;

    public int getGardenId()
    {
        return gardenId;
    }

    public void setGardenId(int gardenId)
    {
        this.gardenId = gardenId;
    }

    public String getGardenCode()
    {
        return gardenCode;
    }

    public void setGardenCode(String gardenCode)
    {
        this.gardenCode = gardenCode;
    }

    public String getGardenName()
    {
        return gardenName;
    }

    public void setGardenName(String gardenName)
    {
        this.gardenName = gardenName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GardenEntity that = (GardenEntity) o;

        if (gardenId != that.gardenId)
            return false;
        if (gardenCode != null ? !gardenCode.equals(that.gardenCode) : that.gardenCode != null)
            return false;
        if (gardenName != null ? !gardenName.equals(that.gardenName) : that.gardenName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = gardenId;
        result = 31 * result + (gardenCode != null ? gardenCode.hashCode() : 0);
        result = 31 * result + (gardenName != null ? gardenName.hashCode() : 0);
        return result;
    }

    public Collection<BuildingEntity> getBuildingsByGardenId()
    {
        return buildingsByGardenId;
    }

    public void setBuildingsByGardenId(Collection<BuildingEntity> buildingsByGardenId)
    {
        this.buildingsByGardenId = buildingsByGardenId;
    }
}
