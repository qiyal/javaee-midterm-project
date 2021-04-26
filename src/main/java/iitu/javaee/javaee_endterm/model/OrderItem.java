package iitu.javaee.javaee_endterm.model;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Integer id;
    private Integer bookId;
    private Integer orderId;

    // constructor
    public OrderItem() {}

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
