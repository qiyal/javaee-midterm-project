<header class="header">
    <nav class="header-nav">
        <div>
            <a class="header-link" href="main">Home</a>
            <a class="header-link" href="profile">Profile</a>
            <a class="header-link" href="cart">Cart</a>
        </div>
        <div>
            <%
                if (session.getAttribute("IS_AUTH") != null) {
            %>
                <a class="header-link" href="logoutServlet">Logout</a>
            <%  } else { %>
                <a class="header-link" href="login">Login</a>
            <%
                }
            %>
        </div>
    </nav>
</header>
