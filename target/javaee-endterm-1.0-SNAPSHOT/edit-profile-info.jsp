<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="iitu.javaee.javaee_endterm.model.User"/>
<jsp:useBean id="userService" class="iitu.javaee.javaee_endterm.service.UserService"/>
<%
    user = userService.getUserByUsername((String) session.getAttribute("IS_AUTH"));
%>
<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Edit Profile InfoPage</title>
</head>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<body>
    <h1 class="title">Edit Profile Info</h1>

    <div class="div-edit-profile-info-page">

        <div class="user-edit-info">
            <h2>User Info</h2>

            <div class="form-edit-form">
                <form action="edit-profile-info" method="post">
                    <div>
                        <input type="hidden" name="user_id" value="<%= user.getId() %>">

                        <div class="label-div">
                            <label for="name">Name: </label>
                            <input id="name" type="text" name="name" value="<%= user.getName()%>">
                        </div>

                        <div class="label-div">
                            <label for="username">Username: </label>
                            <input id="username" type="text" name="username" value="<%= user.getUsername()%>">
                        </div>

                        <div class="label-div">
                            <label for="password">Password: </label>
                            <input id="password" type="password" name="password">
                        </div>

                       <div class="label-div">
                           <label for="password2">Password: </label>
                           <input id="password2" type="password" name="password2">
                       </div>
                    </div>
                        <button type="submit">SAVE</button>
                </form>
            </div>
        </div>
        <div>
            <a href="profile" class="back-to-btn">BACK TO</a>
        </div>
    </div>

    <%@ include file="footer.jsp"%>
</body>
</html>
