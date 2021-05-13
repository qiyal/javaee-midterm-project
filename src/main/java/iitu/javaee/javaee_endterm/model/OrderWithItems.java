package iitu.javaee.javaee_endterm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderWithItems implements Serializable {
    private Order order = null;
    private List<OrderItem> orderItemList = new ArrayList<>();

    public OrderWithItems() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
