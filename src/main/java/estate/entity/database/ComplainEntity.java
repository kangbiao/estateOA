package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class ComplainEntity
{
    private int id;
    private String title;
    private String content;
    private String description;
    private String phone;
    private Long time;
    private String imageIdList;
    private Byte type;
    private Byte status;
    private Integer adminId;
    private Byte remark;
    private String result;

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

    public Byte getType()
    {
        return type;
    }

    public void setType(Byte type)
    {
        this.type = type;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }

    public Integer getAdminId()
    {
        return adminId;
    }

    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }

    public Byte getRemark()
    {
        return remark;
    }

    public void setRemark(Byte remark)
    {
        this.remark = remark;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
