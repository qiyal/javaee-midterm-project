<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="kz.iitu.javaee.models.Book" %>
<jsp:useBean id="bookDao" scope="session" class="kz.iitu.javaee.dao.BookDao" />

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Book Detail Page</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Book b = bookDao.selectBook(Integer.parseInt(id));


    String str = "<div class=\"book_card\">\n" +
            "                <div class=\"book_img\">\n" +
            "                    <img class=\"image_book\" src=\"" + b.getUrlImage() + "\" alt=\"Book image\">\n" +
            "                </div>\n" +
            "                <div>\n" +
            "                    <p>Name: " + b.getName() + "</p>\n" +
            "                    <p>Price: " + b.getCost() + "</p>\n" +
            "                </div>\n" +
            "            </div>";
%>

<%--  inlude header.jsp  --%>
    <%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Book Detail</h1>

    <div class="ul-flex">
        <%= str %>
    </div>

    <div>
        <form action="book" method="post">
            <%= "<input type=\"hidden\" name=\"book_id\" value=\"" + id + "\">" %>
            <button type="submit">Add to cart</button>
        </form>
    </div>

</div>

<%--  inlude footer.jsp  --%>
    <%@ include file="footer.jsp"%>

</body>
</html>
