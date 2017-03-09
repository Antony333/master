package apilib.queries.wall.temporary;

import framework.ReadData;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class WallCreateCommentQueryTest {
    public JSONObject createComment(int userId, int postId, String message) {
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setPath(String.format(ReadData.getProperty("api_address"), "wall.createComment"))
                .setParameter("owner_id", String.valueOf(userId))
                .setParameter("post_id", String.valueOf(postId))
                .setParameter("message", message)
                .setParameter("access_token", ReadData.getProperty("token"));

        return HttpUtils.sendGet(uriBuilder.toString());
    }
}
