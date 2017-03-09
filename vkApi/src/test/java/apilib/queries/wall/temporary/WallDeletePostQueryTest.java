package apilib.queries.wall.temporary;

import framework.ReadData;
import models.WallPost;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import utils.HttpUtils;

public class WallDeletePostQueryTest {
    public JSONObject delete(WallPost post) {
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setPath(String.format(ReadData.getProperty("api_address"), "wall.delete"))
                .setParameter("owner_id", String.valueOf(post.getUserId()))
                .setParameter("post_id", String.valueOf(post.getPostId()))
                .setParameter("access_token", ReadData.getProperty("token"));

        return HttpUtils.sendGet(uriBuilder.toString());
    }
}
