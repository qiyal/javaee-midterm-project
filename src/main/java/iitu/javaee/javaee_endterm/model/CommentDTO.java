package iitu.javaee.javaee_endterm.model;

public class CommentDTO {
    private Comment comment;
    private String username;
    private String userImg;

    public CommentDTO(Comment comment, String username, String userImg) {
        this.comment = comment;
        this.username = username;
        this.userImg = userImg;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
