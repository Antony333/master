package apilib.queries.wall.temporary;

import framework.ReadData;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class WallEditQueryTest {
    public JSONObject edit(int userId, int postId, String message, String photo) {
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setPath(String.format(ReadData.getProperty("api_address"), "wall.edit"))
                .setParameter("owner_id", String.valueOf(userId))
                .setParameter("post_id", String.valueOf(postId))
                .setParameter("attachments", photo)
                .setParameter("message", message)
                .setParameter("access_token", ReadData.getProperty("token"));

        return HttpUtils.sendGet(uriBuilder.toString());
    }
}
