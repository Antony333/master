package apilib.actions;

import apilib.queries.wall.temporary.WallCreateCommentQueryTest;
import apilib.queries.wall.temporary.WallDeletePostQueryTest;
import apilib.queries.wall.temporary.WallEditQueryTest;
import apilib.queries.wall.temporary.WallPostQueryTest;
import models.WallPost;
import org.json.JSONObject;

public class Wall {
    public JSONObject post(WallPost wallPost) {
        return new WallPostQueryTest().post(wallPost.getUserId(), wallPost.getMessage());
    }

    public JSONObject edit(WallPost wallPost) {
        return new WallEditQueryTest().edit(wallPost.getUserId(), wallPost.getPostId(), wallPost.getMessage(), wallPost.getAttachments());
    }

    public JSONObject addComment(WallPost wallPost, String message) {
        return new WallCreateCommentQueryTest().createComment(wallPost.getUserId(), wallPost.getPostId(), message);
    }

    public JSONObject deleteWallPost(WallPost wallPost) {
        return new WallDeletePostQueryTest().delete(wallPost);
    }
}
