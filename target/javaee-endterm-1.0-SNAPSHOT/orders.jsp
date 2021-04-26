<%@ page import="iitu.javaee.javaee_endterm.model.Order" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="orderService" scope="session" class="iitu.javaee.javaee_endterm.service.OrderService"/>

<%!
    String ordersStr = "";
    String user_id;
    List<Order> orderList;
    String s = "";
%>

<%
    user_id = request.getParameter("user_id_for_get_orders");
    orderList = orderService.getOrdersByUserId(user_id);

    if (orderList.size() != 0) {
        for (Order order : orderList) {
            s = "   <div class=\"order-card\">\n" +
                    "    <p><span>Order ID:</span> " + order.getId() + "</p>\n" +
                    "    <p><span>Total Cost:</span> " + order.getCost() + "</p>\n" +
                    "    <p><span>Date:</span> " + order.getOrderDay() + "</p>\n" +
                    "</div>";
            ordersStr += s;
        }
    }
%>

<div>
    <%
        if (orderList.size() != 0) {
    %>
    <div class="ul-flex">
        <%= ordersStr %>
    </div>
    <%
        }
    %>
</div>





