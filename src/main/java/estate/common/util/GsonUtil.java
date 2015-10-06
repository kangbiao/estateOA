package estate.common.util;

import com.google.gson.Gson;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public class GsonUtil
{
    private static Gson gson;
    private GsonUtil(){}

    public static Gson getGson()
    {
        if (gson!=null)
            return gson;
        else
            return new Gson();
    }

}
