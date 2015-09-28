package estate.common.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by kangbiao on 15-9-15.
 * 发送短信通知
 */
public class Message
{
    public static String send(String mobile, String content)
    {
        String sign="VerPass";

        StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");
        sb.append("name=VerPass@163.com");
        sb.append("&pwd=0C9E4B9FCDD8A770110444E6A7B8");
        sb.append("&mobile="+mobile);
        sb.append("&content="+ URLEncoder.encode(content));
        sb.append("&sign="+URLEncoder.encode(sign));
        sb.append("&type=pt&extno=");
        URL url = null;
        try
        {
            url = new URL(sb.toString());
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try
        {
            connection = (HttpURLConnection) url.openConnection();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            connection.setRequestMethod("POST");
        }
        catch (ProtocolException e)
        {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String inputline = null;
        try
        {
            inputline = in.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(inputline);
        String[] strings=inputline.split(",");
        switch (strings[0])
        {
            case "0":
                return "succ";
            case "1":
                return "含有敏感词汇";
            case "2":
                return "余额不足";
            case "3":
                return "请指定接受者电话";
            case "4":
                return "包含sql语句";
            case "10":
                return "账号不存在";
            default:
                return "未知错误";
        }
    }

    @Test
    public void test()
    {
        System.out.print(send("15114052120","感谢您注册xxx您的验证码是123"));
    }

}
