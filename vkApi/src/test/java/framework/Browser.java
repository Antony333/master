package framework;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static final String BROWSER = "browser";

    private static WebDriver driver = null;
    private static Browser browser;

    public Browser() {
        ReadData.loadProperty();
        driver = BrowserFactory.setUp(ReadData.getProperty("browser"));
    }

    public static Browser getInstance() {
        if (browser == null) {

            browser = new Browser();
            Log.info("Driver instantiated");
            waitAndMaximize();
        }

        return browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void waitAndMaximize() {
        driver.manage().timeouts().pageLoadTimeout(ReadData.getWaitingTime(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Log.info("Page load timeout is set");
    }

    public static void visit(String URL) {
        driver.get(URL);
    }

    public static void close() {
        driver.quit();
        driver = null;
        Log.info("Driver is null");
    }
}
