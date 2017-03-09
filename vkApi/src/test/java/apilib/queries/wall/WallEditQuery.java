package apilib.queries.wall;

import apilib.QueryBuilder;

public class WallEditQuery extends QueryBuilder {
    public WallEditQuery() {
        super("wall.edit");
    }

    public WallEditQuery ownerId(Integer value) {
        addParams("owner_id", value);
        return this;
    }
    
    protected WallEditQuery postId(int value) {
        addParams("post_id", value);
        return this;
    }
    
    public WallEditQuery friendsOnly(Boolean value) {
        addParams("friends_only", boolAsParam(value));
        return this;
    }
    
    public WallEditQuery message(String value) {
        addParams("message", value);
        return this;
    }
    
    public WallEditQuery attachments(String... value) {
        addParams("attachments", value);
        return this;
    }
    
    public WallEditQuery services(String value) {
        addParams("services", value);
        return this;
    }
    
    public WallEditQuery signed(Boolean value) {
        addParams("signed", boolAsParam(value));
        return this;
    }
    
    public WallEditQuery publishDate(Integer value) {
        addParams("publish_date", value);
        return this;
    }
    
    public WallEditQuery lat(Float value) {
        addParams("lat", value);
        return this;
    }
    
    public WallEditQuery lng(Float value) {
        addParams("long", value);
        return this;
    }
    
    public WallEditQuery placeId(Integer value) {
        addParams("place_id", value);
        return this;
    }
    
    public WallEditQuery markAsAds(Boolean value) {
        addParams("mark_as_ads", boolAsParam(value));
        return this;
    }
}
