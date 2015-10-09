package estate.common;

import estate.exception.TypeErrorException;

/**
 * Created by kangbiao on 15-10-9.
 */
public class SexType
{
    public final static Byte MAN=0;
    public final static Byte WOMAN=1;

    public static boolean checkType(Byte type) throws TypeErrorException
    {
        if (!(type.equals(MAN)||type.equals(WOMAN)))
            throw new TypeErrorException("参数错误");
        return true;
    }
}
