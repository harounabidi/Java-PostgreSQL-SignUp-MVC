package controller;

import Database.UserDao;
import model.UserModel;
import view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
  private UserDao userDao;
  private View view;
  private UserModel userModel;

  public Controller(UserModel userModel, View view) {
    this.userModel = userModel;
    this.view = view;
  }

  public void insertUser() {

    this.view.signUpListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        userDao = new UserDao();

        userModel.setUsername(view.getUsernameField());
        userModel.setPassword(view.getPasswordField());

        // insert value to the usr table
        userDao.insertUser(userModel);
      }
    });
  }

}
