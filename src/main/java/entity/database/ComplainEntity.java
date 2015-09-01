package entity.database;

/**
 * Created by kangbiao on 15-8-27.
 */
public class ComplainEntity
{
    private int complainId;
    private String title;
    private String detail;
    private String picPath;
    private String createTime;
    private Integer status;
    private Integer score;
    private Integer adminId;
    private Integer userId;
    private AdminEntity adminByAdminId;
    private UserEntity userByUserId;

    public int getComplainId()
    {
        return complainId;
    }

    public void setComplainId(int complainId)
    {
        this.complainId = complainId;
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

    public String getPicPath()
    {
        return picPath;
    }

    public void setPicPath(String picPath)
    {
        this.picPath = picPath;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public Integer getAdminId()
    {
        return adminId;
    }

    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ComplainEntity that = (ComplainEntity) o;

        if (complainId != that.complainId)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null)
            return false;
        if (picPath != null ? !picPath.equals(that.picPath) : that.picPath != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null)
            return false;
        if (score != null ? !score.equals(that.score) : that.score != null)
            return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = complainId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (picPath != null ? picPath.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public AdminEntity getAdminByAdminId()
    {
        return adminByAdminId;
    }

    public void setAdminByAdminId(AdminEntity adminByAdminId)
    {
        this.adminByAdminId = adminByAdminId;
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
