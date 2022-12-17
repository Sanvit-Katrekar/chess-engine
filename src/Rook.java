import java.util.LinkedList;
public class Rook extends Piece{
    public Rook(int xp, int yp, boolean isWhite,String n, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "rook", ps);
    }
    public Rook(String pos, boolean isWhite,String n, LinkedList<Piece> ps) {
        super(pos, isWhite, "rook", ps);
    } 
}
