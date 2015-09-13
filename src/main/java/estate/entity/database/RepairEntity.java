package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class RepairEntity
{
    private int id;
    private String title;
    private String content;
    private String description;
    private Integer userId;
    private Long time;
    private String imageIdList;
    private Byte status;
    private Integer remark;
    private String remarkText;
    private Integer adminId;
    private String result;
    private Integer repirmanId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Long getTime()
    {
        return time;
    }

    public void setTime(Long time)
    {
        this.time = time;
    }

    public String getImageIdList()
    {
        return imageIdList;
    }

    public void setImageIdList(String imageIdList)
    {
        this.imageIdList = imageIdList;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }

    public Integer getRemark()
    {
        return remark;
    }

    public void setRemark(Integer remark)
    {
        this.remark = remark;
    }

    public String getRemarkText()
    {
        return remarkText;
    }

    public void setRemarkText(String remarkText)
    {
        this.remarkText = remarkText;
    }

    public Integer getAdminId()
    {
        return adminId;
    }

    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public Integer getRepirmanId()
    {
        return repirmanId;
    }

    public void setRepirmanId(Integer repirmanId)
    {
        this.repirmanId = repirmanId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RepairEntity that = (RepairEntity) o;

        if (id != that.id)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null)
            return false;
        if (imageIdList != null ? !imageIdList.equals(that.imageIdList) : that.imageIdList != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null)
            return false;
        if (remarkText != null ? !remarkText.equals(that.remarkText) : that.remarkText != null)
            return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null)
            return false;
        if (result != null ? !result.equals(that.result) : that.result != null)
            return false;
        if (repirmanId != null ? !repirmanId.equals(that.repirmanId) : that.repirmanId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result1 = id;
        result1 = 31 * result1 + (title != null ? title.hashCode() : 0);
        result1 = 31 * result1 + (content != null ? content.hashCode() : 0);
        result1 = 31 * result1 + (description != null ? description.hashCode() : 0);
        result1 = 31 * result1 + (userId != null ? userId.hashCode() : 0);
        result1 = 31 * result1 + (time != null ? time.hashCode() : 0);
        result1 = 31 * result1 + (imageIdList != null ? imageIdList.hashCode() : 0);
        result1 = 31 * result1 + (status != null ? status.hashCode() : 0);
        result1 = 31 * result1 + (remark != null ? remark.hashCode() : 0);
        result1 = 31 * result1 + (remarkText != null ? remarkText.hashCode() : 0);
        result1 = 31 * result1 + (adminId != null ? adminId.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (repirmanId != null ? repirmanId.hashCode() : 0);
        return result1;
    }
}
