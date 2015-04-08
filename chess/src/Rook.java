import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class Rook extends Piece {

    public Rook(int x, int y, int colour, Board board){
        super(PieceCode.ROOK, x, y, colour, board);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        if(getColour() == PieceCode.WHITE){
            return whiteRook();
        }else{
            return blackRook();
        }
    }

    public ArrayList<Move> whiteRook(){
        int x = getX();
        int y = getY();
        Move legalMove;
        ArrayList<Move> vector = new ArrayList<>();

        int nextX = getX() + 1;
        int nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
        }

        nextX = getX();
        nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextY++;
        }

        nextX = getX() - 1;
        nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
        }

        nextX = getX();
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.WHITE) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextY--;
        }

        return vector;
    }

    public ArrayList<Move> blackRook(){
        int x = getX();
        int y = getY();
        Move legalMove;
        ArrayList<Move> vector = new ArrayList<>();

        int nextX = getX() + 1;
        int nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX++;
        }

        nextX = getX();
        nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextY++;
        }

        nextX = getX() - 1;
        nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextX--;
        }

        nextX = getX();
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != PieceCode.BLACK) {
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }else{
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }
            vector.add(legalMove);
            nextY--;
        }

        return vector;
    }

}
