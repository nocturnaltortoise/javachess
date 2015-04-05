import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class Bishop extends Piece{

    public Bishop(int x, int y, int colour, Board board){
        super(PieceCode.BISHOP,x,y,colour,board);
    }

    public ArrayList<Move> availableMoves(){
        return null;
    }

    //gonna need some kind of loop (while?) to check squares on diagonals up to board edges/occupied square
    public ArrayList<Move> whiteBishop(){

    }

    public ArrayList<Move> blackBishop(){

    }
}
