package web.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kangbiao on 15-8-27.
 * 返回的ajax json数据
 */
public class AjaxJsonReturn
{
    private boolean status=false;
    private String errorMsg=null;
    private HashMap<String,Object> jsonString= new HashMap<>();

    public void setStatus(boolean status)
    {
        this.status=status;
    }

    public void setErrorMsg(String msg)
    {
        this.errorMsg=msg;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void putJsonString(String string,ArrayList<Object> list)
    {
        jsonString.put(string,list);
    }

}
