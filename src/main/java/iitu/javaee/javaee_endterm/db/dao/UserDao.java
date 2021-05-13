package iitu.javaee.javaee_endterm.db.dao;

import iitu.javaee.javaee_endterm.db.DBConnection;
import iitu.javaee.javaee_endterm.db.DBData;
import iitu.javaee.javaee_endterm.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private DBConnection dbConnection;
    private String tableName;

    public UserDao() {
        this.dbConnection = new DBConnection(DBData.URL, DBData.USERNAME, DBData.PASSWORD);
        this.tableName = "user";
    }

    private User getUserObject(Integer userId, String username, String password, String name, String urlImage) {
        User user = new User();
        user.setId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setImageUrl(urlImage);
        return user;
    }

    public void createUser(User user) {
        dbConnection.openConnect();
        String INSERT_USERS_SQL = "INSERT INTO " + tableName + "  (username, password) VALUES "
                + " (?, ?);";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            dbConnection.insertData(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAllUser() {
        dbConnection.openConnect();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            while (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String imageUrl = resultSet.getString("url_image");
                users.add(getUserObject(userId, username, password, name, imageUrl));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserByUsername(String username) {
        dbConnection.openConnect();
        User user = null;
        String sql = "SELECT * FROM " + tableName + " WHERE username = \'" + username + "\'";
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            resultSet.next();
            Integer userId = resultSet.getInt("user_id");
            String username_ = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String urlImage = resultSet.getString("url_image");
            user = getUserObject(userId, username_, password, name, urlImage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        dbConnection.openConnect();
        User user = null;
        String sql = "SELECT * FROM "+ tableName +" WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            resultSet.next();
            Integer userId = resultSet.getInt("user_id");
            String name = resultSet.getString("name");
            String urlImage = resultSet.getString("url_image");

            user = getUserObject(userId, username, password, name, urlImage);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("GET USER By Username and Password error!");
        }

        return user;
    }

    public User getUserByUsernameAndIsNotEqualId(String username, String user_id) {
        dbConnection.openConnect();
        User user = null;
        String sql = "SELECT * FROM " + tableName + " WHERE username = \'" + username + "\' AND user_id != " + user_id;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            if (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");
                String username_ = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String urlImage = resultSet.getString("url_image");
                user = getUserObject(userId, username_, password, name, urlImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        dbConnection.openConnect();
        String sql = "UPDATE "+ tableName + " SET username = \'" + user.getUsername() + "\', password = \'" + user.getPassword() + "\', name = \'" + user.getName() + "\' WHERE user_id = " + user.getId();
        dbConnection.updateData(sql);
    }

    public User getUserById(Integer userId) {
        dbConnection.openConnect();
        User user = null;
        String sql = "SELECT * FROM " + tableName + " WHERE user_id = " + userId;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            resultSet.next();
            Integer userId_ = resultSet.getInt("user_id");
            String username_ = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String urlImage = resultSet.getString("url_image");
            user = getUserObject(userId_, username_, password, name, urlImage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
