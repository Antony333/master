package apilib.queries.wall;

import apilib.QueryBuilder;

public class WallPostQuery extends QueryBuilder {
    public WallPostQuery() {
        super("wall.post");
    }

    public WallPostQuery ownerId(Integer value) {
        addParams("owner_id", value);
        return this;
    }
    
    public WallPostQuery friendsOnly(Boolean value) {
        addParams("friends_only", value);
        return this;
    }
    
    public WallPostQuery fromGroup(Boolean value) {
        addParams("from_group", value);
        return this;
    }
    
    public WallPostQuery message(String value) {
        addParams("message", value);
        return this;
    }
    
    public WallPostQuery attachments(String... value) {
        addParams("attachments", value);
        return this;
    }
    
    public WallPostQuery services(String value) {
        addParams("services", value);
        return this;
    }
    
    public WallPostQuery signed(Boolean value) {
        addParams("signed", value);
        return this;
    }
    
    public WallPostQuery publishDate(Integer value) {
        addParams("publish_date", value);
        return this;
    }
    
    public WallPostQuery lat(Float value) {
        addParams("lat", value);
        return this;
    }
    
    public WallPostQuery lng(Float value) {
        addParams("long", value);
        return this;
    }
    
    public WallPostQuery placeId(Integer value) {
        addParams("place_id", value);
        return this;
    }
    
    public WallPostQuery postId(Integer value) {
        addParams("post_id", value);
        return this;
    }
    
    public WallPostQuery guid(String value) {
        addParams("guid", value);
        return this;
    }
    
    public WallPostQuery markAsAds(Boolean value) {
        addParams("mark_as_ads", value);
        return this;
    }
}
