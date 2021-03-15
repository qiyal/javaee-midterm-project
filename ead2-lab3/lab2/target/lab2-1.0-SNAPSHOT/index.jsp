<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="kz.iitu.javaee.models.Book" %>
<%@ page import="kz.iitu.javaee.dao.BookDao" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Main Page</title>
</head>
<body>



    <header>
        <nav class="ul-flex">
            <div>
                <a class="header-link" href="registration">Registration Page</a>
                <a class="header-link" href="login">Login Page</a>
            </div>
            <div>
                <a class="header-link" href="logoutServlet">Logout</a>
            </div>
        </nav>
    </header>

        <div class="flex-box">
            <%
                BookDao bookDao = new BookDao();
                ArrayList<Book> books = (ArrayList<Book>) bookDao.selectAllBooks();

                String res = "";
                for (Book book : books) {
                    StringBuilder code = new StringBuilder();
                    code.append("<div class=\"card\">\n");
                    code.append("    <div class=\"cart-img\">\n");
                    code.append("        <img src=\"" + book.getUrlImage() + "\" alt=\"book image\">\n");
                    code.append("    </div>\n");
                    code.append("    <div class=\"cart-info\">\n");
                    code.append("        <span class=\"cart-item-name\">" + book.getName() + "</span>\n");
                    code.append("        <span class=\"price\">Price: " + book.getCost() + "</span>\n");
                    code.append("    </div>\n");
                    code.append("</div>\n");
                    res += code + "\n";
                }
                out.println(res);
            %>
        </div>
</body>
</html>
