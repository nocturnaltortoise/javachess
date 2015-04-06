import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */

public class Queen extends Piece {

    public Queen(int x, int y, int colour, Board b){
        super(PieceCode.QUEEN, x, y, colour, b);
    }

    public ArrayList<Move> availableMoves(){
        return null;
    }

    public ArrayList<Move> whiteQueen(){
        return null;
    }

    public ArrayList<Move> blackQueen(){
        return null;
    }
}
