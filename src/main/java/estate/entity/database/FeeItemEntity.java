package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 */
public class FeeItemEntity
{
    private int fsId;
    private String name;
    private String decription;
    private Integer feeTypeId;
    private Integer ruleId;
    private Byte isPeriodic;
    private Integer villageId;

    public int getFsId()
    {
        return fsId;
    }

    public void setFsId(int fsId)
    {
        this.fsId = fsId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDecription()
    {
        return decription;
    }

    public void setDecription(String decription)
    {
        this.decription = decription;
    }

    public Integer getFeeTypeId()
    {
        return feeTypeId;
    }

    public void setFeeTypeId(Integer feeTypeId)
    {
        this.feeTypeId = feeTypeId;
    }

    public Integer getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(Integer ruleId)
    {
        this.ruleId = ruleId;
    }

    public Byte getIsPeriodic()
    {
        return isPeriodic;
    }

    public void setIsPeriodic(Byte isPeriodic)
    {
        this.isPeriodic = isPeriodic;
    }

    public Integer getVillageId()
    {
        return villageId;
    }

    public void setVillageId(Integer villageId)
    {
        this.villageId = villageId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        FeeItemEntity that = (FeeItemEntity) o;

        if (fsId != that.fsId)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (decription != null ? !decription.equals(that.decription) : that.decription != null)
            return false;
        if (feeTypeId != null ? !feeTypeId.equals(that.feeTypeId) : that.feeTypeId != null)
            return false;
        if (ruleId != null ? !ruleId.equals(that.ruleId) : that.ruleId != null)
            return false;
        if (isPeriodic != null ? !isPeriodic.equals(that.isPeriodic) : that.isPeriodic != null)
            return false;
        if (villageId != null ? !villageId.equals(that.villageId) : that.villageId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = fsId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (decription != null ? decription.hashCode() : 0);
        result = 31 * result + (feeTypeId != null ? feeTypeId.hashCode() : 0);
        result = 31 * result + (ruleId != null ? ruleId.hashCode() : 0);
        result = 31 * result + (isPeriodic != null ? isPeriodic.hashCode() : 0);
        result = 31 * result + (villageId != null ? villageId.hashCode() : 0);
        return result;
    }
}
