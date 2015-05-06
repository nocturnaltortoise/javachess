package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

/**@author Simon Turner (aca14st) */

public class Rook extends Piece {

    public Rook(int x, int y, int colour, Board board){
        //Calls the uk.ac.sheffield.aca14st.Piece constructor with the char symbol for the rook
        //as well as the other details fed into the uk.ac.sheffield.aca14st.Rook's constructor.
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
        Move legalMove = null;
        ArrayList<Move> vector = new ArrayList<>();

        /*
         *Each of these loops works similarly to the bishop, but only incrementing or decrementing either x or y,
         *rather than both, as the uk.ac.sheffield.aca14st.Rook moves along the rank and file. As the rook can't jump, once again the loop will
         *break either when it finds a friendly piece, or it will add a legal move when it can take an enemy piece (or if the square
         *is unoccupied).
         */
        int nextX = getX()+1;
        int nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true, this.getBoard());
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false, this.getBoard());
            }

            vector.add(legalMove);
            nextX++;
        }

        nextX = getX();
        nextY = getY()+1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true, this.getBoard());
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false, this.getBoard());
            }

            vector.add(legalMove);
            nextY++;
        }

        nextX = getX()-1;
        nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true, this.getBoard());
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false, this.getBoard());
            }

            vector.add(legalMove);
            nextX--;
        }

        nextX = getX();
        nextY = getY()-1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true, this.getBoard());
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false, this.getBoard());
            }

            vector.add(legalMove);
            nextY--;
        }

        return vector;
    }

}
