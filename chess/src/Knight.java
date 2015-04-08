import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */

public class Knight extends Piece {

    public Knight(int x, int y, int colour, Board b){
        super(PieceCode.KNIGHT, x, y, colour, b);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        return knight();
    }

    public ArrayList<Move> knight(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();

        checkSquares(x,y,getX()-1,getY()+2,vector);
        checkSquares(x,y,getX()+1,getY()+2,vector);
        checkSquares(x,y,getX()+1,getY()-2,vector);
        checkSquares(x,y,getX()-1,getY()-2,vector);
        checkSquares(x,y,getX()+2,getY()+1,vector);
        checkSquares(x,y,getX()+2,getY()-1,vector);
        checkSquares(x,y,getX()-2,getY()+1,vector);
        checkSquares(x,y,getX()-2,getY()-1,vector);

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
