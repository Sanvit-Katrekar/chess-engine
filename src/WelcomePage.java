import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomePage extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton loginButton;
  private JButton signupButton;

  public WelcomePage() {
    super(" Java Chess");
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
    new LoginPage();
  }
  public static void main(String[] args) {
    WelcomePage WelcomePage = new WelcomePage();
    WelcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
