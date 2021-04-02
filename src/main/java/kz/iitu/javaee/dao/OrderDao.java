package kz.iitu.javaee.dao;

import kz.iitu.javaee.models.Order;
import kz.iitu.javaee.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {
    private String url;
    private String username;
    private String password;

    public OrderDao() {
        this.url = "jdbc:mysql://localhost:3306/spring?serverTimezone=UTC";
        this.username="root";
        this.password="nur26erb";
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet getData(String sql) {
        ResultSet resultSet = null;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sqlEx) {
            System.out.println("SQL query failed!");
            System.out.println(sqlEx);
        }
        return resultSet;
    }

    public void updateData(String sql) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlEx) {
            System.out.println("Date update failed!");
            System.out.println(sqlEx);
        }
    }

    public void createOrder(Order order) {
        String INSERT_USERS_SQL = "INSERT INTO order" + "  (cost, order_day, user_id) VALUES "
                + " (?, ?, ?);";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, order.getCost().toString());
            preparedStatement.setString(2, order.getOrderDay().toString());
            preparedStatement.setString(3, order.getUserId().toString());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAllOrder() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("login");
                String password = resultSet.getString("password");
                users.add(new User(id, name, password));
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Order> selectOrdersByUserId(String id) {
        List<Order> orders = new ArrayList<Order>();
        String sql = "SELECT * FROM `order` WHERE user_id = " + id;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id_order = resultSet.getInt("id");
                Double cost = resultSet.getDouble("cost");
                Date orderDay = resultSet.getDate("order_day");
                Integer user_id = resultSet.getInt("user_id");
                orders.add(new Order(id_order, cost, orderDay, user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
