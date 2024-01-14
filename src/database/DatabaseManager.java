package database;

import java.sql.*;

public class DatabaseManager {
    String databaseURL = "jdbc:mysql://localhost:3306/liquorance";

    public DatabaseManager() {
        try {
            createDatabase();
//            createTables();

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
                "CREATE TABLE IF NOT EXISTS menu (" +
                        "menu_id INT AUTO_INCREMENT PRIMARY KEY," +
                        "category_id INT NOT NULL" +
                        "name VARCHAR(16) NOT NULL," +
                        "price int NOT NULL" +
                        ")"
        );

        preStat.executeUpdate();

        preStat = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS category (" +
                        "category_id INT AUTO_INCREMENT PRIMARY KEY," +
                        "category_name VARCHAR(10) NOT NULL" +
                        ")"
        );

        preStat.executeUpdate();

        preStat = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS order_number (" +
                        "order_id INT AUTO_INCREMENT PRIMARY KEY," +
                        "menu_id INT NOT NULL" +
                        "order_total INT NOT NULL" +
                        ")"
        );

        preStat.executeUpdate();

        preStat = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS order (" +
                        "order_id INT AUTO_INCREMENT PRIMARY KEY," +
                        "menu_id INT NOT NULL" +
                        "order_quantity INT NOT NULL" +
                        "order_price INT NOT NULL" +
                        ")"
        );

        preStat.executeUpdate();

        connection.close();
    }

    public void insertToOrderNumber(int menu_id, int order_total) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseURL, "root", "");

        PreparedStatement preStat;

        preStat = connection.prepareStatement(
                "INSERT INTO (menu_id, order_total) order_number VALUES (?, ?)"
        );

        preStat.setInt(1, menu_id);
        preStat.setInt(2, order_total);

        preStat.executeUpdate();

        connection.close();
    }

    public void insertToOrder(int menu_id, int order_quantity,  int order_price) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseURL, "root", "");

        PreparedStatement preStat;

        preStat = connection.prepareStatement(
                "INSERT INTO (menu_id, order_quantity, order_price) ORDER VALUES (?, ?, ?)"
        );

        preStat.setInt(1, menu_id);
        preStat.setInt(2, order_quantity);
        preStat.setInt(3, order_price);

        preStat.executeUpdate();

        connection.close();
    }
}
