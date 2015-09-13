package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class FamilyEntity
{
    private int familyId;
    private String phone;
    private String name;
    private Byte sex;
    private Long birthday;
    private String urgentName;
    private String urgentPhone;
    private Byte identityType;
    private String identityCode;
    private String ownerElationship;
    private Long authenticationTime;
    private String vehicleIdList;
    private Byte authStatus;

    public int getFamilyId()
    {
        return familyId;
    }

    public void setFamilyId(int familyId)
    {
        this.familyId = familyId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Byte getSex()
    {
        return sex;
    }

    public void setSex(Byte sex)
    {
        this.sex = sex;
    }

    public Long getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Long birthday)
    {
        this.birthday = birthday;
    }

    public String getUrgentName()
    {
        return urgentName;
    }

    public void setUrgentName(String urgentName)
    {
        this.urgentName = urgentName;
    }

    public String getUrgentPhone()
    {
        return urgentPhone;
    }

    public void setUrgentPhone(String urgentPhone)
    {
        this.urgentPhone = urgentPhone;
    }

    public Byte getIdentityType()
    {
        return identityType;
    }

    public void setIdentityType(Byte identityType)
    {
        this.identityType = identityType;
    }

    public String getIdentityCode()
    {
        return identityCode;
    }

    public void setIdentityCode(String identityCode)
    {
        this.identityCode = identityCode;
    }

    public String getOwnerElationship()
    {
        return ownerElationship;
    }

    public void setOwnerElationship(String ownerElationship)
    {
        this.ownerElationship = ownerElationship;
    }

    public Long getAuthenticationTime()
    {
        return authenticationTime;
    }

    public void setAuthenticationTime(Long authenticationTime)
    {
        this.authenticationTime = authenticationTime;
    }

    public String getVehicleIdList()
    {
        return vehicleIdList;
    }

    public void setVehicleIdList(String vehicleIdList)
    {
        this.vehicleIdList = vehicleIdList;
    }

    public Byte getAuthStatus()
    {
        return authStatus;
    }

    public void setAuthStatus(Byte authStatus)
    {
        this.authStatus = authStatus;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        FamilyEntity that = (FamilyEntity) o;

        if (familyId != that.familyId)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null)
            return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null)
            return false;
        if (urgentName != null ? !urgentName.equals(that.urgentName) : that.urgentName != null)
            return false;
        if (urgentPhone != null ? !urgentPhone.equals(that.urgentPhone) : that.urgentPhone != null)
            return false;
        if (identityType != null ? !identityType.equals(that.identityType) : that.identityType != null)
            return false;
        if (identityCode != null ? !identityCode.equals(that.identityCode) : that.identityCode != null)
            return false;
        if (ownerElationship != null ? !ownerElationship.equals(that.ownerElationship) : that.ownerElationship != null)
            return false;
        if (authenticationTime != null ? !authenticationTime.equals(that.authenticationTime) : that
                .authenticationTime != null)
            return false;
        if (vehicleIdList != null ? !vehicleIdList.equals(that.vehicleIdList) : that.vehicleIdList != null)
            return false;
        if (authStatus != null ? !authStatus.equals(that.authStatus) : that.authStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = familyId;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (urgentName != null ? urgentName.hashCode() : 0);
        result = 31 * result + (urgentPhone != null ? urgentPhone.hashCode() : 0);
        result = 31 * result + (identityType != null ? identityType.hashCode() : 0);
        result = 31 * result + (identityCode != null ? identityCode.hashCode() : 0);
        result = 31 * result + (ownerElationship != null ? ownerElationship.hashCode() : 0);
        result = 31 * result + (authenticationTime != null ? authenticationTime.hashCode() : 0);
        result = 31 * result + (vehicleIdList != null ? vehicleIdList.hashCode() : 0);
        result = 31 * result + (authStatus != null ? authStatus.hashCode() : 0);
        return result;
    }
}
