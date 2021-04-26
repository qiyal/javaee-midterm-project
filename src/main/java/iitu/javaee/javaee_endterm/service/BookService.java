package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.db.dao.BookDao;
import iitu.javaee.javaee_endterm.model.Book;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookDao bookDao;

    public BookService() {
        this.bookDao = new BookDao();
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBook();
    }

    public Book getBookById(Integer bookId) {
        return bookDao.getBookById(bookId);
    }

    public List<Book> getBookFromCookies(String cookieStr) {
        String[] bookIds = cookieStr.split("-");
        ArrayList<Book> books = new ArrayList<>();

        for (String id : bookIds) {
            books.add(getBookById(Integer.parseInt(id)));
        }

        return books;
    }
}
