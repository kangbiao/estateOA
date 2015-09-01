package entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-8-27.
 */
public class AdminEntity
{
    private int adminId;
    private String username;
    private String password;
    private String salt;
    private String email;
    private Integer groupId;
    private String lastLogin;
    private GroupEntity groupByGroupId;
    private Collection<ComplainEntity> complainsByAdminId;

    public int getAdminId()
    {
        return adminId;
    }

    public void setAdminId(int adminId)
    {
        this.adminId = adminId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getGroupId()
    {
        return groupId;
    }

    public void setGroupId(Integer groupId)
    {
        this.groupId = groupId;
    }

    public String getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AdminEntity that = (AdminEntity) o;

        if (adminId != that.adminId)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null)
            return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null)
            return false;
        if (lastLogin != null ? !lastLogin.equals(that.lastLogin) : that.lastLogin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = adminId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        return result;
    }

    public GroupEntity getGroupByGroupId()
    {
        return groupByGroupId;
    }

    public void setGroupByGroupId(GroupEntity groupByGroupId)
    {
        this.groupByGroupId = groupByGroupId;
    }

    public Collection<ComplainEntity> getComplainsByAdminId()
    {
        return complainsByAdminId;
    }

    public void setComplainsByAdminId(Collection<ComplainEntity> complainsByAdminId)
    {
        this.complainsByAdminId = complainsByAdminId;
    }
}
