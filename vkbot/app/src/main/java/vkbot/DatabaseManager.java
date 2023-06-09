package vkbot;

import java.sql.*;
import java.util.Random;

public class DatabaseManager {
    private Connection connection;
    
    public DatabaseManager() {
        try {
            // Установка соединения с базой данных
            //String databasePath = getClass().getClassLoader().getResource("db.db").getPath();
            //connection = DriverManager.getConnection("jdbc:sqlite:/D:/Project/vkbot/app/bin/main/db.db");

            connection = DriverManager.getConnection("jdbc:sqlite:app/bin/main/db.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeConnection() {
        try {
            // Закрытие соединения с базой данных
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCrystals(int newCrystals) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET res_cry = " + newCrystals);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGold(int newGold) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET res_gol = " + newGold);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOre(int newOre) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET res_ore = " + newOre);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWood(int newWood) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET res_wod = " + newWood);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFood(int newFood) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET res_fod = " + newFood);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCrystals() {
        int crystals = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT res_cry FROM users");
            if (resultSet.next()) {
                crystals = resultSet.getInt("res_cry");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crystals;
    }
    
    public int getGold() {
        int gold = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT res_gol FROM users");
            if (resultSet.next()) {
                gold = resultSet.getInt("res_gol");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return gold;
    }

    public int getWood() {
        int wood = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT res_wod FROM users");
            if (resultSet.next()) {
                wood = resultSet.getInt("res_wod");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return wood;
    }   

    public int getOre() {
        int ore = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT res_ore FROM users");
            if (resultSet.next()) {
                ore = resultSet.getInt("res_ore");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return ore;
    }

    public int getRunes() {
        int runes = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT runes FROM users");
            if (resultSet.next()) {
                runes = resultSet.getInt("runes");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return runes;
    }

    public int getBuilders() {
        int builders = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT builders FROM users");
            if (resultSet.next()) {
                builders = resultSet.getInt("builders");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return builders;
    }

    public int getKey() {
        int key = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT key FROM users");
            if (resultSet.next()) {
                key = resultSet.getInt("key");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    public int getFood() {
        int food = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT res_fod FROM users");
            if (resultSet.next()) {
                food = resultSet.getInt("res_fod");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    public int getlvl_cas() {
        int lvl_cas = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lvl_cas FROM users");
            if (resultSet.next()) {
                lvl_cas = resultSet.getInt("lvl_cas");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return lvl_cas;
    }

    public int getlvl_min() {
        int lvl_min = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lvl_min FROM users");
            if (resultSet.next()) {
                lvl_min = resultSet.getInt("lvl_min");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return lvl_min;
    }

    public int getlvl_saw() {
        int lvl_saw = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lvl_saw FROM users");
            if (resultSet.next()) {
                lvl_saw = resultSet.getInt("lvl_saw");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return lvl_saw;
    }

    public int getlvl_far() {
        int lvl_far = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lvl_far FROM users");
            if (resultSet.next()) {
                lvl_far = resultSet.getInt("lvl_far");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return lvl_far;
    }

    public int getlvl_con() {
        int lvl_con = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lvl_con FROM users");
            if (resultSet.next()) {
                lvl_con = resultSet.getInt("lvl_con");
            }
            resultSet.close();
            statement.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
        return lvl_con;
    }
    // Продолжите код для получения остальных данных из базы данных

    public static void updateResource(String resourceName, int resourceCount) {
    }
}
