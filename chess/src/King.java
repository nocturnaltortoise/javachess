import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class King extends Piece {

    public King(int x, int y, int colour, Board board){
        super(PieceCode.KING, x, y, colour, board);
    }

    public ArrayList<Move> availableMoves(){
        if(getColour() == PieceCode.WHITE){
            return whiteKing();
        }else{
            return blackKing();
        }
    }

    public ArrayList<Move> whiteKing(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();


    }

    public ArrayList<Move> blackKing(){

    }

}
