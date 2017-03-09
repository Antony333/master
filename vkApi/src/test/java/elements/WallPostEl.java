package elements;

import framework.elements.Element;
import org.openqa.selenium.By;

public class WallPostEl {
    private final Element like = new Element(By.xpath("//a[contains(@class, 'post_like _like_wrap')]"), "Like");
    private final String wallPostCommentsTemplate = "//div[contains(@id,'%d')]//div[@class='reply reply_dived clear  reply_replieable _post']";
    //Element comment = new Element(By.xpath(String.format(wallPostCommentsTemplate, post.getPostId())));
    private final Element commentTextEl = new Element(By.xpath("//div[@class='wall_reply_text']"));
}
