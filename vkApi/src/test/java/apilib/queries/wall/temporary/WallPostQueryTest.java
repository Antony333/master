package apilib.queries.wall.temporary;

import framework.ReadData;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import utils.HttpUtils;

public class WallPostQueryTest {
    public JSONObject post(int userId, String message) {
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setPath(String.format(ReadData.getProperty("api_address"), "wall.post"))
                .setParameter("owner_id", String.valueOf(userId))
                .setParameter("message", message)
                .setParameter("access_token", ReadData.getProperty("token"));

        return HttpUtils.sendGet(uriBuilder.toString());
    }
}
