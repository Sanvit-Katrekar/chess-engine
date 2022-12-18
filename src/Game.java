import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.*;

public class Game {
    public static LinkedList<Piece> ps = new LinkedList<>();
    public static Piece selectedPiece = null;
    public static Piece getPiece(int x,int y) {
        int xp=x/64;
        int yp=y/64;
        for(Piece p: ps){
            if (p.xp == xp && p.yp == yp){
                return p;
            }
        }
        return null;
    }
    public static boolean instanceExists = false;
    public Game() throws IOException {
        if (instanceExists == false) {
            instanceExists = true;
            this.run();
        }
    }
    public static void main(String[] args) throws IOException {
        new Game();
    }
    public void run() throws IOException {
        // Loading chess piece images
        // BufferedImage piecesImg = ImageIO.read(new File(Resource.getResourcePath("pieces.png")));
        BufferedImage piecesImg = new ImgResource("pieces.png").getBuff();
        int imgWidth = piecesImg.getWidth();
        int imgHeight = piecesImg.getHeight();
        int imgRows = 2;
        int imgCols = 6;
        Image[] imgs = new Image[12];
        int index = 0;
        for(int y = 0; y < imgHeight; y += imgHeight/imgRows){
            for(int x=0; x < imgWidth; x += imgWidth/imgCols){
                imgs[index] = piecesImg.getSubimage(x, y, 161, 155).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                index++;
            }    
        }
        new Piece("h1", false, "rook", ps);
        new Piece("h2", false, "knight", ps);
        new Piece("h3", false, "bishop", ps);
        new Piece("h4", false, "queen", ps);
        new Piece("h5",  false, "king", ps);
        new Piece("h6", false, "bishop", ps);
        new Piece("h7", false, "knight", ps);
        new Piece("h8", false, "rook", ps);
        
        new Piece(1, 1, false, "pawn", ps);
        new Piece(2, 1, false, "pawn", ps);
        new Piece(3, 1, false, "pawn", ps);
        new Piece(4, 1, false, "pawn", ps);
        new Piece(5, 1, false, "pawn", ps);
        new Piece(6, 1, false, "pawn", ps);
        new Piece(7, 1, false, "pawn", ps);
        new Piece(0, 1, false, "pawn", ps);
        
        new Piece(0, 7, true, "rook", ps);
        new Piece(1, 7, true, "knight", ps);
        new Piece(2, 7, true, "bishop", ps);
        new Piece(3, 7, true, "queen", ps);
        new Piece(4, 7, true, "king", ps);
        new Piece(5, 7, true, "bishop", ps);
        new Piece(6, 7, true, "knight", ps);
        new Piece(7, 7, true, "rook", ps);
        new Piece(1, 6, true, "pawn", ps);
        new Piece(2, 6, true, "pawn", ps);
        new Piece(3, 6, true, "pawn", ps);
        new Piece(4, 6, true, "pawn", ps);
        new Piece(5, 6, true, "pawn", ps);
        new Piece(6, 6, true, "pawn", ps);
        new Piece(7, 6, true, "pawn", ps);
        new Piece(0, 6, true, "pawn", ps);
        

        JFrame frame = new JFrame();
        //frame.setBounds(10, 10, 512, 545);
        Color BG_COLOR = new Color(58, 69, 73);
        frame.getContentPane().setBackground(BG_COLOR);
        frame.setResizable(false);
        frame.setBounds(10, 10, 700, 700);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //do the same for columns 
        //layout.setConstraints(frame, gbc);
        frame.setLayout(layout);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.insets = new Insets(0,0,0,0);

        JPanel pn = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white=true;
                for (int y = 0; y<8; y++){
                    for (int x = 0; x<8; x++){
                        if (white) {
                            g.setColor(new Color(235,235, 208));
                        }
                        else {
                            g.setColor(new Color(119, 148, 85));  
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
                for(Piece p: ps){
                    int index = 0;
                    int correctionX = 0, correctionY = 0;
                    // correctionX: +ve -> Move right; -ve -> Move left
                    // correctionY: +ve -> Move down; -ve -> Move up
                    if(p.name.equalsIgnoreCase("king")){
                        index = 0;
                        correctionX = 5;
                        correctionY = 5;
                    }
                    else if(p.name.equalsIgnoreCase("queen")){
                        index = 1;
                        correctionX = 1;
                        correctionY = 4;
                    }
                    else if(p.name.equalsIgnoreCase("bishop")){
                        index = 2;
                        correctionX = -2;
                        correctionY = 4;
                    }
                    else if(p.name.equalsIgnoreCase("knight")){
                        index = 3;
                        correctionX = -5;
                        correctionY = 3;
                    }
                    else if(p.name.equalsIgnoreCase("rook")){
                        index = 4;
                        correctionX = -12;
                        correctionY = 3;
                    }
                    else if(p.name.equalsIgnoreCase("pawn")){
                        index = 5;
                        correctionX = -13;
                        correctionY = 3;
                    }
                    if(!p.isWhite){
                        index += 6;
                        correctionY = -correctionY;
                    }
                    g.drawImage(imgs[index], p.x + correctionX, p.y + correctionY, this);
                }
            }
            
        };
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(new JLabel(), gbc);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i = 1; i <= 8; i++) {
            JLabel label1 = new JLabel(String.valueOf((char) ('a' + i - 1)), SwingConstants.CENTER);
            label1.setOpaque(true);
            label1.setBackground(BG_COLOR);
            label1.setForeground(Color.WHITE);
            gbc.gridx = i;
            gbc.gridy = 0;
            frame.add(label1, gbc);
            JLabel label2 = new JLabel(""+i, SwingConstants.CENTER);
            label2.setOpaque(true);
            label2.setBackground(BG_COLOR);
            label2.setForeground(Color.WHITE);
            gbc.gridx = 0;
            gbc.gridy = i;
            frame.add(label2, gbc);
        }
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weighty = 0.5;
        frame.add(new JLabel(), gbc);
        gbc.gridy = 10;
        frame.add(new JLabel(), gbc);
        gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(new JLabel(), gbc);
        gbc.gridx = 10;
        frame.add(new JLabel(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 8;
        gbc.gridheight = 8;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(pn, gbc);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece!=null){
                    selectedPiece.x = e.getX()-32-64;
                    selectedPiece.y = e.getY()-32-64;
                    frame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPiece(e.getX() - 64, e.getY() - 64);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedPiece.move(e.getX()/64, e.getY()/64);
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
