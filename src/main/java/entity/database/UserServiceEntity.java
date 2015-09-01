package entity.database;

/**
 * Created by kangbiao on 15-8-27.
 */
public class UserServiceEntity
{
    private int usId;
    private Integer userId;
    private Integer serviceId;
    private String createTime;
    private Integer payStatus;
    private Integer serviceStatus;
    private String comment;
    private ServiceEntity serviceByServiceId;
    private UserEntity userByUserId;

    public int getUsId()
    {
        return usId;
    }

    public void setUsId(int usId)
    {
        this.usId = usId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(Integer serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public Integer getPayStatus()
    {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus)
    {
        this.payStatus = payStatus;
    }

    public Integer getServiceStatus()
    {
        return serviceStatus;
    }

    public void setServiceStatus(Integer serviceStatus)
    {
        this.serviceStatus = serviceStatus;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserServiceEntity that = (UserServiceEntity) o;

        if (usId != that.usId)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null)
            return false;
        if (payStatus != null ? !payStatus.equals(that.payStatus) : that.payStatus != null)
            return false;
        if (serviceStatus != null ? !serviceStatus.equals(that.serviceStatus) : that.serviceStatus != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = usId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (payStatus != null ? payStatus.hashCode() : 0);
        result = 31 * result + (serviceStatus != null ? serviceStatus.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    public ServiceEntity getServiceByServiceId()
    {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(ServiceEntity serviceByServiceId)
    {
        this.serviceByServiceId = serviceByServiceId;
    }

    public UserEntity getUserByUserId()
    {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId)
    {
        this.userByUserId = userByUserId;
    }
}
