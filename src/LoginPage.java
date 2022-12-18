import java.io.IOException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

    JButton bck=new JButton();
    bck.setIcon(new ImgResource("back.png",50, 50).getScaled());
    bck.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          new WelcomePage();
        } 
        catch (IOException e1) {
          e1.printStackTrace();
        }
        
      }
    });

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
    loginPanel.add(bck);
    loginPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

    JLabel img = new ImgResource("css.png", 200, 200);
    img.setAlignmentX(Component.CENTER_ALIGNMENT);

    add(greetingLabel);
    add(emptyLabel);
    add(img);
    add(loginPanel, BorderLayout.CENTER);

    loginButton.addActionListener(this);

    setSize(600, 600);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
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
  public static void main(String[] args) throws IOException {
    LoginPage loginpage = new LoginPage();
    loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}