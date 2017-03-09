package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ComboBox extends Element {
    private Select select;

    public ComboBox(By locator) {
        super(locator, "ComboBox");
    }

    @Override
    public boolean isDisplayed() {
        waitElement();
        select = new Select(element);
        return super.isDisplayed();
    }

    public List<WebElement> getOptions() {
        List<WebElement> options = new ArrayList<>();

        if (isDisplayed()) {
            options = select.getOptions();

            for (WebElement option : new ArrayList<>(options)) {
                if (option.getAttribute("disabled") != null) {
                    options.remove(option);
                }
            }
        }

        return options;
    }

    public void selectByVisibleText(String text) {
        if (isDisplayed()) {
            select.selectByVisibleText(text);
        }
    }
}
