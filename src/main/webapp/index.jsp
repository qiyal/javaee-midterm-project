<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="kz.iitu.javaee.models.Book" %>
<jsp:useBean id="bookDao" scope="session" class="kz.iitu.javaee.dao.BookDao" />

<%
    List<Book> books = bookDao.selectAllBooks();
    String s = "";
%>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Main Page</title>
</head>
<body>
    <%
        for(Book b : books) {
            String str = "<div class=\"book_card\">\n" +
                    "                <div class=\"book_img\">\n" +
                    "                    <img class=\"image_book\" src=\"" + b.getUrlImage() + "\" alt=\"Book image\">\n" +
                    "                </div>\n" +
                    "                <div>\n" +
                    "                    <p>Name: " + b.getName() + "</p>\n" +
                    "                    <p>Price: " + b.getCost() + "</p>\n" +
                    "                    <a href=\"book?id=" +b.getId()+ "\">Show detail</a>" +
                    "                </div>\n" +
                    "            </div>";
            s += str + "\n";
        }
    %>

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
