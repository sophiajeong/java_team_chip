package app.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

// DatabaseManager 클래스는 데이터베이스 관리를 담당합니다.
public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:clothing.db";

    public DatabaseManager() {
        createDatabase();
        addInitialUser();
    }

    private void createDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String clothingTableSql = "CREATE TABLE IF NOT EXISTS clothing (" +
                                      "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                      "name TEXT," +
                                      "color TEXT," +
                                      "season TEXT," +
                                      "style TEXT," +
                                      "laundry TEXT," +
                                      "imageUrl TEXT," +
                                      "category TEXT)";
            statement.execute(clothingTableSql);

            String usersTableSql = "CREATE TABLE IF NOT EXISTS users (" +
                                   "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                   "name TEXT," +
                                   "email TEXT UNIQUE," +
                                   "password TEXT)";
            statement.execute(usersTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addInitialUser() {
        String sql = "INSERT OR IGNORE INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "눈송이");
            preparedStatement.setString(2, "smu@sookmyung.ac.kr");
            preparedStatement.setString(3, "1234");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(String name, String email, String password) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
