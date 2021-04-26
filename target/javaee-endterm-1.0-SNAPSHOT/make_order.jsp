<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="iitu.javaee.javaee_endterm.model.Book" %>
<jsp:useBean id="cartService" scope="session" class="iitu.javaee.javaee_endterm.service.CartService" />
<jsp:useBean id="bookservice" scope="session" class="iitu.javaee.javaee_endterm.service.BookService" />

<%
    List<Book> books = bookservice.getBookFromCookies(cartService.getCartCookieString(request.getCookies()));
    Double cost = cartService.getCartCost(books);
    String items = "";
    for (Book book : books) {
        items += "<div class=\"order-item-body\">\n" +
                "                    <div class=\"order-item-img\">\n" +
                "                        <img src=\"" + book.getUrlImage() + "\" alt=\"Book Image\">\n" +
                "                    </div>\n" +
                "                    <div class=\"order-item-info\">\n" +
                "                        <div>Name: " + book.getName() + "</div>\n" +
                "                        <div>Cost: " + book.getCost() + "</div>\n" +
                "                    </div>\n" +
                "                </div>";
    }
%>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500&display=swap" rel="stylesheet">
    <title>Make Order Page</title>
</head>
<body>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Make Order</h1>

    <div class="make-order-box">
        <div class="make-order-body">
            <div class="make-order-cost">Cost: <span><%= cost %></span></div>

            <div style="text-align: center; font-size: 22px; line-height: 18px; font-weight: bold">Items</div>

            <div class="order-items">

                <%= items %>

            </div>
        </div>
        
        <div class="btn-make-div">
            <form class="btn-form-make-order" action="make-order" method="post">
                <%= "<input type=\"hidden\" name=\"username\" value=\"" + session.getAttribute("IS_AUTH") + "\">" %>
                <button type="submit">MAKE AN ORDER</button>
            </form>
        </div>
    </div>

</div>

<%--  inlude footer.jsp  --%>
<%@ include file="footer.jsp"%>

</body>
</html>
