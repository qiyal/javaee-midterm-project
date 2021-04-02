<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="kz.iitu.javaee.models.Book" %>
<jsp:useBean id="bookDao" scope="session" class="kz.iitu.javaee.dao.BookDao" />

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Cart Page</title>
</head>
<body>

<%
    Cookie [] cookies = request.getCookies();
    Cookie cartCookie = null;

    for (Cookie cookie1 : cookies) {
        if (cookie1.getName().equals("cart")) {
            cartCookie = cookie1;
            break;
        }
    }

    String s = "";

    if (cartCookie != null) {

        for(String strId : cartCookie.getValue().split("-")) {
            Book b = bookDao.selectBook(Integer.parseInt(strId));

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
    }
%>

    <%@ include file="header.jsp"%>


<div class="div_main">

    <h1 class="title">My Cart</h1>

    <%
        if (cartCookie == null) {
    %>
            <p>Your cart is empty!</p>
    <%
        } else {
    %>
            <div class="ul-flex">
                <%= s %>
            </div>
    <%
        }
    %>

</div>

    <%@ include file="footer.jsp"%>

</body>
</html>
