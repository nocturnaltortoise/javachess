package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**@author Simon Turner (aca14st) */

public class Knight extends Piece {

    public Knight(int x, int y, int colour, Board b){
        //Calls the Piece constructor with the char symbol for the knight
        //as well as the other details fed into the Knight's constructor.
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

        //array of possible target squares for the Knight.
        int[][] directions = {
                {getX()-1,getY()+2},
                {getX()+1,getY()+2},
                {getX()+1,getY()-2},
                {getX()-1,getY()-2},
                {getX()+2,getY()+1},
                {getX()+2,getY()-1},
                {getX()-2,getY()+1},
                {getX()-2,getY()-1}
        };

        //Each of these checks a different destination square for the knight (we don't care about what it jumps over).
        for(int i=0; i<8; i++){
            checkSquares(x,y,directions[i][0],directions[i][1],vector);
        }

        return vector;
    }

    //Similar to the method in King, checks a square for occupation, being off the board - adds a move if it's legal.
    private void checkSquares(int x, int y, int nextX, int nextY, ArrayList<Move> vector){
        Move legalMove = null;
        if(!getBoard().outOfRange(nextX,nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            if(legalMove != null){
                vector.add(legalMove);
            }
        }
    }
}
