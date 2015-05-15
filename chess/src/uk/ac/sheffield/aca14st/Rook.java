package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**@author Simon Turner (aca14st) */

public class Rook extends Piece {

    static boolean blocked = false;

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

        //vertically upwards
        for(int i=x+1;i<8 && !blocked;i++){
            checkSquares(x, y, i,y, vector);
        }

        //vertically downwards
        blocked = false;
        for(int i=x-1;i>-1 && !blocked;i--){
            checkSquares(x, y,i,y, vector);
        }

        //horizontally to the right
        blocked = false;
        for(int i=y+1;i<8 && !blocked;i++){
            checkSquares(x, y, x,i, vector);
        }

        //horizontally to the left
        blocked = false;
        for(int i=y-1;i>-1 && !blocked;i--){
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

            if(!getBoard().occupied(nextX, nextY)) {
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
