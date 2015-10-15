package estate.entity.database;

/**
 * Created by kangbiao on 15-10-14.
 */
public class ParklotOwnerInfoEntity
{
    private Integer id;
    private Integer plId;
    private String ownerPhone;
    private Integer brakeId;
    private Byte enterBrakeAllowed;


    public Integer getPlId()
    {
        return plId;
    }

    public void setPlId(Integer plId)
    {
        this.plId = plId;
    }

    public String getOwnerPhone()
    {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone)
    {
        this.ownerPhone = ownerPhone;
    }

    public Integer getBrakeId()
    {
        return brakeId;
    }

    public void setBrakeId(Integer brakeId)
    {
        this.brakeId = brakeId;
    }

    public Byte getEnterBrakeAllowed()
    {
        return enterBrakeAllowed;
    }

    public void setEnterBrakeAllowed(Byte enterBrakeAllowed)
    {
        this.enterBrakeAllowed = enterBrakeAllowed;
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
