package iitu.javaee.javaee_endterm.db.dao;

import iitu.javaee.javaee_endterm.db.DBConnection;
import iitu.javaee.javaee_endterm.db.DBData;
import iitu.javaee.javaee_endterm.model.Book;
import iitu.javaee.javaee_endterm.model.Comment;
import iitu.javaee.javaee_endterm.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private DBConnection dbConnection;
    private String tableName;

    public CommentDao() {
        this.dbConnection = new DBConnection(DBData.URL, DBData.USERNAME, DBData.PASSWORD);
        this.tableName = "comment";
    }

    public Comment getCommentObject(Integer commentId, Integer userId, Integer bookId, String text) {
        Comment comment = new Comment();
        comment.setComment_id(commentId);
        comment.setUser_id(userId);
        comment.setBook_id(bookId);
        comment.setText(text);

        return comment;
    }

    public List<Comment> getCommentsByBookId(Integer bookId) {
        dbConnection.openConnect();
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " WHERE book_id = " + bookId;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            while (resultSet.next()) {
                Integer commentId = resultSet.getInt("comment_id");
                Integer userId = resultSet.getInt("user_id");
                Integer bookId_ = resultSet.getInt("book_id");
                String text = resultSet.getString("text");
                comments.add(getCommentObject(commentId, userId, bookId_, text));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public void createComment(Comment comment) {
        dbConnection.openConnect();
        String INSERT_USERS_SQL = "INSERT INTO " + tableName + "  (user_id, book_id, text) VALUES "
                + " (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, comment.getUser_id());
            preparedStatement.setInt(2, comment.getBook_id());
            preparedStatement.setString(3, comment.getText());
            System.out.println(preparedStatement);
            dbConnection.insertData(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
