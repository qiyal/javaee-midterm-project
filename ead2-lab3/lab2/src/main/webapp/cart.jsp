<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="kz.iitu.javaee.models.Book" %>
<%@ page import="kz.iitu.javaee.dao.BookDao" %>
<%@ page import="kz.iitu.javaee.dao.UserDao" %>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Main Page</title>
</head>
<body>
<%
    BookDao bookDao = new BookDao();
    List<Book> books = bookDao.selectAllBooks();
    String s = "";
    for(Book b : books) {
        String str = "<div class=\"book_card\">\n" +
                "                <div class=\"book_img\">\n" +
                "                    <img class=\"image_book\" src=\"" + b.getUrlImage() + "\" alt=\"Book image\">\n" +
                "                </div>\n" +
                "                <div>\n" +
                "                    <p>Name: " + b.getName() + "</p>\n" +
                "                    <p>Price: " + b.getCost() + "</p>\n" +
                "                </div>\n" +
                "            </div>";
        s += str + "\n";
    }
%>

<header>
    <nav class="ul-flex">
        <div>
            <a class="header-link" href="registration">Cart</a>
        </div>
        <div>
            <a class="header-link" href="logoutServlet">Logout</a>
        </div>
    </nav>
</header>

<div class="div_main">
    <h1 class="title">Books</h1>
    <div class="ul-flex">
        <%= s %>
    </div>
</div>
</body>
</html>
