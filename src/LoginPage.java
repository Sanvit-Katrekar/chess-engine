import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton loginButton;
  private JTextField usernameField;
  private JPasswordField passwordField;

  public LoginPage() throws IOException{
    super(" Java Chess");
    greetingLabel = new JLabel("Login to Java Chess");
    loginButton = new JButton("Log in");
    usernameField = new JTextField(30);
    passwordField = new JPasswordField(30);
    JLabel imgLabel = new ImgResource("chess.png", 10, 10, 100, 100);

    JPanel loginPanel = new JPanel();
    loginPanel.add(new JLabel("Username:"));
    loginPanel.add(usernameField);
    loginPanel.add(new JLabel("Password:"));
    loginPanel.add(passwordField);
    loginPanel.add(loginButton);
    loginPanel.add(imgLabel);
    loginPanel.setLayout(new GridBagLayout());

    super.add(greetingLabel, BorderLayout.NORTH);
    super.add(loginPanel, BorderLayout.CENTER);

    loginButton.addActionListener(this);
    
    super.pack();
    super.setSize(600, 300);
    super.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    String username = usernameField.getText();
    char[] password = passwordField.getPassword();
    if (authenticate(username, password)) {
      JOptionPane.showMessageDialog(this, username+" has logged in");
    } else {
      JOptionPane.showMessageDialog(this, "Invalid Login Credentials");
    }
  }

  private boolean authenticate(String username,char[] password) {
  return true;
  }

  public static void main(String[] args) throws IOException {
    LoginPage LoginPage = new LoginPage();
    LoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
