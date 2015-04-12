package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**@author Simon Turner (aca14st) */

public class King extends Piece {

    public King(int x, int y, int colour, Board board){
        //Calls the uk.ac.sheffield.aca14st.Piece constructor with the char symbol for the king
        //as well as the other details fed into the uk.ac.sheffield.aca14st.King's constructor.
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

        //Each of these method calls checks a different adjacent square.
        checkSquares(x,y,getX(),getY()+1,vector);
        checkSquares(x,y,getX(),getY()-1,vector);
        checkSquares(x,y,getX()+1,getY(),vector);
        checkSquares(x,y,getX()+1,getY()+1,vector);
        checkSquares(x,y,getX()+1,getY()-1,vector);
        checkSquares(x,y,getX()-1,getY()-1,vector);
        checkSquares(x,y,getX()-1,getY()+1,vector);
        checkSquares(x,y,getX()-1,getY(),vector);

        //if none of these squares are valid, an empty arraylist will be returned,
        //so no inputted move by the user will be contained.
        return vector;
    }

    /*
     *Checks an inputted square to see whether the square is occupied or out of range,
     *and adds a different legal move to the arraylist depending on that.
     */
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
