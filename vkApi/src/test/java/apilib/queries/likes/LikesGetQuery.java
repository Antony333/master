package apilib.queries.likes;

import apilib.QueryBuilder;
import org.json.JSONObject;
import utils.HttpUtils;

public class LikesGetQuery extends QueryBuilder {
    public LikesGetQuery() {
        super("likes.getList");
    }

    public LikesGetQuery type(String type) {
        addParams("type", type);
        return this;
    }

    public LikesGetQuery ownerId(Integer value) {
        addParams("owner_id", value);
        return this;
    }


    public LikesGetQuery itemId(Integer value) {
        addParams("item_id", value);
        return this;
    }


    public LikesGetQuery pageUrl(String value) {
        addParams("page_url", value);
        return this;
    }


    public LikesGetQuery filter(String value) {
        addParams("filter", value);
        return this;
    }


    public LikesGetQuery friendsOnly(Boolean value) {
        addParams("friends_only", boolAsParam(value));
        return this;
    }


    public LikesGetQuery offset(Integer value) {
        addParams("offset", value);
        return this;
    }


    public LikesGetQuery count(Integer value) {
        addParams("count", value);
        return this;
    }


    public LikesGetQuery skipOwn(Boolean value) {
        addParams("skip_own", boolAsParam(value));
        return this;
    }
}