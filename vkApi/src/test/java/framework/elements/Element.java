package framework.elements;

import framework.Browser;
import framework.Log;
import framework.ReadData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element {
    protected WebElement element;
    protected static final WebDriver driver = Browser.getInstance().getDriver();
    protected By locator;
    protected String name;

    public Element(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public Element(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void waitElement() {
        ExpectedCondition<Boolean> elementLoadCondition = driver1 -> {
            try {
                List<WebElement> elements = driver.findElements(locator);

                for (WebElement el : elements) {
                    if (el.isDisplayed()) {
                        element = el;
                        return element.isDisplayed();
                    }
                }
                element = driver.findElement(locator);
            } catch (Exception e) {
                return false;
            }
            return true;
        };

        WebDriverWait wait = new WebDriverWait(driver, ReadData.getWaitingTime());
        wait.until(elementLoadCondition);
    }

    public boolean isDisplayed() {
        waitElement();
        return element.isDisplayed();
    }

    public boolean isEnabled() {
        waitElement();
        return element.isEnabled();
    }

    public String getText() {
        waitElement();
        return element.getText();
    }

    public String getAttribute(String attribute) {
        waitElement();
        return element.getAttribute(attribute);
    }

    public void click() {
        waitElement();
        element.click();
        Log.info("Click " + name);
    }

    public void sendKeys(String keys) {
        waitElement();
        element.sendKeys(keys);
    }

    public WebElement getElement() {
        return element;
    }

    public WebElement findElement(By locator) {
        waitElement();
        return element.findElement(locator);
    }

    public List<WebElement> findAll() {
        try {
            waitElement();
            return driver.findElements(this.getLocator());
        } catch (TimeoutException e) {
            return driver.findElements(this.getLocator());
        }
    }
}