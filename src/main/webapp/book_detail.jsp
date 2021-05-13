<%@ page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*" %>
<%@ page import="iitu.javaee.javaee_endterm.model.Book" %>
<%@ page import="iitu.javaee.javaee_endterm.model.User" %>
<%@ page import="iitu.javaee.javaee_endterm.model.CommentDTO" %>
<jsp:useBean id="bookService" scope="session" class="iitu.javaee.javaee_endterm.service.BookService" />
<jsp:useBean id="userService" scope="session" class="iitu.javaee.javaee_endterm.service.UserService"/>
<jsp:useBean id="commentDtoService" scope="session" class="iitu.javaee.javaee_endterm.service.CommentDTOService"/>

<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500&display=swap" rel="stylesheet">
    <title>Book Detail Page</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Book b = bookService.getBookById(Integer.parseInt(id));
    User user = userService.getUserByUsername((String) session.getAttribute("IS_AUTH"));
    String commentS = "";
    List<CommentDTO> comments = commentDtoService.getCommentsByBookId(b.getId());

    String str = "<div class=\"book_card\">\n" +
            "                <div class=\"book_img\">\n" +
            "                    <img class=\"image_book\" src=\"" + b.getUrlImage() + "\" alt=\"Book image\">\n" +
            "                </div>\n" +
            "                <div class=\"\">\n" +
            "                    <p class=\"book-p\">Name: <span>" + b.getName() + "</span></p>\n" +
            "                    <p class=\"book-p\">Price: <span>" + b.getCost() + "</span></p>\n" +
            "                    <div class=\"div-action\">\n" +
            "                       <form class=\"btn-add-to-cart-form\" action=\"book\" method=\"post\">\n" +
            "                           <input type=\"hidden\" name=\"book_id\" value=\"" + id + "\">\n" +
            "                           <button class=\"btn-add-to-cart\" type=\"submit\">Add to cart</button>\n" +
            "                       </form>\n" +
            "                    </div>" +
            "                </div>\n" +
            "            </div>";

    for(CommentDTO commentDTO : comments) {
        String sc = "        <div class=\"comment-card\">\n" +
                "            <div class=\"user\">\n" +
                "                <div class=\"user-img\">\n" +
                "                    <img src=\"" + commentDTO.getUserImg() + "\" alt=\"user img\">\n" +
                "                </div>\n" +
                "                <div class=\"user-name\">\n" +
                commentDTO.getUsername() +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"comment\">\n" +
                "                <p>" + commentDTO.getComment().getText() + "</p>\n" +
                "            </div>\n" +
                "        </div>";
        commentS += sc;
    }
%>

<%--  inlude header.jsp  --%>
<%@ include file="header.jsp"%>

<div class="div_main">

    <h1 class="title">Book Detail</h1>

    <div class="book-detail-div">
        <%= str %>
    </div>

    <h1 class="title">Comments</h1>

    <div class="comments-flex">

<%--        <div class="comment-card">--%>
<%--            <div class="user">--%>
<%--                <div class="user-img">--%>
<%--                    <img src="./images/user/user_img1.jpg" alt="user img">--%>
<%--                </div>--%>
<%--                <div class="user-name">--%>
<%--                    UserName--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="comment">--%>
<%--                <p>Text</p>--%>
<%--            </div>--%>
<%--        </div>--%>

        <%= commentS %>
    </div>

    <div style="display: flex; justify-content: center">
        <div class="user-edit-info">
            <h2>Add Comment</h2>

            <div class="form-edit-form">
                <form action="add-comment" method="post">
                    <div>
                        <input type="hidden" name="user_id" value="<%= user.getId() %>">
                        <input type="hidden" name="book_id" value="<%= id %>">

                        <div class="label-div">
                            <label for="text">Text: </label>
                            <textarea id="text" name="text" placeholder="Comment text"></textarea>
                        </div>
                    </div>
                    <button type="submit">SAVE</button>
                </form>
            </div>
        </div>
    </div>


</div>

<%--  inlude footer.jsp  --%>
<%@ include file="footer.jsp"%>

</body>
</html>
