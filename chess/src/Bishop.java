import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class Bishop extends Piece{

    public Bishop(int x, int y, int colour, Board board){
        super(PieceCode.BISHOP,x,y,colour,board);
    }

    public ArrayList<Move> availableMoves(){
        if(getColour() == PieceCode.WHITE){
            return whiteBishop();
        }else{
            return blackBishop();
        }
    }

    //gonna need some kind of loop (while?) to check squares on diagonals up to board edges/occupied square
    public ArrayList<Move> whiteBishop(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

        int nextX = x;
        int nextY = y;

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY++;
        }

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY--;
        }

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY--;
        }

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY++;
        }

        if(vector.isEmpty()){
            return null;
        }

        return vector;
    }

    public ArrayList<Move> blackBishop(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

        int nextX = x;
        int nextY = y;

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY++;
        }

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY--;
        }

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY--;
        }

        while(!getBoard().outOfRange(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK){
            if(getBoard().occupied(nextX, nextY)) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY++;
        }

        if(vector.isEmpty()){
            return null;
        }

        return vector;
    }
}
