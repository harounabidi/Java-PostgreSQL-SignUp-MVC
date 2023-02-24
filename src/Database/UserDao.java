package Database;

import model.UserModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

  private Statement statement = null;
  private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
  private Connection connection = DatabaseConnection.getConnection();


  // Insert values to the table

  public void insertUser(UserModel userModel) {

    String sql = "INSERT INTO USR (name, password) values ( '" + userModel.getUsername() + "', '" + userModel.getPassword() + "')";

    try {
      statement = connection.createStatement();
      statement.executeUpdate(sql);
      connection.close();
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }

  }

}
