package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.db.dao.OrderDao;
import iitu.javaee.javaee_endterm.model.Order;

import java.util.List;

public class OrderService {
    public OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    public List<Order> getOrdersByUserId(String user_id) {
        return orderDao.getOrdersByUserId(user_id);
    }

    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }
}
