package iitu.javaee.javaee_endterm.servlet;

import iitu.javaee.javaee_endterm.db.dao.CommentDao;
import iitu.javaee.javaee_endterm.model.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddComment extends HttpServlet {
    private CommentDao commentDao;

    @Override
    public void init() throws ServletException {
        commentDao = new CommentDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Comment comment = new Comment();
        comment.setText(req.getParameter("text"));
        comment.setUser_id(Integer.parseInt(req.getParameter("user_id")));
        comment.setBook_id(Integer.parseInt(req.getParameter("book_id")));

        commentDao.createComment(comment);

        String path = req.getContextPath() + "/book?id=" + req.getParameter("book_id");
        resp.sendRedirect(path);
    }
}
