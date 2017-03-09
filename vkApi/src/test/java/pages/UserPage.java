package pages;

import apilib.actions.*;
import apilib.queries.likes.LikesGetQuery;
import apilib.queries.users.UsersGetQuery;
import apilib.queries.wall.WallDeletePostQuery;
import apilib.queries.wall.WallPostQuery;
import elements.SideBarMenu;
import framework.Log;
import framework.ReadData;
import framework.elements.Element;
import models.WallComment;
import models.WallPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import utils.TextRandomizer;

import java.util.ArrayList;
import java.util.List;

public class UserPage {
    public final SideBarMenu menu = new SideBarMenu();

    private final Element wallPost = new Element(By.xpath("//div[@class='_post post page_block all own']"));
    private final String wallPostCommentsTemplate = "//div[contains(@id,'%d')]//div[@class='reply reply_dived clear  reply_replieable _post']";
    private final Element likePost = new Element(By.xpath("//a[contains(@class, 'post_like _like_wrap')]"), "Like");

    private int userId = 0;

    private void setUserId() {
        JSONObject users = new UsersGetQuery().getResponse();

        try {
            JSONArray responsed = users.getJSONArray("response");
            JSONObject jo = responsed.getJSONObject(0);
            userId = jo.getInt("uid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getUserId() {
        if (userId == 0) {
            setUserId();
        }

        return userId;
    }

    public WallPost postWallAndGet() {
        getUserId();

        WallPost wallPost = new WallPost(userId, TextRandomizer.getRandomString());
        //JSONObject jsonPost = new Wall().post(wallPost);
        JSONObject jsonPost = new WallPostQuery()
                .ownerId(wallPost.getUserId())
                .message(wallPost.getMessage())
                .getResponse();

        try {
            JSONObject responsed = jsonPost.getJSONObject("response");
            wallPost.setPostId(responsed.getInt("post_id"));
            Log.info(String.format("Create post №%d with message %s", wallPost.getPostId(), wallPost.getMessage()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return wallPost;
    }

    public WallPost getFirstPost() {
        By textLocator = By.xpath("//div[@class='wall_post_text']");
        By imageLocator = By.xpath("//div[@class='page_post_sized_thumbs  clear_fix']");

        String postId = wallPost.getAttribute("id").replaceAll("\\p{Alpha}", "");
        int userId = Integer.valueOf(postId.split("_")[0]);
        String postText = wallPost.findElement(textLocator).getText();

        return new WallPost(userId, postText);
    }

    public WallPost editPostAndGet(WallPost wallPostForEdit) {
        String photo = ReadData.getProperty("photo");
        String message = TextRandomizer.getRandomString();

        wallPostForEdit.addAttachment(photo);
        wallPostForEdit.setMessage(message);
        new Wall().edit(wallPostForEdit);
        Log.info(String.format("Add %s to post and change message to %s", photo, message));
        return wallPostForEdit;
    }

    public WallComment addCommentToWallPostAndGet(WallPost post) {
        getUserId();

        WallComment comment = new WallComment(post.getPostId(), userId, TextRandomizer.getRandomString());
        JSONObject jsonPost = new Wall().addComment(post, comment.getMessage());

        try {
            JSONObject responsed = jsonPost.getJSONObject("response");
            comment.setCommentId(responsed.getInt("cid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.info(String.format("Add comment with text: %s to post №%d", comment.getMessage(), post.getPostId()));

        return comment;
    }

    public WallComment getCommentForPost(WallPost post) {
        Element comment = new Element(By.xpath(String.format(wallPostCommentsTemplate, post.getPostId())));
        Element commentTextEl = new Element(By.xpath("//div[@class='wall_reply_text']"));

        String commentId = comment.getAttribute("id").replaceAll("\\p{Alpha}", "");
        int userId = Integer.valueOf(commentId.split("_")[0]);
        String commentText = comment.findElement(commentTextEl.getLocator()).getText();

        return new WallComment(post.getPostId(), userId, commentText);
    }

    public void likePost(WallPost post) {
        likePost.click();
    }

    public List<Integer> getLikeUsersForPost(WallPost post) {
        List<Integer> usersId = new ArrayList<>();

        JSONObject response = new LikesGetQuery()
                .type("post")
                .ownerId(post.getUserId())
                .itemId(post.getPostId())
                .getResponse();

        try {
            JSONObject responsed = response.getJSONObject("response");
            JSONArray users = responsed.getJSONArray("users");

            for (int i = 0; i < users.length(); i++) {
                usersId.add(users.getInt(i));
            }

            return usersId;
        } catch (JSONException e) {
            e.printStackTrace();

            return usersId;
        }
    }

    public void deleteWallPost(WallPost post) {
        new WallDeletePostQuery()
                .ownerId(post.getUserId())
                .postId(post.getPostId())
                .getResponse();
    }
}