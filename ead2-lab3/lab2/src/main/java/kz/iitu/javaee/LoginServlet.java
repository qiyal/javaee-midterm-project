package kz.iitu.javaee;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String status = "false";

        if (username.equals("pazyl") && password.equals("qwerty")) {
            req.setAttribute("status", "true");
            session.setAttribute("IS_AUTH", "1");
            String path = req.getContextPath() + "/main";
            resp.sendRedirect(path);
        } else {
            req.setAttribute("status", "false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
