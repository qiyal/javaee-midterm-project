package iitu.javaee.javaee_endterm.servlet;

import iitu.javaee.javaee_endterm.model.Book;
import iitu.javaee.javaee_endterm.model.Index;
import iitu.javaee.javaee_endterm.model.Order;
import iitu.javaee.javaee_endterm.model.OrderItem;
import iitu.javaee.javaee_endterm.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class MakeOrderServlet extends HttpServlet {
    private CartService cartService;
    private OrderService orderService;
    private UserService userService;
    private BookService bookService;
    private OrderItemService orderItemService;

    @Override
    public void init() throws ServletException {
        cartService = new CartService();
        orderService = new OrderService();
        userService = new UserService();
        bookService = new BookService();
        orderItemService = new OrderItemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("make_order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.getBookFromCookies(cartService.getCartCookieString(req.getCookies()));
        Double cost = cartService.getCartCost(books);

        Order order = new Order();
        order.setId(Index.orderId++);
        order.setUserId(userService.getUserByUsername(req.getParameter("username")).getId());
        order.setCost(cost);
        order.setOrderDay(new Date(new java.util.Date().getTime()));
        System.out.println(order);
        orderService.createOrder(order);

        for (Book book : books) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(Index.orderId - 1);
            orderItem.setBookId(book.getId());
            orderItemService.createOrderItems(orderItem);
        }

        resp.addCookie(new Cookie("cart", null));
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
