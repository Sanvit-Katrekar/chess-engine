import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.*;

public class Game {
    public static LinkedList<Piece> ps=new LinkedList<>();
    public static Piece selectedPiece=null;
    public static Piece getPiece(int x,int y){
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
        Game game = new Game();
        game.run();
    }
    public void run() throws IOException {
        // Loading chess piece images
        // BufferedImage piecesImg = ImageIO.read(new File(Resource.getResourcePath("pieces.png")));
        BufferedImage piecesImg = new ImgResource("pieces.png").getBuff();
        int imgWidth = piecesImg.getWidth();
        int imgHeight = piecesImg.getHeight();
        int imgRows = 2;
        int imgCols = 6;
        Image[] imgs=new Image[12];
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
        
        JFrame rootFrame = new JFrame();
        rootFrame.setBounds(10, 10, 600, 600);
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 545);
        //frame.setUndecorated(true);
        JPanel pn = new JPanel(){
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
        frame.add(pn);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece!=null){
                    selectedPiece.x=e.getX()-32;
                    selectedPiece.y=e.getY()-32;
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
            selectedPiece=getPiece(e.getX(), e.getY());
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
