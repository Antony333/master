package apilib.queries.wall;

import apilib.QueryBuilder;

public class WallCreateCommentQuery extends QueryBuilder {
    public WallCreateCommentQuery() {
        super("wall.createComment");
    }

    public WallCreateCommentQuery ownerId(Integer value) {
        addParams("owner_id", value);
        return this;
    }
    
    protected WallCreateCommentQuery postId(Integer value) {
        addParams("post_id", value);
        return this;
    }

    
    public WallCreateCommentQuery fromGroup(Boolean value) {
        addParams("from_group", boolAsParam(value));
        return this;
    }
    
    public WallCreateCommentQuery message(String value) {
        addParams("message", value);
        return this;
    }
    
    public WallCreateCommentQuery replyToComment(Integer value) {
        addParams("reply_to_comment", value);
        return this;
    }
    
    public WallCreateCommentQuery attachments(String... value) {
        addParams("attachments", value);
        return this;
    }
    
    public WallCreateCommentQuery stickerId(Integer value) {
        addParams("sticker_id", value);
        return this;
    }
    
    public WallCreateCommentQuery guid(String value) {
        addParams("guid", value);
        return this;
    }
}
