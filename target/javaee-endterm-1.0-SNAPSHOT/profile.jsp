<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="iitu.javaee.javaee_endterm.model.User" %>
<jsp:useBean id="userService" scope="session" class="iitu.javaee.javaee_endterm.service.UserService"/>

<%
    String username = (String) session.getAttribute("IS_AUTH");
    User user = userService.getUserByUsername(username);
%>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Profile Page</title>
</head>
<body>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Profile</h1>

    <div class="user-avatar">
        <img src="<%= user.getImageUrl() %>" alt="Image Profile">
    </div>

    <p><span>Login:</span> <%= user.getUsername() %></p>

    <jsp:include page="orders.jsp">
        <jsp:param name="user_id_for_get_orders" value="<%= user.getId() %>"/>
    </jsp:include>

</div>

<%@ include file="footer.jsp"%>

</body>
</html>
