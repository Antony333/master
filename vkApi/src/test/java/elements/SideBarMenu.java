package elements;

import framework.elements.Element;
import org.openqa.selenium.By;

public class SideBarMenu {
    private final String menuItemTemplate = "//div[@id='side_bar_inner']//a[@class='left_row']//*[contains(text(), '%s')]";

    public void clickMenuItem(String menuName) {
        Element menuItem = new Element(By.xpath(String.format(menuItemTemplate, menuName)), menuName);
        menuItem.click();
    }
}