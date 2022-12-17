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
  private JButton signupButton;

  public LoginPage() {
    super("Java Chess Login");
    greetingLabel = new JLabel("Welcome to Java-Chess");
    loginButton = new JButton("Log in");
    signupButton = new JButton("Sign up");

    JPanel btnPanel = new JPanel();
    btnPanel.add(loginButton);
    btnPanel.add(signupButton);
    btnPanel.setLayout(new FlowLayout());

    super.add(greetingLabel, BorderLayout.CENTER);
    super.add(btnPanel, BorderLayout.CENTER);

    loginButton.addActionListener(this);

    this.setLayout(new FlowLayout());
    
    super.pack();
    super.setSize(600, 300);
    super.setVisible(true);
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