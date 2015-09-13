package estate.entity.database;

import java.math.BigDecimal;

/**
 * Created by kangbiao on 15-9-13.
 */
public class PropertyEntity
{
    private int propertyId;
    private String code;
    private String ownerNameList;
    private String location;
    private Byte type;
    private BigDecimal propertySquare;
    private Byte ownerType;
    private Integer villageId;
    private Byte status;

    public int getPropertyId()
    {
        return propertyId;
    }

    public void setPropertyId(int propertyId)
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

    public String getOwnerNameList()
    {
        return ownerNameList;
    }

    public void setOwnerNameList(String ownerNameList)
    {
        this.ownerNameList = ownerNameList;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Byte getType()
    {
        return type;
    }

    public void setType(Byte type)
    {
        this.type = type;
    }

    public BigDecimal getPropertySquare()
    {
        return propertySquare;
    }

    public void setPropertySquare(BigDecimal propertySquare)
    {
        this.propertySquare = propertySquare;
    }

    public Byte getOwnerType()
    {
        return ownerType;
    }

    public void setOwnerType(Byte ownerType)
    {
        this.ownerType = ownerType;
    }

    public Integer getVillageId()
    {
        return villageId;
    }

    public void setVillageId(Integer villageId)
    {
        this.villageId = villageId;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PropertyEntity that = (PropertyEntity) o;

        if (propertyId != that.propertyId)
            return false;
        if (code != null ? !code.equals(that.code) : that.code != null)
            return false;
        if (ownerNameList != null ? !ownerNameList.equals(that.ownerNameList) : that.ownerNameList != null)
            return false;
        if (location != null ? !location.equals(that.location) : that.location != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null)
            return false;
        if (propertySquare != null ? !propertySquare.equals(that.propertySquare) : that.propertySquare != null)
            return false;
        if (ownerType != null ? !ownerType.equals(that.ownerType) : that.ownerType != null)
            return false;
        if (villageId != null ? !villageId.equals(that.villageId) : that.villageId != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = propertyId;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (ownerNameList != null ? ownerNameList.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (propertySquare != null ? propertySquare.hashCode() : 0);
        result = 31 * result + (ownerType != null ? ownerType.hashCode() : 0);
        result = 31 * result + (villageId != null ? villageId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
