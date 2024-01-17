package database;

import java.sql.*;

public class DatabaseManager {
    String databaseURL = "jdbc:mysql://localhost:3306/liquorance";

    public DatabaseManager() {
        try {
            createDatabase();
            createTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";

        Connection connection = DriverManager.getConnection(url, "root", "");

        PreparedStatement preStat = connection.prepareStatement(
                "CREATE DATABASE IF NOT EXISTS liquorance"
        );

        preStat.executeUpdate();

        connection.close();
    }

    public void createTables() throws SQLException {
        Connection connection = DriverManager.getConnection(databaseURL, "root", "");

        PreparedStatement preStat;

        preStat = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS orders (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "datetime DATETIME NOT NULL," +
                        "order_total INT NOT NULL" +
                        ")"
        );

        preStat.executeUpdate();

        preStat = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS ordered_items (" +
                        "order_id INT NOT NULL," +
                        "menu_id INT NOT NULL," +
                        "item_name VARCHAR(24) NOT NULL," +
                        "order_quantity INT NOT NULL," +
                        "order_price INT NOT NULL" +
                        ")"
        );

        preStat.executeUpdate();

        connection.close();
    }

    public void insertToOrders(Timestamp dateTime, int order_total) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseURL, "root", "");

        PreparedStatement preStat;

        preStat = connection.prepareStatement(
                "INSERT INTO orders (datetime, order_total) VALUES (?, ?)"
        );

        preStat.setTimestamp(1, dateTime);
        preStat.setInt(2, order_total);

        preStat.executeUpdate();

        connection.close();
    }

    public void insertToOrderedItems(int order_id, int menu_id, String item_name, int order_quantity, int order_price) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseURL, "root", "");

        PreparedStatement preStat;

        preStat = connection.prepareStatement("INSERT INTO ordered_items (" +
                "order_id, menu_id, item_name, order_quantity, order_price" +
                ") VALUES (?, ?, ?, ?, ?)"
        );

        preStat.setInt(1, order_id);
        preStat.setInt(2, menu_id);
        preStat.setString(3, item_name);
        preStat.setInt(4, order_quantity);
        preStat.setInt(5, order_price);

        preStat.executeUpdate();

        connection.close();
    }

    public int getOrderIdOfLatest() throws SQLException {
        Connection connection =  DriverManager.getConnection(databaseURL, "root", "");

        PreparedStatement preStat;

        preStat = connection.prepareStatement(
                "SELECT id FROM orders ORDER BY id DESC LIMIT 2"
        );

        ResultSet resultSet = preStat.executeQuery();

        if (resultSet.next()){
            int orderID = resultSet.getInt("id");

            connection.close();

            return orderID;
        }

        connection.close();

        return 0;
    }
}
