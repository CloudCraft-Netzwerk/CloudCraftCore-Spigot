package ch.cloudcraft.cloudcore.utils;

import java.sql.*;

public class MySQLManager {

    private static Connection connection;
    private static String host, database, username, password;
    private static int port;


    // MYSQL SPECIFIC / UNIVERSAL USE
    public static ResultSet requestQuery(String query) {
        try {
            Statement std = getConnection().createStatement();
            return std.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static ResultSet requestQuery(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void execUpdate(String query) {
        try {
            getConnection().createStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void execUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return connection;
    }

    public static void start(String host, int port, String database, String username, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            init(host, port, database, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void init(String host, int port, String database, String username, String password) {

        MySQLManager.host = host;
        MySQLManager.port = port;
        MySQLManager.database = database;
        MySQLManager.username = username;
        MySQLManager.password = password;
        try {
            openConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void openConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        execUpdate("CREATE TABLE IF NOT EXISTS money (PlayerUUID VARCHAR(200), moneyValue BIGINT);");
    }
}

