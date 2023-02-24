package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
  private JPanel mainPanel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JLabel usernameLabel;
  private JLabel passwordLabel;
  private JButton signUpBtn;

  public UserView() {
    this.signUpBtn = new JButton("Sign Up");
    this.usernameField = new JTextField(15);
    this.passwordField = new JPasswordField(15);
    this.usernameLabel = new JLabel("Username:");
    this.passwordLabel = new JLabel("Password:");
    this.mainPanel = new JPanel();

    promptNewUser();
  }

  public void promptNewUser() {

    this.setSize(300, 150);
    this.setLocation(new Point(500, 300));

    this.setTitle("Sign Up");
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(mainPanel);

    mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    mainPanel.add(usernameLabel);
    mainPanel.add(usernameField);
    mainPanel.add(passwordLabel);
    mainPanel.add(passwordField);
    mainPanel.add(signUpBtn);

    this.setVisible(true);
  }

  public String getUsernameField() {
    return usernameField.getText();
  }

  public String getPasswordField() {
    return passwordField.getText();
  }

  public void signUpListener(ActionListener listener) {
    signUpBtn.addActionListener(listener);
  }

}
