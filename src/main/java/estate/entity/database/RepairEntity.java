package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class RepairEntity
{
    private Integer id;
    private String title;
    private String content;
    private String description;
    private String phone;
    private Long time;
    private String imageIdList;
    private Byte status;
    private Integer remark;
    private String remarkText;
    private Integer cuId;
    private String result;
    private String repirmanPhone;
    private ConsoleUserEntity consoleUserEntity;


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

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getImageIdList()
    {
        return imageIdList;
    }

    public void setImageIdList(String imageIdList)
    {
        this.imageIdList = imageIdList;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
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

    public String getRepirmanPhone()
    {
        return repirmanPhone;
    }

    public void setRepirmanPhone(String repirmanPhone)
    {
        this.repirmanPhone = repirmanPhone;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }

    public Long getTime()
    {
        return time;
    }

    public void setTime(Long time)
    {
        this.time = time;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public ConsoleUserEntity getConsoleUserEntity()
    {
        return consoleUserEntity;
    }

    public void setConsoleUserEntity(ConsoleUserEntity consoleUserEntity)
    {
        this.consoleUserEntity = consoleUserEntity;
    }

    public Integer getCuId()
    {
        return cuId;
    }

    public void setCuId(Integer cuId)
    {
        this.cuId = cuId;
    }
}
