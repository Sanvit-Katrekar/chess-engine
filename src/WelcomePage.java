import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import javax.imageio.ImageIO;

public class WelcomePage extends JFrame implements ActionListener {
  private JLabel greetingLabel;
  private JButton loginButton;
  private JButton signupButton;

  public WelcomePage() throws IOException {
    super("Java Chess");
    greetingLabel = new JLabel("Welcome to Java-Chess");
    loginButton = new JButton();
    signupButton = new JButton();
    loginButton.setIcon(new ImgResource("login.png",100, 100).getScaled());
    signupButton.setIcon(new ImgResource("signup.png",100, 100).getScaled());
    JPanel btnPanel = new JPanel();
    btnPanel.add(loginButton);
    btnPanel.add(signupButton);
    btnPanel.setLayout(new FlowLayout());
    Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int)size.getWidth();
    int height=(int)size.getHeight();
    JLabel img = new ImgResource("chess.png",width/2,height/2);
    btnPanel.add(img);

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
      new LoginPage();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("An error occured! Not able to log in..");
    }
  }
  public static void main(String[] args) throws IOException {
    WelcomePage WelcomePage = new WelcomePage();
    WelcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}