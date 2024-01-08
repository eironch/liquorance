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

        PreparedStatement preStat = connection.prepareStatement(
                ""
        );

        preStat.executeUpdate();

        connection.close();
    }
}
