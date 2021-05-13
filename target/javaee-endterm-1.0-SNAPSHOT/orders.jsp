<%@ page import="java.util.List" %>
<%@ page import="iitu.javaee.javaee_endterm.model.OrderWithItems" %>
<%@ page import="iitu.javaee.javaee_endterm.model.Book" %>
<jsp:useBean id="orderService" scope="session" class="iitu.javaee.javaee_endterm.service.OrderService"/>
<jsp:useBean id="orderWithItemsService" scope="session" class="iitu.javaee.javaee_endterm.service.OrderWithItemsService"/>

<%
    String ordersStr = "";
    String user_id;
    List<OrderWithItems> orderWithItemsList;
    String s = "";
%>

<%
    user_id = request.getParameter("user_id_for_get_orders");
    orderWithItemsList = orderWithItemsService.getOrderWithItemsByUserId(Integer.parseInt(user_id));

    if (orderWithItemsList.size() != 0) {
        for (OrderWithItems orderWithItems : orderWithItemsList) {
            String items = "";
            for (Book book : orderWithItems.getBookList()) {
                items += "<div class=\"order-item\">\n" +
                        "<div class=\"order-item-name\">\n" +
                        book.getName() +
                        "</div>\n" +
                        "<div class=\"order-item-cost\">\n" +
                        book.getCost() + " KZT" +
                        "</div>\n" +
                        "</div>";
            }

            s += "<div class=\"order-flex-box\">\n" +
                    "<div class=\"order-card\">\n" +
                    "<div class=\"order-date\">\n" +
                    "Date: <span>" + orderWithItems.getOrder().getOrderDay() + "</span>\n" +
                    "</div>\n" +
                    "<div class=\"order-items-list\">\n" +
                                    items +
                    "</div>\n" +
                    "<div class=\"order-body\">\n" +
                    "Total Cost: <span>" + orderWithItems.getOrder().getCost() + " KZT</span>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>";
            ordersStr += s;
        }
    }
%>

<div>
    <h2 class="mg-l-100 mg-t-100">My Orders</h2>
<%--    <div class="order-flex-box">--%>
<%--        <div class="order-card">--%>
<%--            <div class="order-date">--%>
<%--                Date: <span>2015-01-20</span>--%>
<%--            </div>--%>
<%--            <div class="order-items-list">--%>
<%--                --%>
<%--            </div>--%>
<%--            <div class="order-body">--%>
<%--                Total Cost: <span>10000 KZT</span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <%
        if (orderWithItemsList.size() != 0) {
    %>
    <div class="ul-flex-v2">
        <%= ordersStr %>
    </div>
    <%
        } else {
    %>
        <p class="cart-info-text">Your list of orders is empty!</p>
    <% } %>
</div>





