package estate.entity.database;

/**
 * Created by kangbiao on 15-9-13.
 *
 */
public class FeeItemEntity
{
    private Integer fiId;
    private String name;
    private String decription;
    private Integer feeTypeId;
    private Integer ruleId;
    private Byte isPeriodic;
    private Integer villageId;
    private RuleEntity ruleEntity;

    public Integer getFiId()
    {
        return fiId;
    }

    public void setFiId(Integer fsId)
    {
        this.fiId = fsId;
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

    public RuleEntity getRuleEntity()
    {
        return ruleEntity;
    }
    public void setRuleEntity(RuleEntity ruleEntity)
    {
        this.ruleEntity = ruleEntity;
    }
}
