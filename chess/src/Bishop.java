import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class Bishop extends Piece{

    public Bishop(int x, int y, int colour, Board board){
        super(PieceCode.BISHOP,x,y,colour,board);
    }

    public ArrayList<Move> availableMoves(){

    }
}
