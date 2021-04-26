package iitu.javaee.javaee_endterm.model;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
    private Integer id;
    private Integer userId;
    private Double cost;
    private Date orderDay;

    // constrictor
    public Order() {}

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Date orderDay) {
        this.orderDay = orderDay;
    }
}
