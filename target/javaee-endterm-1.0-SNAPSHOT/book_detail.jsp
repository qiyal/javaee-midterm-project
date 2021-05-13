<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="iitu.javaee.javaee_endterm.model.Book" %>
<jsp:useBean id="bookService" scope="session" class="iitu.javaee.javaee_endterm.service.BookService" />

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500&display=swap" rel="stylesheet">
    <title>Book Detail Page</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Book b = bookService.getBookById(Integer.parseInt(id));


    String str = "<div class=\"book_card\">\n" +
            "                <div class=\"book_img\">\n" +
            "                    <img class=\"image_book\" src=\"" + b.getUrlImage() + "\" alt=\"Book image\">\n" +
            "                </div>\n" +
            "                <div class=\"\">\n" +
            "                    <p class=\"book-p\">Name: <span>" + b.getName() + "</span></p>\n" +
            "                    <p class=\"book-p\">Price: <span>" + b.getCost() + "</span></p>\n" +
            "                    <div class=\"div-action\">\n" +
            "                       <form class=\"btn-add-to-cart-form\" action=\"book\" method=\"post\">\n" +
            "                           <input type=\"hidden\" name=\"book_id\" value=\"" + id + "\">\n" +
            "                           <button class=\"btn-add-to-cart\" type=\"submit\">Add to cart</button>\n" +
            "                       </form>\n" +
            "                    </div>" +
            "                </div>\n" +
            "            </div>";
%>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Book Detail</h1>

    <div class="book-detail-div">
        <%= str %>
    </div>

</div>

<%--  inlude footer.jsp  --%>
<%@ include file="footer.jsp"%>

</body>
</html>
