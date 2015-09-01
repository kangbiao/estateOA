package entity.json;

/**
 * Created by kangbiao on 15-8-27.
 * 基础的json实体类
 */
public class BasicJson
{
    protected boolean status=false;
    protected String errorMsg=null;
    protected Object jsonString;

    public BasicJson(boolean status,String errorMsg)
    {
        this.status=status;
        this.errorMsg=errorMsg;
    }

    public BasicJson(){}

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public Object getJsonString()
    {
        return this.jsonString;
    }

    public void setJsonString(Object object)
    {
        this.jsonString=object;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
}
