package iitu.javaee.javaee_endterm.db.dao;

import iitu.javaee.javaee_endterm.db.DBConnection;
import iitu.javaee.javaee_endterm.db.DBData;
import iitu.javaee.javaee_endterm.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private DBConnection dbConnection;
    private String tableName;

    public BookDao() {
        this.dbConnection = new DBConnection(DBData.URL, DBData.USERNAME, DBData.PASSWORD);
        this.tableName = "book";
    }

    public Book getBookObject(Integer bookId, String name, Integer cost, String urlImage) {
        Book book = new Book();
        book.setId(bookId);
        book.setName(name);
        book.setCost(cost);
        book.setUrlImage(urlImage);
        return book;
    }

    public List<Book> getAllBook() {
        dbConnection.openConnect();
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            while (resultSet.next()) {
                Integer bookId = resultSet.getInt("book_id");
                String name = resultSet.getString("name");
                Integer cost = resultSet.getInt("cost");
                String urlImage = resultSet.getString("url_image");
                books.add(getBookObject(bookId, name, cost, urlImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book getBookById(Integer id) {
        dbConnection.openConnect();
        Book book = null;

        String sql = "SELECT * FROM " + tableName + " WHERE book_id = " + id;
        ResultSet resultSet = dbConnection.getData(sql);
        try {
            resultSet.next();
            Integer bookId = resultSet.getInt("book_id");
            String name = resultSet.getString("name");
            Integer cost = resultSet.getInt("cost");
            String urlImage = resultSet.getString("url_image");
            book = getBookObject(bookId, name, cost, urlImage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
}
