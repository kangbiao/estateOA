package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class ApartmentEntity
{
    private Integer apartmentId;
    private Integer unitCode;
    private Integer code;
    private Integer buildingId;

    public Integer getApartmentId()
    {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId)
    {
        this.apartmentId = apartmentId;
    }

    public Integer getUnitCode()
    {
        return unitCode;
    }

    public void setUnitCode(Integer unitCode)
    {
        this.unitCode = unitCode;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
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

        ApartmentEntity that = (ApartmentEntity) o;

        if (apartmentId != null ? !apartmentId.equals(that.apartmentId) : that.apartmentId != null)
            return false;
        if (unitCode != null ? !unitCode.equals(that.unitCode) : that.unitCode != null)
            return false;
        if (code != null ? !code.equals(that.code) : that.code != null)
            return false;
        if (buildingId != null ? !buildingId.equals(that.buildingId) : that.buildingId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = apartmentId != null ? apartmentId.hashCode() : 0;
        result = 31 * result + (unitCode != null ? unitCode.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (buildingId != null ? buildingId.hashCode() : 0);
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
