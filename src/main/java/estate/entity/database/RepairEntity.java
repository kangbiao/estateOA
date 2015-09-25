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
    private int status;
    private Integer remark;
    private String remarkText;
    private Integer adminId;
    private String result;
    private String repirmanPhone;

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

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
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



    public String getRepirmanPhone()
    {
        return repirmanPhone;
    }

    public void setRepirmanPhone(String repirmanPhone)
    {
        this.repirmanPhone = repirmanPhone;
    }
}
