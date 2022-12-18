import java.util.LinkedList;

interface Movable {
    void move(int xp, int yp);
}
public class Piece implements Movable{
    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    LinkedList<Piece> ps;
    String name;
    public Piece(int xp, int yp, boolean isWhite,String n, LinkedList<Piece> ps) {
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
        this.isWhite = isWhite;
        this.ps = ps;
        name = n;
        ps.add(this);
    }
    public Piece(String pos, boolean isWhite,String n, LinkedList<Piece> ps) {
        this.xp = Character.getNumericValue(pos.charAt(1)) - 1;
        this.yp = 7 - pos.charAt(0) + 'a';
        x = xp*64;
        y = yp*64;
        this.isWhite = isWhite;
        this.ps = ps;
        name = n;
        ps.add(this);
    }
    
    public void move(int xp,int yp){
        if (Game.getPiece(xp*64, yp*64)!=null){
            if (Game.getPiece(xp*64, yp*64).isWhite != isWhite){
                Game.getPiece(xp*64, yp*64).kill();
            }
            else {
                x = this.xp*64;
                y = this.yp*64;
                return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
    }
    public void kill(){
        ps.remove(this);
    }
}
