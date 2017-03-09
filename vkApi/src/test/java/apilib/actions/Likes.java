package apilib.actions;

import apilib.queries.likes.LikesGetQuery;
import models.WallPost;
import org.json.JSONObject;

public class Likes {
    public JSONObject getLikes(String type, WallPost post) {
        return new LikesGetQuery().getResponse();
    }
}
