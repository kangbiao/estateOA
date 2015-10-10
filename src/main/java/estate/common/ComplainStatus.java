package estate.common;

import estate.exception.TypeErrorException;

/**
 * Created by kangbiao on 15-10-10.
 *
 */
public class ComplainStatus
{
    public final static Byte FORPROCESS=0;
    public final static Byte HADPROCESS=1;
    public final static Byte HADCOMMENT=2;

    public static boolean checkType(Byte type) throws TypeErrorException
    {
        if (!(type.equals(FORPROCESS)||type.equals(HADPROCESS)||type.equals(HADCOMMENT)))
            throw new TypeErrorException("投诉参数错误");
        return true;
    }
}
