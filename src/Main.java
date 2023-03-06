import controller.Controller;
import model.UserModel;
import view.View;

public class Main {
  public static void main(String[] args) {
    View view = new View();
    UserModel userModel = new UserModel();

    Controller controller = new Controller(userModel, view);
    controller.insertUser();
  }
}