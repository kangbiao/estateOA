package estate.entity.display;

import java.util.Set;

/**
 * Created by kangbiao on 15-9-13.
 */
public class Owner
{
    private int ownerId;
    private String phone;
    private String name;
    private String sex;
    private String birthday;
    private String urgentName;
    private String urgentPhone;
    private String identityType;
    private String identityCode;
    private String vehicleIdIst;
    private String propertyIdList;
    private String authenticationTime;

    private Set<Property> propertyEntities;

    public String getAuthenticationTime()
    {
        return authenticationTime;
    }

    public void setAuthenticationTime(String authenticationTime)
    {
        this.authenticationTime = authenticationTime;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getIdentityCode()
    {
        return identityCode;
    }

    public void setIdentityCode(String identityCode)
    {
        this.identityCode = identityCode;
    }

    public String getIdentityType()
    {
        return identityType;
    }

    public void setIdentityType(String identityType)
    {
        this.identityType = identityType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(int ownerId)
    {
        this.ownerId = ownerId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPropertyIdList()
    {
        return propertyIdList;
    }

    public void setPropertyIdList(String propertyIdList)
    {
        this.propertyIdList = propertyIdList;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
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

    public String getVehicleIdIst()
    {
        return vehicleIdIst;
    }

    public void setVehicleIdIst(String vehicleIdIst)
    {
        this.vehicleIdIst = vehicleIdIst;
    }

    public Set<Property> getPropertyEntities()
    {
        return propertyEntities;
    }

    public void setPropertyEntities(Set<Property> propertyEntities)
    {
        this.propertyEntities = propertyEntities;
    }
}
