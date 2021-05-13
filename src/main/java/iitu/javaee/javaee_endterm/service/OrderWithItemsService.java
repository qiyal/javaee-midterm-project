package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.db.dao.OrderItemDao;
import iitu.javaee.javaee_endterm.model.Order;
import iitu.javaee.javaee_endterm.model.OrderItem;
import iitu.javaee.javaee_endterm.model.OrderWithItems;

import java.util.ArrayList;
import java.util.List;

public class OrderWithItemsService {
    private OrderService orderService;
    private OrderItemService orderItemService;

    public OrderWithItemsService() {
        this.orderService = new OrderService();
        this.orderItemService = new OrderItemService();
    }

    public List<OrderWithItems> getOrderWithItemsByUserId(Integer userId) {
        List<OrderWithItems> orderWithItemsList = new ArrayList<>();
        List<Order> orders = orderService.getOrdersByUserId(Integer.toString(userId));

        for (Order order : orders) {
            orderWithItemsList.add(getModelOrderWithItems(order, orderItemService.orderItemList(Integer.toString(order.getId()))));
        }

        return orderWithItemsList;
    }

    private OrderWithItems getModelOrderWithItems(Order order, List<OrderItem> orderItems) {
        OrderWithItems orderWithItems = new OrderWithItems();
        orderWithItems.setOrder(order);
        orderWithItems.setOrderItemList(orderItems);
        return orderWithItems;
    }
}
