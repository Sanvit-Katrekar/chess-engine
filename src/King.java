import java.util.LinkedList;

public class King extends Piece {
    public static String[][] chessBoard = Game.chessBoard;
    public King(int xp, int yp, boolean isWhite, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, "king", ps);
    }

    public King(String pos, boolean isWhite, LinkedList<Piece> ps){
        super(pos, isWhite, "king", ps);
    }
    /*
    public static void main(String[] args) {
        while (!"A".equals(chessBoard[kingPositionC/8][kingPositionC%8])) {kingPositionC++;}//get King's location
        while (!"a".equals(chessBoard[kingPositionL/8][kingPositionL%8])) {kingPositionL++;}//get king's location
        System.out.println(possibleMoves());
    }
    */
    static int kingPositionC, kingPositionL;
    
    public String possibleMoves(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        for (int j=0; j<9; j++) {
            if (j!=4) {
                try {
                    if (Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(chessBoard[r-1+j/3][c-1+j%3])) {
                        oldPiece=chessBoard[r-1+j/3][c-1+j%3];
                        chessBoard[r][c]=" ";
                        chessBoard[r-1+j/3][c-1+j%3]="A";
                        int kingTemp=kingPositionC;
                        kingPositionC=i+(j/3)*8+j%3-9;
                        if (kingSafe()) {
                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
                        }
                        chessBoard[r][c]="A";
                        chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
                        kingPositionC=kingTemp;
                    }
                } catch (Exception e) {}
            }
        }
        //need to add casting later
        return list;
    }
        
    /*
    public static String possibleMoves() {
        String list="";
        for (int i=0; i<64; i++) {
            switch (chessBoard[i/8][i%8]) {
                case "P": list+=posibleP(i);
                    break;
                case "R": list+=posibleR(i);
                    break;
                case "K": list+=posibleK(i);
                    break;
                case "B": list+=posibleB(i);
                    break;
                case "Q": list+=posibleQ(i);
                    break;
                case "A": list+=posibleA(i);
                    break;
            }
        }
        return list;//x1,y1,x2,y2,captured piece
    }
    */
    public static boolean kingSafe() {
        //bishop/queen
        int temp=1;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j])) {temp++;}
                    if ("b".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j]) ||
                            "q".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        //rook/queen
        for (int i=-1; i<=1; i+=2) {
            try {
                while(" ".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i])) {temp++;}
                if ("r".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i]) ||
                        "q".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8])) {temp++;}
                if ("r".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8]) ||
                        "q".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
        }
        //knight
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    if ("k".equals(chessBoard[kingPositionC/8+i][kingPositionC%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {}
                try {
                    if ("k".equals(chessBoard[kingPositionC/8+i*2][kingPositionC%8+j])) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        //pawn
        if (kingPositionC>=16) {
            try {
                if ("p".equals(chessBoard[kingPositionC/80-1][kingPositionC%8-1])) {
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("p".equals(chessBoard[kingPositionC/80-1][kingPositionC%8+1])) {
                    return false;
                }
            } catch (Exception e) {}
            //king
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (i!=0 || j!=0) {
                        try {
                            if ("a".equals(chessBoard[kingPositionC/8+i][kingPositionC%8+j])) {
                                return false;
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return true;
    }

    
    
}