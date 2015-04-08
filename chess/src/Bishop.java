import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class Bishop extends Piece{

    public Bishop(int x, int y, int colour, Board board){
        super(PieceCode.BISHOP,x,y,colour,board);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        if(getColour() == PieceCode.WHITE){
            return whiteBishop();
        }else{
            return blackBishop();
        }
    }

    //TODO: perhaps refactor so a method returns an array of all the diagonals, and this merely checks them.
    public ArrayList<Move> whiteBishop(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

        int nextX = getX() + 1;
        int nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            System.out.println(nextX + ":" + nextY);
            nextX++;
            nextY++;
        }

        nextX = getX() - 1;
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY--;
        }

        nextX = getX() + 1;
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY--;
        }

        nextX = getX() - 1;
        nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            System.out.println(nextX + ":" + nextY);
            nextX--;
            nextY++;
        }

        return vector;
    }

    public ArrayList<Move> blackBishop(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

        int nextX = getX() + 1;
        int nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY++;

        }

        nextX = getX() - 1;
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY--;
        }

        nextX = getX() + 1;
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
            nextY--;

        }

        nextX = getX() - 1;
        nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
            nextY++;
        }

        return vector;
    }
}
