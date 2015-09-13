package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class PictureEntity
{
    private int pictureId;
    private String name;
    private String description;
    private String dir;

    public int getPictureId()
    {
        return pictureId;
    }

    public void setPictureId(int pictureId)
    {
        this.pictureId = pictureId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDir()
    {
        return dir;
    }

    public void setDir(String dir)
    {
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PictureEntity that = (PictureEntity) o;

        if (pictureId != that.pictureId)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (dir != null ? !dir.equals(that.dir) : that.dir != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = pictureId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dir != null ? dir.hashCode() : 0);
        return result;
    }
}
