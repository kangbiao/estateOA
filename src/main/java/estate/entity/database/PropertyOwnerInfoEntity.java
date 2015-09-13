package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class PropertyOwnerInfoEntity
{
    private int poId;
    private Integer propertyId;
    private String ownerIdentityId;
    private Byte openDoorAllowed;

    public int getPoId()
    {
        return poId;
    }

    public void setPoId(int poId)
    {
        this.poId = poId;
    }

    public Integer getPropertyId()
    {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId)
    {
        this.propertyId = propertyId;
    }

    public String getOwnerIdentityId()
    {
        return ownerIdentityId;
    }

    public void setOwnerIdentityId(String ownerIdentityId)
    {
        this.ownerIdentityId = ownerIdentityId;
    }

    public Byte getOpenDoorAllowed()
    {
        return openDoorAllowed;
    }

    public void setOpenDoorAllowed(Byte openDoorAllowed)
    {
        this.openDoorAllowed = openDoorAllowed;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PropertyOwnerInfoEntity that = (PropertyOwnerInfoEntity) o;

        if (poId != that.poId)
            return false;
        if (propertyId != null ? !propertyId.equals(that.propertyId) : that.propertyId != null)
            return false;
        if (ownerIdentityId != null ? !ownerIdentityId.equals(that.ownerIdentityId) : that.ownerIdentityId != null)
            return false;
        if (openDoorAllowed != null ? !openDoorAllowed.equals(that.openDoorAllowed) : that.openDoorAllowed != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = poId;
        result = 31 * result + (propertyId != null ? propertyId.hashCode() : 0);
        result = 31 * result + (ownerIdentityId != null ? ownerIdentityId.hashCode() : 0);
        result = 31 * result + (openDoorAllowed != null ? openDoorAllowed.hashCode() : 0);
        return result;
    }
}
