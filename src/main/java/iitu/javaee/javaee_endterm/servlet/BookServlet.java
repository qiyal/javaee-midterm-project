package iitu.javaee.javaee_endterm.servlet;

import iitu.javaee.javaee_endterm.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    private CartService cartService;

    public void init() {
        cartService = new CartService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("book_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = cartService.addBookToCookie(req);

        System.out.println("Cooke: " + s);
        resp.addCookie(new Cookie("cart", s));

        String path = req.getContextPath() + "/book?id=" + req.getParameter("book_id");
        resp.sendRedirect(path);
    }
}
