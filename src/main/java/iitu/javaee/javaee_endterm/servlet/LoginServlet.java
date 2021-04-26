package iitu.javaee.javaee_endterm.servlet;

import iitu.javaee.javaee_endterm.db.dao.UserDao;
import iitu.javaee.javaee_endterm.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String path = req.getContextPath() + "/login?error=NOT_CORRECT_DATA";

        if (userService.checkUserByUsernameAndPassword(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("IS_AUTH", username);
            path = req.getContextPath() + "/";
        }

        resp.sendRedirect(path);
    }
}
