package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class VillageEntity
{
    private int villageId;
    private String name;
    private String description;

    public int getVillageId()
    {
        return villageId;
    }

    public void setVillageId(int villageId)
    {
        this.villageId = villageId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        VillageEntity that = (VillageEntity) o;

        if (villageId != that.villageId)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = villageId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
