<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="iitu.javaee.javaee_endterm.model.Book" %>
<jsp:useBean id="bookService" scope="session" class="iitu.javaee.javaee_endterm.service.BookService"/>

<%
    List<Book> books = bookService.getAllBooks();
    String s = "";

    for(Book b : books) {
        String str = "<div class=\"book_card\">\n" +
                "                <div class=\"book_img\">\n" +
                "                    <img class=\"image_book\" src=\"" + b.getUrlImage() + "\" alt=\"Book image\">\n" +
                "                </div>\n" +
                "                <div class=\"\">\n" +
                "                    <p class=\"book-p\">Name: <span>" + b.getName() + "</span></p>\n" +
                "                    <p class=\"book-p\">Price: <span>" + b.getCost() + "</span></p>\n" +
                "                    <a class=\"book-link\" href=\"book?id=" +b.getId()+ "\">Show detail</a>" +
                "                </div>\n" +
                "            </div>";
        s += str + "\n";
    }
%>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500&display=swap" rel="stylesheet">
    <title>Main Page</title>
</head>
<body>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">
    <h1 class="title">Books</h1>
    <div class="ul-flex">
        <%= s %>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>