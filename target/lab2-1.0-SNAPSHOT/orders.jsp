<%@ page import="kz.iitu.javaee.models.Order" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="orderDao" scope="session" class="kz.iitu.javaee.dao.OrderDao"/>

<%!
    String ordersStr = "";
    String user_id;
    List<Order> orderList;
    String s = "";
%>

<%
    user_id = request.getParameter("user_id_for_get_orders");
    orderList = orderDao.selectOrdersByUserId(user_id);

    if (orderList.size() != 0) {
        for (Order order : orderList) {
            s = "   <div class=\"order-card\">\n" +
                    "    <p><span>Order ID:</span> " + order.getId() + "</p>\n" +
                    "    <p><span>Total Cost:</span> " + order.getCost() + "</p>\n" +
                    "    <p><span>Date:</span> " + order.getOrderDay() + "</p>\n" +
                    "</div>";
            ordersStr += s;
        }
        System.out.println(orderList.toString());
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





