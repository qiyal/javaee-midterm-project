package iitu.javaee.javaee_endterm.db.dao;

import iitu.javaee.javaee_endterm.db.DBConnection;
import iitu.javaee.javaee_endterm.db.DBData;

public class OrderWithItemsDao {
    private DBConnection dbConnection;
    private String tableName1;
    private String tableName2;

    public OrderWithItemsDao() {
        this.dbConnection = new DBConnection(DBData.URL, DBData.USERNAME, DBData.PASSWORD);
        this.tableName1 = "order";
        this.tableName2 = "order_item";
    }
}
