import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;

public class LoginPage extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton loginButton;
  private JTextField usernameField;
  private JPasswordField passwordField;

  public LoginPage() throws IOException {
    super("Java Chess Login");

    greetingLabel = new JLabel("Login to JavaChess");
    greetingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    greetingLabel.setFont(new Font("Nimbus", Font.PLAIN, 20));
    greetingLabel.setForeground(Color.RED);
    JLabel emptyLabel = new JLabel();
    emptyLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
    loginButton = new JButton("Login");
    usernameField = new JTextField(30);
    passwordField = new JPasswordField(30);


    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(new GridLayout(10, 1));
    loginPanel.add(new JLabel("Username:"));
    loginPanel.add(usernameField);
    loginPanel.add(new JLabel("Password:"));
    loginPanel.add(passwordField);
    JLabel emp2 = new JLabel();
    emp2.setBorder(new EmptyBorder(50, 0, 0, 0));
    loginPanel.add(emp2);
    loginPanel.add(loginButton);
    loginPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

    JLabel img = new ImgResource("css.png", 400, 200);
    img.setAlignmentX(Component.CENTER_ALIGNMENT);

    add(greetingLabel);
    add(emptyLabel);
    add(img);
    add(loginPanel, BorderLayout.CENTER);

    loginButton.addActionListener(this);

    setSize(700, 700);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    try {
      JFrame f = new JFrame();
      if (authenticate()) {
        JOptionPane.showMessageDialog(f,"Succesfully logged in!");
        new Game();
      }
      else {
        JOptionPane.showMessageDialog(f,"Incorrect username/password!");
      }
    }
    catch (IOException e) {
      System.out.println("Error occured: Could not launch login page!");
    }
  }
  // Returns SHA1 hash
  public static String hash(String value) {
    String sha1 = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(value.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
    return sha1;
  }
  public boolean authenticate() {
    try {
      SQLConnector sqltor = new SQLConnector();
      ResultSet rs = sqltor.executeQuery(String.format("select passwd from User where username = '%s';", usernameField.getText()));
      String passwdHash = hash(String.valueOf(passwordField.getPassword()));
      rs.next();
      if (rs.getString("passwd").equals(passwdHash)) {
        return true;
      }
      return false;

    }
    catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }
  public static void main(String[] args) throws IOException {
    LoginPage loginpage = new LoginPage();
    loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}