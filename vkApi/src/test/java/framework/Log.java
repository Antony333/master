package framework;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
    private static Logger Log = Logger.getLogger(framework.Log.class.getName());
    private static final String logPropertiesFilePath = "src/test/resources/log4j.xml";

    {
        DOMConfigurator.configure(logPropertiesFilePath);
    }

    public static void startTestCase(String sTestCaseName){
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }

    public static void endTestCase(String sTestCaseName){
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX       "+ sTestCaseName + "-E---N---D-"+"       XXXXXXXXXXXXXXXXXXXXXX");
        Log.info("X");
        Log.info("X");
        Log.info("X");
        Log.info("X");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}