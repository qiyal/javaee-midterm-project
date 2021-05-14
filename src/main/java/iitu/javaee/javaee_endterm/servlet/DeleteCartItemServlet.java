package iitu.javaee.javaee_endterm.servlet;

import iitu.javaee.javaee_endterm.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCartItemServlet extends HttpServlet {
    private CartService cartService;

    @Override
    public void init() throws ServletException {
        cartService = new CartService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = cartService.deleteCartItemByBookId(req);

        System.out.println("REMOVE Cooke: " + s);
        resp.addCookie(new Cookie("cart", s));

        String path = req.getContextPath() + "/cart";
        resp.sendRedirect(path);
    }
}
