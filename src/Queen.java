import java.util.LinkedList;
public class Queen extends Piece
{
    public static String[][] chessBoard = Game.chessBoard;
    public Queen(int xp, int yp, boolean isWhite, LinkedList<Piece> ps)
    {
    super(xp,yp,isWhite,"queen", ps);
    }
    public Queen(String pos, boolean isWhite, LinkedList<Piece> ps)
    {
        super(pos, isWhite,"queen", ps);
    }


public String possibleMoves(int i){
    String list="",oldPiece;
    int r=i/8,c=i%8;
    int temp=1;
    for(int j=-1;j<=-1;j++) //these numbers talk about  direction, if both 1's then they move in a 45 degree angle
    {
        for(int k=-1;k<=1;k++)
        try{
            while(" ".equals(chessBoard[r+temp*j][c+temp*k])) //going in j,k direction
            {
                oldPiece=chessBoard[r+temp*j][c+temp*k];
                chessBoard[r][c]=" ";
                chessBoard[r+temp*j][c+temp*k] = " ";
                if (King.kingSafe()){
                    list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                }
                chessBoard[r][c]="Q";
                chessBoard[r+temp*j][c+temp*k]=oldPiece;
            }
            if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0)))
            {
                oldPiece=chessBoard[r+temp*j][c+temp*k];
                chessBoard[r][c]=" ";
                chessBoard[r+temp*j][c+temp*k]=" ";
                if (King.kingSafe()){
                    list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                }
                chessBoard[r][c]="Q";
                chessBoard[r+temp*j][c+temp*k]=oldPiece; 
            }
            

        } catch(Exception e){}
        temp=1;
    }
    return list;
}
}