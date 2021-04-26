package iitu.javaee.javaee_endterm.db.dao;

import iitu.javaee.javaee_endterm.db.DBConnection;
import iitu.javaee.javaee_endterm.db.DBData;
import iitu.javaee.javaee_endterm.model.Order;
import iitu.javaee.javaee_endterm.model.OrderItem;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao {
    private DBConnection dbConnection;
    private String tableName;

    public OrderItemDao() {
        this.dbConnection = new DBConnection(DBData.URL, DBData.USERNAME, DBData.PASSWORD);
        this.tableName = "order_item";
    }

    public OrderItem getOrderItemObject(Integer orderItemId, Integer bookId, Integer orderId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemId);
        orderItem.setBookId(bookId);
        orderItem.setOrderId(orderId);
        return orderItem;
    }

    public void createOrder(OrderItem orderItem) {
        dbConnection.openConnect();

        String INSERT_ORDER_ITEM_SQL = "INSERT INTO " + tableName + "  (book_id, order_id) VALUES "
                + " (?, ?);";

        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(INSERT_ORDER_ITEM_SQL);
            preparedStatement.setString(1, orderItem.getBookId().toString());
            preparedStatement.setString(2, orderItem.getOrderId().toString());
            dbConnection.insertData(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL insert OrderItem query failed!");
        }
    }

    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        dbConnection.openConnect();
        List<OrderItem> orderItems = new ArrayList<>();
        String sql = "SELECT * FROM "+ tableName +" WHERE order_id = " + orderId;
        ResultSet resultSet = dbConnection.getData(sql);

        try {
            while (resultSet.next()) {
                Integer orderItemId = resultSet.getInt("order_item_id");
                Integer bookId = resultSet.getInt("book_id");
                Integer orderId_ = resultSet.getInt("order_id");
                orderItems.add(getOrderItemObject(orderItemId, bookId, orderId_));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }

}
