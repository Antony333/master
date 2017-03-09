package apilib.queries.users;

import framework.ReadData;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import utils.HttpUtils;

public class UsersGetQueryTest {
    public JSONObject usersGet() {
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setPath(String.format(ReadData.getProperty("api_address"), "users.get"))
                .setParameter("access_token", ReadData.getProperty("token"));

        return HttpUtils.sendGet(uriBuilder.toString());
    }
}
