import java.io.IOException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton confirmButton;
  private JTextField usernameField,nameField;
  private JPasswordField passwordField,passwordver;

  public SignUp() throws IOException{
    super("Java Chess Sign Up Page");

    greetingLabel = new JLabel("Sign Up to JavaChess");
    greetingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    greetingLabel.setFont(new Font("Nimbus", Font.PLAIN, 20));
    greetingLabel.setForeground(Color.RED);
    JLabel emptyLabel = new JLabel();
    emptyLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
    confirmButton = new JButton("Confirm Information");
    nameField=new JTextField(30);
    usernameField = new JTextField(30);
    passwordField = new JPasswordField(30);
    passwordver =new JPasswordField(30);

    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(new GridLayout(10, 1));
    loginPanel.add(new JLabel("Name:"));
    loginPanel.add(nameField);
    loginPanel.add(new JLabel("Username:"));
    loginPanel.add(usernameField);
    loginPanel.add(new JLabel("Password:"));
    loginPanel.add(passwordField);
    loginPanel.add(new JLabel(" Verify Password:"));
    loginPanel.add(passwordver);

    JLabel emp2 = new JLabel();
    emp2.setBorder(new EmptyBorder(50, 0, 0, 0));
    loginPanel.add(emp2);
    loginPanel.add(confirmButton);
    loginPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

    add(greetingLabel);
    add(emptyLabel);
    add(loginPanel, BorderLayout.CENTER);

    confirmButton.addActionListener(this);

    setSize(700, 700);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    setVisible(true);

    }
    public void actionPerformed(ActionEvent event) {
        try {
          new LoginPage();
        }
        catch (IOException e) {
          System.out.println("Error occured: Could not launch SignUp page!");
        }
      }

  public static void main(String[] args) throws IOException {
    SignUp supage = new SignUp();
    supage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }



}

  
