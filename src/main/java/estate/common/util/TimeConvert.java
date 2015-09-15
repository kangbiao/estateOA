package estate.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kangbiao on 15-9-15.
 * 提供时间戳和时间的相互转换
 */
public class TimeConvert
{
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
}
