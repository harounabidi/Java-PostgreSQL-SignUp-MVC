package Database;

import model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
  private String db_user = "postgres";
  private String db_password = "";
  private String url = "jdbc:postgresql://localhost:5432/postgres";
  private Statement statement = null;

  // Connect to database
  public Connection getConnection() {

    Connection connection = null;

    try {
      connection = DriverManager.getConnection(url, db_user, db_password);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return connection;
  }

  // Create or drop table

  public void createTable() {

    String sql = "CREATE TABLE IF NOT EXISTS USR (id SERIAL PRIMARY KEY, name VARCHAR(40) NOT NULL, password VARCHAR(40) NOT NULL)";

    try {
      statement = getConnection().createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }

  // Insert values to the table

  public void insertUser(UserModel userModel) {

    String sql = "INSERT INTO USR (name, password) values ( '" + userModel.getUsername() + "', '" + userModel.getPassword() + "')";

    try {
      statement = getConnection().createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }

  }

}
