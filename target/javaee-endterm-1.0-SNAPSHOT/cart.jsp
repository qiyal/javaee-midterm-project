<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="iitu.javaee.javaee_endterm.model.Book" %>
<jsp:useBean id="bookService" scope="session" class="iitu.javaee.javaee_endterm.service.BookService"/>
<jsp:useBean id="cartService" scope="session" class="iitu.javaee.javaee_endterm.service.CartService"/>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Cart Page</title>
</head>
<body>

<%
    String s = cartService.getCartCookieString(request.getCookies());
    String books = "";
    if (s != null && !s.equals("")) {

        for(String strId : s.split("-")) {
            Book b = bookService.getBookById(Integer.parseInt(strId));

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
            books += str + "\n";
        }
    }
%>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">My Cart</h1>

    <%
        if (s == null || s.equals("")) {
    %>
        <h1 style="text-align: center">Your cart is empty!</h1>
    <%
    } else {
    %>
    <div class="ul-flex">
        <%= books %>
    </div>

    <div style="text-align: center">
        <a class="make-order-btn" href="make-order">Make Order</a>
    </div>
    <%
        }
    %>

</div>

<%@ include file="footer.jsp"%>

</body>
</html>
