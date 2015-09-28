import estate.common.util.LogUtil;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kangbiao on 15-9-28.
 *
 */
public class HttpSessionTest
{
    @Test
    public void test() throws IOException
    {
//        URL url=new URL("http://localhost:8090/oa/api/user/notice");
//        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
//        connection.setRequestProperty("cookie","JSESSIONID=4163876723D37C3E0B0F052885CAA05C");
//        String cookie=connection.getHeaderField("set-cookie");
        HttpGet he=new HttpGet();
        String sessionKV=null;
        String cookie="age=Sdsad;JSESSIONID=sadsad;name=dasd";
        if (cookie!=null)
        {
            String JsessionStart=cookie.substring(cookie.indexOf("JSESSIONID"),cookie.length());
            sessionKV=JsessionStart.substring(0,JsessionStart.indexOf(";"));

        }

        LogUtil.E("dsf:"+sessionKV);

    }
//    HttpURLConnection
}
