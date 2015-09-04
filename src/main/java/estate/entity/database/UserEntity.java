package estate.entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-9-4.
 */
public class UserEntity
{
    private int userId;
    private String phone;
    private String password;
    private String salt;
    private String username;
    private String userCode;
    private String carNum;
    private String iDcard;
    private Integer unitId;
    private String doorPart;
    private String joinTime;
    private String createTime;
    private Collection<ComplainEntity> complainsByUserId;
    private UnitEntity unitByUnitId;
    private Collection<UserServiceEntity> userServicesByUserId;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUserCode()
    {
        return userCode;
    }

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }

    public String getCarNum()
    {
        return carNum;
    }

    public void setCarNum(String carNum)
    {
        this.carNum = carNum;
    }

    public String getiDcard()
    {
        return iDcard;
    }

    public void setiDcard(String iDcard)
    {
        this.iDcard = iDcard;
    }

    public Integer getUnitId()
    {
        return unitId;
    }

    public void setUnitId(Integer unitId)
    {
        this.unitId = unitId;
    }

    public String getDoorPart()
    {
        return doorPart;
    }

    public void setDoorPart(String doorPart)
    {
        this.doorPart = doorPart;
    }

    public String getJoinTime()
    {
        return joinTime;
    }

    public void setJoinTime(String joinTime)
    {
        this.joinTime = joinTime;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null)
            return false;
        if (carNum != null ? !carNum.equals(that.carNum) : that.carNum != null)
            return false;
        if (iDcard != null ? !iDcard.equals(that.iDcard) : that.iDcard != null)
            return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null)
            return false;
        if (doorPart != null ? !doorPart.equals(that.doorPart) : that.doorPart != null)
            return false;
        if (joinTime != null ? !joinTime.equals(that.joinTime) : that.joinTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (carNum != null ? carNum.hashCode() : 0);
        result = 31 * result + (iDcard != null ? iDcard.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (doorPart != null ? doorPart.hashCode() : 0);
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    public Collection<ComplainEntity> getComplainsByUserId()
    {
        return complainsByUserId;
    }

    public void setComplainsByUserId(Collection<ComplainEntity> complainsByUserId)
    {
        this.complainsByUserId = complainsByUserId;
    }

    public UnitEntity getUnitByUnitId()
    {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId)
    {
        this.unitByUnitId = unitByUnitId;
    }

    public Collection<UserServiceEntity> getUserServicesByUserId()
    {
        return userServicesByUserId;
    }

    public void setUserServicesByUserId(Collection<UserServiceEntity> userServicesByUserId)
    {
        this.userServicesByUserId = userServicesByUserId;
    }
}
