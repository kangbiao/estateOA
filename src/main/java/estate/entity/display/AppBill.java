package estate.entity.display;

/**
 * Created by kangbiao on 15-10-8.
 * app端账单数据实体
 */
public class AppBill
{
    private String total;
    private Object items;
    private Byte status;
    private String billTime;

    public Object getItems()
    {
        return items;
    }

    public void setItems(Object items)
    {
        this.items = items;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }

    public String getTotal()
    {
        return total;
    }

    public void setTotal(String total)
    {
        this.total = total;
    }

    public String getBillTime()
    {
        return billTime;
    }

    public void setBillTime(String billTime)
    {
        this.billTime = billTime;
    }
}
