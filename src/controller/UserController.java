package controller;

import Database.UserDao;
import model.UserModel;
import view.UserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
  private UserDao userDao;
  private UserView userView;
  private UserModel userModel;

  public UserController(UserModel userModel, UserView userView) {
    this.userModel = userModel;
    this.userView = userView;
  }

  public void insertUser() {

    this.userView.signUpListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        userDao = new UserDao();

        userModel.setUsername(userView.getUsernameField());
        userModel.setPassword(userView.getPasswordField());

        // insert value to the usr table
        userDao.insertUser(userModel);
      }
    });
  }

}
