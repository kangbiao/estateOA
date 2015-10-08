package estate.exception;

/**
 * Created by kangbiao on 15-10-8.
 */
public class EntityTypeErrorException extends Exception
{
    public EntityTypeErrorException(){}

    public EntityTypeErrorException(String msg)
    {
        super(msg);
    }
}
