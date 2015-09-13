package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class AppUserEntity
{
    private String phone;
    private String passwd;
    private Byte userRole;
    private String userName;
    private Long registerTime;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public Byte getUserRole()
    {
        return userRole;
    }

    public void setUserRole(Byte userRole)
    {
        this.userRole = userRole;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Long getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime)
    {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AppUserEntity that = (AppUserEntity) o;

        if (phone != null ? !phone.equals(that.phone) : that.phone != null)
            return false;
        if (passwd != null ? !passwd.equals(that.passwd) : that.passwd != null)
            return false;
        if (userRole != null ? !userRole.equals(that.userRole) : that.userRole != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
            return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        return result;
    }
}
