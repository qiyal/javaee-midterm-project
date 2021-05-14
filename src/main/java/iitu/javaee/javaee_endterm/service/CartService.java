package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.model.Book;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CartService {

    public String addBookToCookie(HttpServletRequest req) {
        String id = req.getParameter("book_id");
        Cookie[] cookie = req.getCookies();

        String s = "";
        boolean initCookie = false;

        for (Cookie cookie1 : cookie) {
            if (cookie1.getName().equals("cart")) {
                if (cookie1.getValue() == null || cookie1.getValue().equals("")) {
                    s = id;
                    initCookie = true;
                } else {
                    s += cookie1.getValue() + "-" + id;
                    initCookie = true;
                }
                break;
            }
        }

        if (!initCookie) {
            s = id;
        }

        return s;
    }

    public String getCartCookieString(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public double getCartCost(List<Book> books) {
        double cost = 0;
        for (Book book : books) {
            cost += book.getCost();
        }
        return cost;
    }

    public String deleteCartItemByBookId(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        Cookie cartItems = null;
        String res = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                cartItems = cookie;
                break;
            }
        }

        int k = 0;
        for (String cartItemsSrt : cartItems.getValue().split("-")) {
            if (k == 0 && cartItemsSrt.equals(req.getParameter("book_id"))) {
                k++;
                continue;
            }
            res = res.equals("") ? cartItemsSrt : res + "-" + cartItemsSrt;
        }
        return res;
    }
}
