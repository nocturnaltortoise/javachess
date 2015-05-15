package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**
 * Bishop
 * Class to represent a Bishop piece in Chess.
 * @author Simon Turner (aca14st)
 */

public class Bishop extends Piece{

    static boolean blocked = false;

    public Bishop(int x, int y, int colour, Board board){
        //Calls the uk.ac.sheffield.aca14st.Piece constructor with the char symbol for the bishop
        //as well as the other details fed into the uk.ac.sheffield.aca14st.Bishop's constructor.
        super(PieceCode.BISHOP,x,y,colour,board);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        return bishop();
    }

    //bishop's legal moves account for half of the queen's legal moves (the diagonals).
    public ArrayList<Move> bishop(){
        blocked = false;
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();

        /*
         *Each of these blocks defines a different diagonal move -
         *the length of the diagonal depends on whether the piece is blocked by another piece.
         */

        //top right
        blocked = false;
        for(int i=getX()+1, j=getY()+1; (i<8 || j<8) && !blocked; i++,j++) {
            checkSquares(getX(), getY(), i, j, vector);
        }

        //bottom left
        blocked = false;
        for(int i=getX()-1, j=getY()-1; (i>-1 || j>-1) && !blocked; i--,j--){
            checkSquares(getX(), getY(), i,j, vector);

        }

        //bottom right
        blocked = false;
        for(int i=getX()+1, j=getY()-1 ;(i<8 || j>-1) && !blocked; i++,j--){
            checkSquares(getX(), getY(), i,j, vector);
        }

        //top left
        blocked = false;
        for(int i=getX()-1, j=getY()+1 ;(i>-1 || j<8) && !blocked; i--,j++){
            checkSquares(getX(), getY(), i,j, vector);
        }

        return vector;
    }

    //The key difference here between this method and King or Knight's equaivalent is a boolean flag to stop the piece jumping another.
    private void checkSquares(int x, int y, int nextX, int nextY, ArrayList<Move> vector){
        Move legalMove = null;
        if(!getBoard().outOfRange(nextX,nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true, this.getBoard());
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false, this.getBoard());
            }else{
                blocked = true;
            }

            if(legalMove != null){
                vector.add(legalMove);
            }
        }
    }
}
