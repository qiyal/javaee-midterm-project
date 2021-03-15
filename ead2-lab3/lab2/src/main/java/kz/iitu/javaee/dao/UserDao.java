package kz.iitu.javaee.dao;

import kz.iitu.javaee.models.Book;
import kz.iitu.javaee.models.DBConnection;
import kz.iitu.javaee.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String url;
    private String username;
    private String password;

    public UserDao() {
        this.url = "jdbc:mysql://localhost:3306/spring?serverTimezone=UTC";
        this.username="root";
        this.password="mysqlUsernamePassword";
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

    public List<User> selectAllUser() {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
