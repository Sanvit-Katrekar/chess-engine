import java.util.LinkedList;
public class Rook extends Piece {
    public static String[][] chessBoard = Game.chessBoard;
    public Rook(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "rook", ps);
    }
    public Rook(String pos, boolean isWhite, LinkedList<Piece> ps) {
        super(pos, isWhite, "rook", ps);
    }
    public String possibleMoves(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            try {
                while(" ".equals(chessBoard[r][c+temp*j]))
                {
                    oldPiece=chessBoard[r][c+temp*j];
                    chessBoard[r][c]=" ";
                    chessBoard[r][c+temp*j]="R";
                    if (King.kingSafe()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    chessBoard[r][c]="R";
                    chessBoard[r][c+temp*j]=oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard[r][c+temp*j].charAt(0))) {
                    oldPiece=chessBoard[r][c+temp*j];
                    chessBoard[r][c]=" ";
                    chessBoard[r][c+temp*j]="R";
                    if (King.kingSafe()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    chessBoard[r][c]="R";
                    chessBoard[r][c+temp*j]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(chessBoard[r+temp*j][c]))
                {
                    oldPiece=chessBoard[r+temp*j][c];
                    chessBoard[r][c]=" ";
                    chessBoard[r+temp*j][c]="R";
                    if (King.kingSafe()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    chessBoard[r][c]="R";
                    chessBoard[r+temp*j][c]=oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard[r+temp*j][c].charAt(0))) {
                    oldPiece=chessBoard[r+temp*j][c];
                    chessBoard[r][c]=" ";
                    chessBoard[r+temp*j][c]="R";
                    if (King.kingSafe()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    chessBoard[r][c]="R";
                    chessBoard[r+temp*j][c]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
        }
        return list;
    }
}
