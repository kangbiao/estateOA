package entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-8-27.
 */
public class GroupEntity
{
    private int groupId;
    private String groupName;
    private String auth;
    private Collection<AdminEntity> adminsByGroupId;

    public int getGroupId()
    {
        return groupId;
    }

    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getAuth()
    {
        return auth;
    }

    public void setAuth(String auth)
    {
        this.auth = auth;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GroupEntity that = (GroupEntity) o;

        if (groupId != that.groupId)
            return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null)
            return false;
        if (auth != null ? !auth.equals(that.auth) : that.auth != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = groupId;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (auth != null ? auth.hashCode() : 0);
        return result;
    }

    public Collection<AdminEntity> getAdminsByGroupId()
    {
        return adminsByGroupId;
    }

    public void setAdminsByGroupId(Collection<AdminEntity> adminsByGroupId)
    {
        this.adminsByGroupId = adminsByGroupId;
    }
}
