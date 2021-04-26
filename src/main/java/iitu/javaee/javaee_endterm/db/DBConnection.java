package iitu.javaee.javaee_endterm.db;

import java.sql.*;

public class DBConnection {
    private String url;
    private String username;
    private String password;
    private Connection connection;
    private boolean isConnect = false;

    // constructors
    public DBConnection() {}

    public DBConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        if (!isConnect) {
            openConnect();
        }
        return connection;
    }

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // methods
    public void openConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (!isConnect) {
                connection = DriverManager.getConnection(url, username, password);
                isConnect = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("DB Connection open false!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("DB Connection close false!");
        }
    }

    public ResultSet getData(String sql) {
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sqlEx) {
            System.out.println("SQL query failed!");
            System.out.println(sqlEx.getMessage());
        }
        return resultSet;
    }

    public void insertData(PreparedStatement preparedStatement) {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL insert query failed!");
        }
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
}
