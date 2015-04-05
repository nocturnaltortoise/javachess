import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */

public class Knight extends Piece {

    public Knight(int x, int y, int colour, Board b){
        super(PieceCode.KNIGHT, x, y, colour, b);
    }

    public ArrayList<Move> availableMoves(){
        return null;
    }

    public ArrayList<Move> whiteKnight(){

    }

    public ArrayList<Move> blackKnight(){

    }
}
