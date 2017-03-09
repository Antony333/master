package pages;

import framework.elements.Button;
import framework.elements.Element;
import org.openqa.selenium.By;

public class LoginPage {
    private final Element username = new Element(By.id("index_email"));
    private final Element password = new Element(By.id("index_pass"));
    private final Button loginBtn = new Button(By.id("index_login_button"), "Login");

    public LoginPage typeUsername(String name) {
        username.sendKeys(name);

        return this;
    }

    public LoginPage typePassword(String pass) {
        password.sendKeys(pass);

        return this;
    }

    public NewsPage submitLogin() {
        loginBtn.click();

        return new NewsPage();
    }

    public NewsPage loginAs(String user, String pass) {
        typeUsername(user);
        typePassword(pass);

        return submitLogin();
    }
}