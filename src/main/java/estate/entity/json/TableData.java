package estate.entity.json;

/**
 * Created by kangbiao on 15-9-7.
 * 返回的表格数据体
 */
public class TableData extends BasicJson
{
    private Integer recordsTotal;
    private Integer recordsFiltered;

    public TableData(){}

    public TableData(Boolean status)
    {
        super(status);
    }

    public Integer getRecordsFiltered()
    {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered)
    {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getRecordsTotal()
    {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal)
    {
        this.recordsTotal = recordsTotal;
    }
}
