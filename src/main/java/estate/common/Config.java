package estate.common;


import java.util.HashMap;

/**
 * Created by kangbiao on 15-9-5.
 * 系统配置
 */
public class Config
{
    //路径配置
    public static final String PICPATH=System.getProperty("WEB.ROOT")+"file/picture/";
    public static final String DOCPATH=System.getProperty("WEB.ROOT")+"file/documentPath/";

    public static final String PICWEBPATH="/oa/file/picture/";

    //常量配置
    public static HashMap<Integer,String> KV=new HashMap<Integer,String>();

//    private static void initKV()
//    {
//        KV.put()
//    }

}
