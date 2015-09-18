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

    //系统真假常量
    public static final Byte FALSE=0;
    public static final Byte TRUE=1;

    //常量配置
    public static HashMap<Integer,String> KV=new HashMap<Integer,String>();



    //费用类型相关配置
    public static final int ESTATE=0;
    public static final int SERVICE=1;
    public static final int PARKING_LOT=2;
    //    private static void initKV()
//    {
//        KV.put()
//    }

}
