package estate.exception;

/**
 * Created by kangbiao on 15-10-4.
 * APP用户不存在的异常类
 */
public class AppUserNotExitException extends Exception
{
    public AppUserNotExitException(){}

    public AppUserNotExitException(String msg)
    {
        super(msg);
    }

}
