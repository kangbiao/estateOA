package estate.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * Created by kangbiao on 15-8-28.
 * 错误日志记录工具类
 */
public class LogUtil
{
    private static Logger logger;

    private LogUtil() {
    }

    static {
        ConfigurationSource source;
        try {
            String path= "/config/log4j.xml";
            URL url=LogUtil.class.getResource(path);
            source = new ConfigurationSource(new FileInputStream(new File(url.getPath())),url);
            Configurator.initialize(null, source);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void E(String message,Class cla) {
        logger=LogManager.getLogger(cla);
        logger.error(message);
    }

    public static void I(String message) {
        logger.info(message);
    }
}
