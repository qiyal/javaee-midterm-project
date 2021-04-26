package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.db.dao.OrderItemDao;
import iitu.javaee.javaee_endterm.model.OrderItem;

import java.util.List;

public class OrderItemService {
    private OrderItemDao orderItemDao;

    public OrderItemService() {
        orderItemDao = new OrderItemDao();
    }

    public void createOrderItems(OrderItem orderItems) {
        orderItemDao.createOrder(orderItems);
    }

    public List<OrderItem> orderItemList(String orderId) {
        return orderItemDao.getOrderItemsByOrderId(orderId);
    }
}
