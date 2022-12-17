import java.io.IOException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import javax.imageio.ImageIO;

public class LoginPage extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton loginButton;
  private JTextField usernameField;
  private JPasswordField passwordField;

  public LoginPage() {
    super("Java Chess Login");

    greetingLabel = new JLabel("Welcome to Chess Login Page ");
    loginButton = new JButton("Log in");
    usernameField = new JTextField(30);
    passwordField = new JPasswordField(30);

    JPanel loginPanel = new JPanel();
    loginPanel.add(new JLabel("Username:"));
    loginPanel.add(usernameField);
    loginPanel.add(new JLabel("Password:"));
    loginPanel.add(passwordField);
    loginPanel.add(loginButton);

    add(greetingLabel, BorderLayout.NORTH);
    add(loginPanel, BorderLayout.CENTER);

    loginButton.addActionListener(this);

    FlowLayout layout = new FlowLayout();
    loginPanel.setLayout(layout);

    setSize(600, 600);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    try {
      new Game();
    }
    catch (IOException e) {
      System.out.println("Error occured: Could not launch login page!");
    }
  }
  public static void main(String[] args) {
    LoginPage loginpage = new LoginPage();
    loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}