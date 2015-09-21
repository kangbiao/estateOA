package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class PropertyOwnerInfoEntity
{
    private Integer id;
    private Integer propertyId;
    private String ownerPhone;
    private Integer buildingId;
    private Byte openDoorAllowed;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Byte getOpenDoorAllowed()
    {
        return openDoorAllowed;
    }

    public void setOpenDoorAllowed(Byte openDoorAllowed)
    {
        this.openDoorAllowed = openDoorAllowed;
    }

    public String getOwnerPhone()
    {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone)
    {
        this.ownerPhone = ownerPhone;
    }

    public Integer getPropertyId()
    {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId)
    {
        this.propertyId = propertyId;
    }

    public Integer getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId)
    {
        this.buildingId = buildingId;
    }
}
