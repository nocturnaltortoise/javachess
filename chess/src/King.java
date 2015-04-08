import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class King extends Piece {

    public King(int x, int y, int colour, Board board){
        super(PieceCode.KING, x, y, colour, board);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        return king();
    }

    public ArrayList<Move> king(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();

        checkSquares(x,y,getX(),getY()+1,vector);
        checkSquares(x,y,getX(),getY()-1,vector);
        checkSquares(x,y,getX()+1,getY(),vector);
        checkSquares(x,y,getX()+1,getY()+1,vector);
        checkSquares(x,y,getX()+1,getY()-1,vector);
        checkSquares(x,y,getX()-1,getY()-1,vector);
        checkSquares(x,y,getX()-1,getY()+1,vector);
        checkSquares(x,y,getX()-1,getY(),vector);

        return vector;
    }

    private void checkSquares(int x, int y, int nextX, int nextY, ArrayList<Move> vector){
        Move legalMove = null;
        if(!getBoard().outOfRange(nextX,nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
        }
    }
}
