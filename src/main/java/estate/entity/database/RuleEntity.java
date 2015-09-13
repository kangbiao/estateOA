package estate.entity.database;

import java.math.BigDecimal;

/**
 * Created by kangbiao on 15-9-13.
 */
public class RuleEntity
{
    private int ruleId;
    private BigDecimal unitPrice;
    private String unit;
    private String description;
    private BigDecimal overdueUnitPrice;
    private String overdueUnit;
    private Long startTime;
    private Long endTime;

    public int getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(int ruleId)
    {
        this.ruleId = ruleId;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getOverdueUnitPrice()
    {
        return overdueUnitPrice;
    }

    public void setOverdueUnitPrice(BigDecimal overdueUnitPrice)
    {
        this.overdueUnitPrice = overdueUnitPrice;
    }

    public String getOverdueUnit()
    {
        return overdueUnit;
    }

    public void setOverdueUnit(String overdueUnit)
    {
        this.overdueUnit = overdueUnit;
    }

    public Long getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Long startTime)
    {
        this.startTime = startTime;
    }

    public Long getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RuleEntity that = (RuleEntity) o;

        if (ruleId != that.ruleId)
            return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null)
            return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (overdueUnitPrice != null ? !overdueUnitPrice.equals(that.overdueUnitPrice) : that.overdueUnitPrice != null)
            return false;
        if (overdueUnit != null ? !overdueUnit.equals(that.overdueUnit) : that.overdueUnit != null)
            return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null)
            return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = ruleId;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (overdueUnitPrice != null ? overdueUnitPrice.hashCode() : 0);
        result = 31 * result + (overdueUnit != null ? overdueUnit.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
