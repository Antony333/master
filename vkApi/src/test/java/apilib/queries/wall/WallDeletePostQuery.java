package apilib.queries.wall;

import apilib.QueryBuilder;

public class WallDeletePostQuery extends QueryBuilder {
    public WallDeletePostQuery() {
        super("wall.delete");
    }

    public WallDeletePostQuery ownerId(Integer value) {
        addParams("owner_id", value);
        return this;
    }

    
    public WallDeletePostQuery postId(Integer value) {
        addParams("post_id", value);
        return this;
    }

}
