package estate.common;

import estate.exception.TypeErrorException;

/**
 * Created by kangbiao on 15-10-9.
 *
 */
public class AppUserStatus
{
    public final static Byte DISABLE=-1;
    public final static Byte ENABLE=1;
    public final static Byte FORCHECK=0;

    public static boolean checkType(Byte type) throws TypeErrorException
    {
        if (!(type.equals(DISABLE)||type.equals(ENABLE)||type.equals(FORCHECK)))
            throw new TypeErrorException("用户状态参数错误");
        return true;
    }
}
