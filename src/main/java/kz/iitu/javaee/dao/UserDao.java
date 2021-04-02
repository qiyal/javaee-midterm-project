package kz.iitu.javaee.dao;

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

    public void createUser(User user) {
        String INSERT_USERS_SQL = "INSERT INTO user" + "  (login, password) VALUES "
                + " (?, ?);";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User selectUser(String login) {
        User user = null;
        String sql = "SELECT * FROM user WHERE login = \'" + login + "\'";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("login");
                String password = resultSet.getString("password");
                String url = resultSet.getString("image_url");
                user = new User(id, name, password, url);
                System.out.println(name);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean checkLogin(String login) {
        String sql = "SELECT * FROM user WHERE login = '" + login + "'";
        boolean ans = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("login");
                if (name.equals(login)) {
                    ans = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public boolean checkUser(String login, String password) {
        String sql = "SELECT * FROM user WHERE login = '" + login + "' AND password = '" + password + "'";
        boolean ans = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("login");
                String password1 = resultSet.getString("password");
                if (name.equals(login) && password1.equals(password)) {
                    ans = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
