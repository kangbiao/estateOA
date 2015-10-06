package estate.common.util;

import org.junit.Test;

import java.util.Random;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public class VerifyCodeGenerate
{
    public static String create()
    {
        Random random=new Random();
        LogUtil.E(random.nextInt(899999)+100000);
        return String.valueOf(random.nextInt(899999)+100000);
    }


    @Test
    public void test()
    {
        create();
    }
}
