package estate.entity.database;

import java.math.BigDecimal;

/**
 * Created by kangbiao on 15-9-13.
 */
public class PropertyEntity
{
    private Integer id;
    private String code;
    private String ownerNameList;
    private String location;
    private Byte type;
    private BigDecimal propertySquare;
    private Byte ownerType;
    private Integer villageId;
    private Byte status;


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

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
