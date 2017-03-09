package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
    private static String propertyFilePath = "src/test/resources/config.properties";
    protected final static Properties properties = new Properties();

    public static void loadProperty() {
        try {
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getWaitingTime() {
        return Integer.parseInt(properties.getProperty("waiting_time"));
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}