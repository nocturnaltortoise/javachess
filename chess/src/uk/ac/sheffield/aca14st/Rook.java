package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**@author Simon Turner (aca14st) */

public class Rook extends Piece {

    public Rook(int x, int y, int colour, Board board){
        //Calls the Piece constructor with the char symbol for the rook
        //as well as the other details fed into the Rook's constructor.
        super(PieceCode.ROOK, x, y, colour, board);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        return rook();
    }

    //the rook's legal moves account for half the queen's legal moves (the rank and file).
    public ArrayList<Move> rook(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();

        for(int i=x;i<8;i++){
            checkSquares(x, y, i,y, vector);
        }

        for(int i=x;i>0;i--){
            checkSquares(x, y,i,y, vector);
        }

        for(int i=y;i<8;i++){
            checkSquares(x, y, x,i, vector);
        }

        for(int i=y;i>0;i--){
            checkSquares(x, y, x,i, vector);
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
