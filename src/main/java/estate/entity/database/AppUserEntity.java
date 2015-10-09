package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class AppUserEntity
{
    private String phone;
    private String passwd;
    private int userRole;
    private String userName;
    private Long registerTime;
    private Integer ownerId;
    private Byte status;

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Long getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime)
    {
        this.registerTime = registerTime;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getUserRole()
    {
        return userRole;
    }

    public void setUserRole(int userRole)
    {
        this.userRole = userRole;
    }

    public Integer getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId)
    {
        this.ownerId = ownerId;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }
}
