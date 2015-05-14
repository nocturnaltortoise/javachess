package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**@author Simon Turner (aca14st) */

public class Queen extends Piece {

    public Queen(int x, int y, int colour, Board b){
        //Calls the Piece constructor with the char symbol for the queen
        //as well as the other details fed into the uk.ac.sheffield.aca14st.Queen's constructor.
        super(PieceCode.QUEEN, x, y, colour, b);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        return queen();
    }

    public ArrayList<Move> queen(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();

        //The queen's moves are the moves of the Rook and the Bishop. These loops are identical to those.

        //vertically upwards
        for(int i=x;i<8;i++){
            checkSquares(x, y, i,y, vector);
        }
        //vertically downwards
        for(int i=x;i>0;i--){
            checkSquares(x, y,i,y, vector);
        }
        //horizontally to the right
        for(int i=y;i<8;i++){
            checkSquares(x, y, x,i, vector);
        }
        //horizontally to the left
        for(int i=y;i>0;i--){
            checkSquares(x, y, x,i, vector);
        }

        //+1.+1
        for(int i=getX()+1, j=getY()+1; i<8 || j<8; i++,j++) {
            checkSquares(getX(), getY(), i, j, vector);
        }

        //-1,-1
        for(int i=getX()-1, j=getY()-1; i>-1 || j>-1; i--,j--){
            checkSquares(getX(), getY(), i,j, vector);

        }

        //+1,-1
        for(int i=getX()+1, j=getY()-1 ;i<8 || j>-1; i++,j--){
            checkSquares(getX(), getY(), i,j, vector);
        }

        //-1,+1
        for(int i=getX()-1, j=getY()+1 ;i>-1 || j<8; i--,j++){
            checkSquares(getX(), getY(), i,j, vector);
        }

        return vector;
    }

    private void checkSquares(int x, int y, int nextX, int nextY, ArrayList<Move> vector){
        Move legalMove = null;
        if(!getBoard().outOfRange(nextX,nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true, this.getBoard());
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false, this.getBoard());
            }

            if(legalMove != null){
                vector.add(legalMove);
            }
        }
    }
}
