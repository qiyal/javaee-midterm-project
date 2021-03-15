package kz.iitu.javaee.dao;

import kz.iitu.javaee.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private String url = "jdbc:mysql://localhost:3306/spring?useSSL=false";;
    private String username = "root";
    private String password = "mysqlUsernamePassword";

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

    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<Book>();
        String sql = "SELECT * FROM book";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer book_id = resultSet.getInt("book_id");
                String name = resultSet.getString("name");
                Integer cost = resultSet.getInt("cost");
                String urlImage = resultSet.getString("urlImage");
                books.add(new Book(book_id, name, cost, urlImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
