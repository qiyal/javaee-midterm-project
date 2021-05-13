package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.db.dao.CommentDao;
import iitu.javaee.javaee_endterm.model.Comment;
import iitu.javaee.javaee_endterm.model.CommentDTO;
import iitu.javaee.javaee_endterm.model.User;

import java.util.ArrayList;
import java.util.List;

public class CommentDTOService {
    private UserService userService;
    private CommentDao commentDao;

    public CommentDTOService() {
        this.userService = new UserService();
        this.commentDao = new CommentDao();
    }

    public List<CommentDTO> getCommentsByBookId(Integer bookId) {
        List<CommentDTO> res = new ArrayList<>();
        List<Comment> comments = commentDao.getCommentsByBookId(bookId);
        for(Comment comment : comments) {
            User user = userService.getUserById(comment.getUser_id());
            res.add(new CommentDTO(comment, user.getUsername(), user.getImageUrl()));
        }
        return res;
    }
}
