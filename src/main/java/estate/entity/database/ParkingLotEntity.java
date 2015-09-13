package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class ParkingLotEntity
{
    private Integer propertyId;
    private String code;
    private String floor;
    private Byte type;
    private String description;

    public Integer getPropertyId()
    {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId)
    {
        this.propertyId = propertyId;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getFloor()
    {
        return floor;
    }

    public void setFloor(String floor)
    {
        this.floor = floor;
    }

    public Byte getType()
    {
        return type;
    }

    public void setType(Byte type)
    {
        this.type = type;
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

        ParkingLotEntity that = (ParkingLotEntity) o;

        if (propertyId != null ? !propertyId.equals(that.propertyId) : that.propertyId != null)
            return false;
        if (code != null ? !code.equals(that.code) : that.code != null)
            return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = propertyId != null ? propertyId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Integer id;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
