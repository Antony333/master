package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private final static String osName = System.getProperty("os.name").toLowerCase();
    private final static File downloadPath = new File("src/test/resources/WebDriverDownloads");

    public static WebDriver setUp(final String browserName) {
        switch (browserName) {
            case "firefox": {
                if (isWindows()) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                }

                if (isLinux()) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
                }

                return new FirefoxDriver();
            }

            case "chrome": {
                if (isWindows()) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                }

                if (isLinux()) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                }

                return new ChromeDriver();
            }

            default:
                return new ChromeDriver(getChromeOptions());
        }
    }

    public static boolean isWindows() {
        return osName.contains("win");
    }

    public static boolean isLinux() {
        return osName.contains("nix") || osName.contains("nux");
    }

    private static FirefoxProfile getFirefoxProfile() {
        //Create FireFox Profile object
        FirefoxProfile profile = new FirefoxProfile();

        //Set Location to store files after downloading.
        profile.setPreference("browser.download.dir", downloadPath.getAbsolutePath());
        profile.setPreference("browser.download.folderList", 2);

        //Set Preference to not show downloadPath download confirmation dialogue using MIME types Of different downloadPath extension types.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/x-debian-package, application/octet-stream");

        return profile;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", "true");
        prefs.put("download.default_directory", downloadPath.getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);

        return options;
    }

    public static File getDownloadPath() {
        return downloadPath;
    }
}
