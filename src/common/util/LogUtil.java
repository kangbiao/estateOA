package common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by kangbiao on 15-8-28.
 * 错误日志记录工具类
 */
public class LogUtil
{
    private static final String LogConf = "logconf.xml";
    private static Logger logger;

    private LogUtil() {
    }

    static {
        if (logger == null)
            logger = LogManager.getLogger();
    }

    public static void E(String message) {
        logger.error(message);
    }

    public static void I(String message) {
        logger.info(message);
    }
}
