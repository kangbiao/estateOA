package estate.entity.database;

import javax.validation.constraints.NotNull;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
public class NoticeEntity
{
    private int niticeId;
    @NotNull(message = "公告标题不能为空")
    private String title;
    private String description;
    private String detail;
    private String createTime;
    private String expireTime;
    private String picPath;
    private String creater;

    public int getNiticeId()
    {
        return niticeId;
    }

    public void setNiticeId(int niticeId)
    {
        this.niticeId = niticeId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getExpireTime()
    {
        return expireTime;
    }

    public void setExpireTime(String expireTime)
    {
        this.expireTime = expireTime;
    }

    public String getPicPath()
    {
        return picPath;
    }

    public void setPicPath(String picPath)
    {
        this.picPath = picPath;
    }

    public String getCreater()
    {
        return creater;
    }

    public void setCreater(String creater)
    {
        this.creater = creater;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        NoticeEntity that = (NoticeEntity) o;

        if (niticeId != that.niticeId)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null)
            return false;
        if (expireTime != null ? !expireTime.equals(that.expireTime) : that.expireTime != null)
            return false;
        if (picPath != null ? !picPath.equals(that.picPath) : that.picPath != null)
            return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = niticeId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (expireTime != null ? expireTime.hashCode() : 0);
        result = 31 * result + (picPath != null ? picPath.hashCode() : 0);
        result = 31 * result + (creater != null ? creater.hashCode() : 0);
        return result;
    }
}
