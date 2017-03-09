package models;

import java.util.ArrayList;

public class WallPost {
    private int userId;
    private String message;
    private int postId;
    private ArrayList<String> attachments = new ArrayList<>();

    public WallPost(int userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAttachments() {
        return String.join(",", attachments);
    }

    public void addAttachment(String attachment) {
        attachments.add(attachment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WallPost wallPost = (WallPost) o;

        if (userId != wallPost.userId) return false;
        return message.equals(wallPost.message);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + message.hashCode();
        return result;
    }
}