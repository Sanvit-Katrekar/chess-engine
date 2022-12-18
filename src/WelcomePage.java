import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;

public class WelcomePage extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton loginButton;
  private JButton signupButton;

  public WelcomePage() throws IOException {
    super("Java Chess");
    Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int)size.getWidth();
    int height=(int)size.getHeight();
    super.pack();
    super.setSize(width/2, height - 350);

    greetingLabel = new JLabel("Welcome to JavaChess");
    greetingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    greetingLabel.setFont(new Font("Nimbus", Font.PLAIN, 20));
    greetingLabel.setForeground(Color.RED);

    JLabel img = new ImgResource("chess.png",width/3, height/3);
    img.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel btnPanel = new JPanel();
    btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
    loginButton = new JButton();
    loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    signupButton = new JButton();
    signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    loginButton.setIcon(new ImgResource("ll1.png",200, 100).getScaled());
    signupButton.setIcon(new ImgResource("su1.png",200, 100).getScaled());
    btnPanel.add(loginButton);
    btnPanel.add(signupButton);
    btnPanel.setBorder(new EmptyBorder(50, 0, 0, 0));

    super.add(greetingLabel);
    super.add(img);
    super.add(btnPanel);

    loginButton.addActionListener(this);

    super.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    super.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    try {
      new LoginPage();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("An error occured! Not able to log in..");
    }
  }
  public static void main(String[] args) throws IOException {
    WelcomePage WelcomePage = new WelcomePage();
    WelcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}