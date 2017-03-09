import framework.BaseTest;
import framework.Browser;
import framework.ReadData;
import models.WallComment;
import models.WallPost;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewsPage;
import pages.UserPage;

import java.util.List;

public class VkAPITest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private NewsPage newsPage = new NewsPage();
    private UserPage userPage = new UserPage();

    private WebDriver driver;

    private String email = ReadData.getProperty("email");
    private String password = ReadData.getProperty("password");

    @BeforeTest
    public void before() {
        driver = Browser.getInstance().getDriver();
        driver.get(ReadData.getProperty("url"));
    }

    @Test
    public void vk() {
        loginPage.loginAs(email, password);
        newsPage.menu.clickMenuItem("Моя Страница");

        WallPost expectedWallPost = userPage.postWallAndGet();
        WallPost actualWallPost = userPage.getFirstPost();

        softAssert.assertEquals(actualWallPost.getMessage(), expectedWallPost.getMessage(), "Text don't match");
        softAssert.assertEquals(actualWallPost.getUserId(), expectedWallPost.getUserId(), "Users don't match");

        WallPost editedPost = userPage.editPostAndGet(expectedWallPost);

        WallComment expectedComment = userPage.addCommentToWallPostAndGet(editedPost);
        WallComment actualComment = userPage.getCommentForPost(editedPost);

        softAssert.assertEquals(actualComment.getPostId(), expectedComment.getPostId(), "Post id for comment don't match");
        softAssert.assertEquals(actualComment.getUserId(), expectedComment.getUserId(), "Users for comment don't match");

        userPage.likePost(editedPost);

        List<Integer> usersLike = userPage.getLikeUsersForPost(editedPost);
        softAssert.assertTrue(usersLike.contains(editedPost.getUserId()), "User " + userPage.getUserId() + " like don't found");

        userPage.deleteWallPost(editedPost);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}