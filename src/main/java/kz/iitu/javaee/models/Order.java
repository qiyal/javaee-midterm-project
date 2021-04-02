package kz.iitu.javaee.models;

import java.util.Date;

public class Order {
    private Integer id;
    private Double cost;
    private Date orderDay;
    private Integer userId;

    public Order() {}

    public Order(Integer id, Double cost, Date orderDay, Integer userId) {
        this.id = id;
        this.cost = cost;
        this.orderDay = orderDay;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
