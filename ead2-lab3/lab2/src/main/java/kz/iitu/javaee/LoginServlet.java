package kz.iitu.javaee;

import kz.iitu.javaee.dao.UserDao;
import kz.iitu.javaee.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String status = "false";

                if (userDao.checkUser(username, password)) {
                    req.setAttribute("status", "true");
                    session.setAttribute("IS_AUTH", username);
                    String path = req.getContextPath() + "/main";
                    resp.sendRedirect(path);
                } else {
                    req.setAttribute("status", "false");
                    RequestDispatcher view = req.getRequestDispatcher("login.jsp");
                    view.forward(req, resp);
                }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
