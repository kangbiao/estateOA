package estate.entity.database;

import java.util.Collection;

/**
 * Created by kangbiao on 15-9-4.
 */
public class ServiceEntity
{
    private int serviceId;
    private String type;
    private String feeInfo;
    private String title;
    private String detail;
    private Collection<UserServiceEntity> userServicesByServiceId;

    public int getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getFeeInfo()
    {
        return feeInfo;
    }

    public void setFeeInfo(String feeInfo)
    {
        this.feeInfo = feeInfo;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceEntity that = (ServiceEntity) o;

        if (serviceId != that.serviceId)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null)
            return false;
        if (feeInfo != null ? !feeInfo.equals(that.feeInfo) : that.feeInfo != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = serviceId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (feeInfo != null ? feeInfo.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }

    public Collection<UserServiceEntity> getUserServicesByServiceId()
    {
        return userServicesByServiceId;
    }

    public void setUserServicesByServiceId(Collection<UserServiceEntity> userServicesByServiceId)
    {
        this.userServicesByServiceId = userServicesByServiceId;
    }
}
