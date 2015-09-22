package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class BuildingEntity
{
    private int buildingId;
    private Integer villageId;
    private String description;
    private String buildingCode;
    private String buildingName;

    public int getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(int buildingId)
    {
        this.buildingId = buildingId;
    }

    public Integer getVillageId()
    {
        return villageId;
    }

    public void setVillageId(Integer villageId)
    {
        this.villageId = villageId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getBuildingCode()
    {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode)
    {
        this.buildingCode = buildingCode;
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
        if (villageId != null ? !villageId.equals(that.villageId) : that.villageId != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (buildingCode != null ? !buildingCode.equals(that.buildingCode) : that.buildingCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = buildingId;
        result = 31 * result + (villageId != null ? villageId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (buildingCode != null ? buildingCode.hashCode() : 0);
        return result;
    }

    public String getBuildingName()
    {
        return buildingName;
    }

    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }
}
