package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 *
 */
public class NoticeEntity
{
    private int noticeId;
    private String title;
    private String content;
    private String time;
    private String pictureIdList;
    private String description;
    private Byte type;
    private Integer expiretime;
    private Integer cuId;

    public int getNoticeId()
    {
        return noticeId;
    }

    public void setNoticeId(int noticeId)
    {
        this.noticeId = noticeId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getPictureIdList()
    {
        return pictureIdList;
    }

    public void setPictureIdList(String pictureIdList)
    {
        this.pictureIdList = pictureIdList;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Byte getType()
    {
        return type;
    }

    public void setType(Byte type)
    {
        this.type = type;
    }

    public Integer getExpiretime()
    {
        return expiretime;
    }

    public void setExpiretime(Integer expiretime)
    {
        this.expiretime = expiretime;
    }

    public Integer getCuId()
    {
        return cuId;
    }

    public void setCuId(Integer cuId)
    {
        this.cuId = cuId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        NoticeEntity that = (NoticeEntity) o;

        if (noticeId != that.noticeId)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null)
            return false;
        if (pictureIdList != null ? !pictureIdList.equals(that.pictureIdList) : that.pictureIdList != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null)
            return false;
        if (expiretime != null ? !expiretime.equals(that.expiretime) : that.expiretime != null)
            return false;
        if (cuId != null ? !cuId.equals(that.cuId) : that.cuId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = noticeId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (pictureIdList != null ? pictureIdList.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (expiretime != null ? expiretime.hashCode() : 0);
        result = 31 * result + (cuId != null ? cuId.hashCode() : 0);
        return result;
    }
}
