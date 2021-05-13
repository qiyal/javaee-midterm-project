package iitu.javaee.javaee_endterm.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private Integer comment_id = -1;
    private Integer user_id = -1;
    private Integer book_id = -1;
    private String text = "";

    public Comment() {}

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
