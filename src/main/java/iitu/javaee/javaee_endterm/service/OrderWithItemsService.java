package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.model.Book;
import iitu.javaee.javaee_endterm.model.Order;
import iitu.javaee.javaee_endterm.model.OrderItem;
import iitu.javaee.javaee_endterm.model.OrderWithItems;

import java.util.ArrayList;
import java.util.List;

public class OrderWithItemsService {
    private OrderService orderService;
    private OrderItemService orderItemService;
    private BookService bookService;

    public OrderWithItemsService() {
        this.orderService = new OrderService();
        this.orderItemService = new OrderItemService();
        this.bookService = new BookService();
    }

    public List<OrderWithItems> getOrderWithItemsByUserId(Integer userId) {
        List<OrderWithItems> orderWithItemsList = new ArrayList<>();
        List<Order> orders = orderService.getOrdersByUserId(Integer.toString(userId));

        for (Order order : orders) {
            List<OrderItem> orderItems = orderItemService.orderItemList(Integer.toString(order.getId()));
            List<Book> books = new ArrayList<>();

            System.out.println("order Id: " + order.getId());
            for (OrderItem orderItem : orderItems) {
                System.out.println("orderItem id: " + orderItem.getOrderId() + "\tBookId: " + orderItem.getBookId());
                books.add(bookService.getBookById(orderItem.getBookId()));
            }
            orderWithItemsList.add(getModelOrderWithItems(order, orderItems, books));
        }

        return orderWithItemsList;
    }

    private OrderWithItems getModelOrderWithItems(Order order, List<OrderItem> orderItems, List<Book> books) {
        OrderWithItems orderWithItems = new OrderWithItems();
        orderWithItems.setOrder(order);
        orderWithItems.setOrderItemList(orderItems);
        orderWithItems.setBookList(books);
        return orderWithItems;
    }
}
