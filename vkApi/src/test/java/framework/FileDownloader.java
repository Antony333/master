package framework;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

public class FileDownloader {
    @Step("Chech that file {1} was download to {0}")
    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        ExpectedCondition<Boolean> fileLoadCondition = driver1 -> {
            Log.info("Waiting file to download");

            File dir = new File(downloadPath);
            File[] dirContents = dir.listFiles();

            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().equals(fileName) && dirContents[i].length() > 0)
                    return true;
            }

            return false;
        };

        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), ReadData.getWaitingTime());
        wait.until(fileLoadCondition);
        Log.info(String.format("File %s was download do %s", fileName, downloadPath));

        return true;
    }
}
