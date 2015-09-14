package estate.entity.json;

/**
 * Created by kangbiao on 15-9-7.
 * 返回的表格数据体
 */
public class TableData extends BasicJson
{
    private String recordsTotal;
    private String recordsFiltered;

    public String getRecordsFiltered()
    {
        return recordsFiltered;
    }

    public void setRecordsFiltered(String recordsFiltered)
    {
        this.recordsFiltered = recordsFiltered;
    }

    public String getRecordsTotal()
    {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal)
    {
        this.recordsTotal = recordsTotal;
    }
}
