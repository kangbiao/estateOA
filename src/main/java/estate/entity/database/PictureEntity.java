package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class PictureEntity
{
    private int id;
    private String name;
    private Long uploadTime;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getUploadTime()
    {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime)
    {
        this.uploadTime = uploadTime;
    }
}
