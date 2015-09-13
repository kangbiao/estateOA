package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class ConsoleUserEntity
{
    private int cuId;
    private String password;
    private String phone;
    private String email;
    private Integer consoleGroupId;
    private String name;
    private Byte identityType;
    private String identityId;
    private Integer remark;

    public int getCuId()
    {
        return cuId;
    }

    public void setCuId(int cuId)
    {
        this.cuId = cuId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getConsoleGroupId()
    {
        return consoleGroupId;
    }

    public void setConsoleGroupId(Integer consoleGroupId)
    {
        this.consoleGroupId = consoleGroupId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Byte getIdentityType()
    {
        return identityType;
    }

    public void setIdentityType(Byte identityType)
    {
        this.identityType = identityType;
    }

    public String getIdentityId()
    {
        return identityId;
    }

    public void setIdentityId(String identityId)
    {
        this.identityId = identityId;
    }

    public Integer getRemark()
    {
        return remark;
    }

    public void setRemark(Integer remark)
    {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ConsoleUserEntity that = (ConsoleUserEntity) o;

        if (cuId != that.cuId)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null)
            return false;
        if (consoleGroupId != null ? !consoleGroupId.equals(that.consoleGroupId) : that.consoleGroupId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (identityType != null ? !identityType.equals(that.identityType) : that.identityType != null)
            return false;
        if (identityId != null ? !identityId.equals(that.identityId) : that.identityId != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = cuId;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (consoleGroupId != null ? consoleGroupId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (identityType != null ? identityType.hashCode() : 0);
        result = 31 * result + (identityId != null ? identityId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
