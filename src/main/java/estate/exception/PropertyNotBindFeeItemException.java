package estate.exception;

/**
 * Created by kangbiao on 15-10-8.
 * 物业没有绑定费用异常
 */
public class PropertyNotBindFeeItemException extends Exception
{
    public PropertyNotBindFeeItemException(){}

    public PropertyNotBindFeeItemException(String msg)
    {
        super(msg);
    }
}
