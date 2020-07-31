package ch.cloudcraft.cloudcore.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinManager {
    public static ResultSet PlayerResultSet;
    public static String UUID;

    public static void updateBalance(int amount, boolean add) {
        try {
            int finalBalance = 0;
            if (add) {
                // Get the previous balance in order to continue
                finalBalance = getBalance() + amount;
            }

            MySQLManager.execUpdate("UPDATE money SET moneyValue = " + finalBalance + " WHERE PlayerUUID = '" + UUID + "';");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int getBalance() {
        try {
            ResultSet resultSet = PlayerResultSet;
            resultSet.next();
            return resultSet.getInt("moneyValue");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public static CoinManager getPlayer(String UUID) {
        createIfNotExist(UUID); //-> Default
        try {
            CoinManager.UUID = UUID;
            PlayerResultSet = MySQLManager.requestQuery("SELECT moneyValue FROM money WHERE PlayerUUID = '" + UUID + "';");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CoinManager();
    }


    public static void createIfNotExist(String UUID) {
        try {
            ResultSet resultSet = MySQLManager.requestQuery("SELECT * FROM money WHERE PlayerUUID = '" + UUID + "';");

            if (!resultSet.next()) {
                System.out.println("UUID " + UUID + " does not exist! Inserting");
                MySQLManager.execUpdate("INSERT INTO money (PlayerUUID, moneyValue) VALUES ('" + UUID + "', 0);");

            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
