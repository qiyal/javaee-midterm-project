<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<jsp:useBean id="userService" scope="session" class="iitu.javaee.javaee_endterm.service.UserService"/>
<jsp:useBean id="user" scope="session" class="iitu.javaee.javaee_endterm.model.User"/>
<%
    user = userService.getUserByUsername((String) session.getAttribute("IS_AUTH"));
%>
<jsp:setProperty name="user" property="username" value="<%= user.getUsername() %>"/>
<jsp:setProperty name="user" property="name" value="<%= user.getName() %>"/>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <link href="./styles/animate.css" rel="stylesheet" type="text/css">
    <title>Profile Page</title>
</head>
<body>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Profile</h1>

    <div class="user-avatar">
        <div class="avatar-img-box">
            <img class="profile-img" src="<%= user.getImageUrl() %>" alt="Image Profile">
        </div>
        <div class="profile-info">
            <h2>User Info</h2>
            <div>Username: <span><jsp:getProperty name="user" property="username"/></span></div>
            <div>Name: <span><jsp:getProperty name="user" property="name"/></span></div>
            <a href="edit-profile-info" class="edit-btn">Edit</a>
        </div>
    </div>

    <jsp:include page="orders.jsp">
        <jsp:param name="user_id_for_get_orders" value="<%= user.getId() %>"/>
    </jsp:include>

</div>

<%@ include file="footer.jsp"%>

    <script src="js/main.js"></script>
</body>
</html>
