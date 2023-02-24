package Database;

import model.UserModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

  private Statement statement = null;
  static Connection connection = DatabaseConnection.getConnection();

  // Create or drop table

  public void createTable() {

    String sql = "CREATE TABLE IF NOT EXISTS USR (id SERIAL PRIMARY KEY, name VARCHAR(40) NOT NULL, password VARCHAR(40) NOT NULL)";

    try {
      statement = connection.createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }

  // Insert values to the table

  public void insertUser(UserModel userModel) {

    String sql = "INSERT INTO USR (name, password) values ( '" + userModel.getUsername() + "', '" + userModel.getPassword() + "')";

    try {
      statement = connection.createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }

  }

}
