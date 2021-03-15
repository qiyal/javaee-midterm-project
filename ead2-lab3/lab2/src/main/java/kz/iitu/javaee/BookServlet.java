package kz.iitu.javaee;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("book_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = req.getParameter("book_id");
        Cookie[] cookie = req.getCookies();

        String s = "";
        for (Cookie cookie1 : cookie) {
            if (cookie1.getName().equals("cart")) {
                if (cookie1.getValue() == null || cookie1.getValue().equals("")) {
                    s = id;
                } else {
                    s += cookie1.getValue() + "-" + id;
                }
                break;
            }
        }
        System.out.println("Cooke: " + s);
        resp.addCookie(new Cookie("cart", s));
        String path = req.getContextPath() + "/book?id=" + id;
        resp.sendRedirect(path);
    }
}
