package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class FeeItemOrderEntity
{
    private int id;
    private Integer propertyId;
    private Integer feeItemId;
    private Byte isBilled;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getPropertyId()
    {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId)
    {
        this.propertyId = propertyId;
    }

    public Integer getFeeItemId()
    {
        return feeItemId;
    }

    public void setFeeItemId(Integer feeItemId)
    {
        this.feeItemId = feeItemId;
    }

    public Byte getIsBilled()
    {
        return isBilled;
    }

    public void setIsBilled(Byte isBilled)
    {
        this.isBilled = isBilled;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        FeeItemOrderEntity that = (FeeItemOrderEntity) o;

        if (id != that.id)
            return false;
        if (propertyId != null ? !propertyId.equals(that.propertyId) : that.propertyId != null)
            return false;
        if (feeItemId != null ? !feeItemId.equals(that.feeItemId) : that.feeItemId != null)
            return false;
        if (isBilled != null ? !isBilled.equals(that.isBilled) : that.isBilled != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (propertyId != null ? propertyId.hashCode() : 0);
        result = 31 * result + (feeItemId != null ? feeItemId.hashCode() : 0);
        result = 31 * result + (isBilled != null ? isBilled.hashCode() : 0);
        return result;
    }
}
