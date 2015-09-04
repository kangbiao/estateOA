import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import estate.common.util.LogUtil;
import estate.entity.json.BasicJson;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kangbiao on 15-8-27.
 * 测试类
 */
public class Test
{
    public static void main(String args[]) {
        Gson gson=new GsonBuilder().serializeNulls().create();
        BasicJson basicJson=new BasicJson();
        basicJson.setStatus(true);
        basicJson.setErrorMsg("fds");
        HashMap hashMap=new HashMap();
        hashMap.put("1","value");
        hashMap.put("2", "value2");

        ArrayList arrayList=new ArrayList();
        arrayList.add(new BasicJson(false,"Sss"));
        arrayList.add("2");

        basicJson.setJsonString(arrayList);
        LogUtil.I("sss");
    }

}
