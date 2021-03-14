package kz.iitu.javaee.models;

import java.sql.Connection;

public class DBConnection {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public DBConnection() {
        this.url = "jdbc:mysql://localhost:3306/javaspring?serverTimezone=UTC";
        this.username="mysqlUsernamePassword";
        this.password=
    }


}
