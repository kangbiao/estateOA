package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class OpenDoorRecordEntity
{
    private int id;
    private Integer userId;
    private Long openTime;
    private String openCode;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Long getOpenTime()
    {
        return openTime;
    }

    public void setOpenTime(Long openTime)
    {
        this.openTime = openTime;
    }

    public String getOpenCode()
    {
        return openCode;
    }

    public void setOpenCode(String openCode)
    {
        this.openCode = openCode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OpenDoorRecordEntity that = (OpenDoorRecordEntity) o;

        if (id != that.id)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (openTime != null ? !openTime.equals(that.openTime) : that.openTime != null)
            return false;
        if (openCode != null ? !openCode.equals(that.openCode) : that.openCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (openTime != null ? openTime.hashCode() : 0);
        result = 31 * result + (openCode != null ? openCode.hashCode() : 0);
        return result;
    }
}
