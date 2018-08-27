package com.anran.tmall.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Anakin(Administrator)
 * @date 2018/8/24 15:12
 * 描述     ${TODO}
 */
public class LogUtil {
    static Logger logger = Logger.getLogger(LogUtil.class);

    static {
        PropertyConfigurator.configure("E:\\project\\tmall_ssm\\src\\main\\resources\\log4j.properties");
    }
    public static void d(String msg) {
        String tag = "zar";
        d(tag, msg);
    }

    public static void d(String tag, String msg) {
        logger.debug(tag + "   :  " + msg);
    }

    public static void e(String msg) {
        String tag = "zar";
        e(tag, msg);
    }

    public static void e(String tag, String msg) {
        logger.error(tag + "   :  " + msg);
    }

}
