package iitu.javaee.javaee_endterm.db.dao;

import iitu.javaee.javaee_endterm.db.DBConnection;
import iitu.javaee.javaee_endterm.db.DBData;
import iitu.javaee.javaee_endterm.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private DBConnection dbConnection;
    private String tableName;

    public OrderDao() {
        this.dbConnection = new DBConnection(DBData.URL, DBData.USERNAME, DBData.PASSWORD);
        this.tableName = "order";
    }

    public Order getOrderObject(Integer orderId, Integer userId, Double cost, Date orderDay) {
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(userId);
        order.setCost(cost);
        order.setOrderDay(orderDay);
        return order;
    }

    public void createOrder(Order order) {
        dbConnection.openConnect();
        String INSERT_USERS_SQL = "INSERT INTO javaee2." + tableName + " (order_id, user_id, cost, order_day) VALUES "
                + " (?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, order.getUserId());
            preparedStatement.setDouble(3, order.getCost());
            preparedStatement.setDate(4, order.getOrderDay());
            System.out.println(preparedStatement);
            dbConnection.insertData(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        dbConnection.openConnect();
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        ResultSet resultSet = dbConnection.getData(sql);
        try {
            while (resultSet.next()) {
                Integer orderId = resultSet.getInt("order_id");
                Integer userId = resultSet.getInt("user_id");
                Double cost = resultSet.getDouble("cost");
                Date orderDay = resultSet.getDate("order_day");
                orders.add(getOrderObject(orderId, userId, cost, orderDay));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> getOrdersByUserId(String userId) {
        dbConnection.openConnect();
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM javaee2."+ tableName +" WHERE user_id = " + userId;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            while (resultSet.next()) {
                Integer orderId = resultSet.getInt("order_id");
                Integer userId_ = resultSet.getInt("user_id");
                Double cost = resultSet.getDouble("cost");
                Date orderDay = resultSet.getDate("order_day");
                orders.add(getOrderObject(orderId, userId_, cost, orderDay));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
