package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

  private static Connection connection = null;
  private static String db_user = "postgres";
  private static String db_password = "";
  private static String url = "jdbc:postgresql://localhost:5432/postgres";

  private static DatabaseConnection instance;

  // Making the constructor private so that we prevent making other instances
  private DatabaseConnection() {
  }

  public static DatabaseConnection getInstance()  {
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }

  public static Connection getConnection() {

    try {
      connection = DriverManager.getConnection(url, db_user, db_password);
      Statement statement = connection.createStatement();
      String sql = "CREATE TABLE IF NOT EXISTS USR (" +
              "id SERIAL PRIMARY KEY, " +
              "name VARCHAR(40) NOT NULL, " +
              "password VARCHAR(40) NOT NULL)";
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return connection;
  }

}
