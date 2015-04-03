import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class Rook extends Piece {

    public Rook(int x, int y, int colour, Board board){
        super(PieceCode.ROOK, x, y, colour, board);
    }

    public ArrayList<Move> availableMoves(){
        return null;
    }

}
