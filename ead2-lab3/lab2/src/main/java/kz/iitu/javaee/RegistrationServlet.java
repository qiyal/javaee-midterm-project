package kz.iitu.javaee;

import kz.iitu.javaee.dao.UserDao;
import kz.iitu.javaee.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String status = "registration";

        req.setAttribute("username", username);
        req.setAttribute("password", password);
        req.setAttribute("status", status);

        if (!userDao.checkLogin(username)) {
            userDao.createUser(new User(username, password));
            req.setAttribute("status", "true");
            session.setAttribute("IS_AUTH", username);
            String path = req.getContextPath() + "/main";
            resp.sendRedirect(path);
        } else {
            req.setAttribute("status", "false");
            RequestDispatcher view = req.getRequestDispatcher("registration.jsp");
            view.forward(req, resp);
        }



    }
}
