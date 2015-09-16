package estate.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kangbiao on 15-9-15.
 * 提供数据库里面字段的转换
 */
public class Convert
{
    private static final int MAN=0;
    private static final int FEMANL=1;

    private static final int IDCARD=0;
    private static final int SOLDIER=1;

    private static final int TENANTING=0;
    private static final int USING=1;

    private static final int DEFAULTSTATUS=0;

    private static final int PROCESSING=1;



    public static String complainStatus2String(int status)
    {
        switch (status)
        {
            case DEFAULTSTATUS:
                return "待处理";
            case PROCESSING:
                return "处理中";
            default:
                return "未知状态";
        }
    }



    public static String propertyStatus2string(int status)
    {
        switch (status)
        {
            case 0:
                return "出租";
            case 1:
                return "自用";
            default:
                return "未知";
        }

    }



    /**
     * 数字和性别的相互转换
     * @param num
     * @return
     */
    public static String num2sex(int num)
    {
        switch (num)
        {
            case MAN:
                return "男";
            case FEMANL:
                return "女";
            default:
                return "未知";
        }
    }

    public static String num2idtype(int num)
    {
        switch (num)
        {
            case IDCARD:
                return "身份证";
            case SOLDIER:
                return "军官证";
            default:
                return "未知证件";
        }
    }

    /**
     * 时间转换
     * @param num
     * @return
     */
    public static String num2time(Long num)
    {
        Date date=new Date(num);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sdf.format(date);
        return sdf.format(date);
    }

    public static Long time2num(String time)
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try
        {
            date = simpleDateFormat.parse(time);
            return date.getTime();
        }
        catch (ParseException e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }
    }

    public static String num2time(Long num,String formater)
    {
        Date date=new Date(num);
        SimpleDateFormat sdf=new SimpleDateFormat(formater);
        sdf.format(date);
        return sdf.format(date);
    }

    public static Long time2num(String time,String formater)
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(formater);
        Date date;
        try
        {
            date = simpleDateFormat.parse(time);
            return date.getTime();
        }
        catch (ParseException e)
        {
            LogUtil.E(e.getMessage());
            return null;
        }
    }


    /**
     * 数字组成的字符串格式化为数字数组
     */
    public static List<Integer> string2ints(String string,String split)
    {
        String[] temp=string.split(split);
        List<Integer> ints=new ArrayList<Integer>();
        for (String aTemp : temp)
        {
            ints.add(Integer.valueOf(aTemp));
        }
        return ints;
    }
}
