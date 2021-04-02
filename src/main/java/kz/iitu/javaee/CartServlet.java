package kz.iitu.javaee;

import kz.iitu.javaee.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }
}
