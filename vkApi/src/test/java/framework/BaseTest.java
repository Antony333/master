package framework;

import org.testng.annotations.AfterTest;

public class BaseTest {
    protected SoftAssert softAssert = new SoftAssert();

    @AfterTest
    public void afterTest(){
        softAssert.assertAll();
    }
}
