package models;

public class WallComment {
    private int postId;
    private int commentId;
    private int userId;
    private String message;

    public WallComment(int postId, int userId, String message) {
        this.postId = postId;
        this.userId = userId;
        this.message = message;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public int getPostId() {
        return postId;
    }
}
