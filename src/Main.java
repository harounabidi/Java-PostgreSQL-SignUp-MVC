import controller.UserController;
import model.UserModel;
import view.UserView;

public class Main {
  public static void main(String[] args) {
    UserView userView = new UserView();
    UserModel userModel = new UserModel();

    UserController userController = new UserController(userModel, userView);
    userController.insertUser();
  }
}