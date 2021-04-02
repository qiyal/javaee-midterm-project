<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="kz.iitu.javaee.models.User" %>
<jsp:useBean id="userDao" scope="session" class="kz.iitu.javaee.dao.UserDao"/>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Profile Page</title>
</head>
<body>
<%
    String login = (String) session.getAttribute("IS_AUTH");
    User user = userDao.selectUser(login);
%>

<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Profile</h1>

    <div class="user-avatar">
        <%
            out.println("<img src=\"" + user.getImageUrl() + "\" alt=\"User avatar image\">");
        %>
    </div>

    <p><span>Login:</span> <%= user.getUsername() %></p>

</div>

<%@ include file="footer.jsp"%>

</body>
</html>
