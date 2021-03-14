<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Login Page</title>
</head>
<body>

<header>
    <nav class="ul-flex">
        <a href="registration">Registration Page</a>
    </nav>
</header>

<div class="form-box">
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">

        <br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">

        <button type="submit">Log in</button>
    </form>
</div>

<%
    if ((String)request.getAttribute("status") != null && ((String)request.getAttribute("status")).equals("false")) {
        out.println("<p class=error>Username or password is not correct!</p>");
    }
%>


</body>
</html>
