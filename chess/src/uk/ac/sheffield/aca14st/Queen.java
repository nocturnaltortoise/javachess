package uk.ac.sheffield.aca14st;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(int x, int y, int colour, Board b){
        //Calls the uk.ac.sheffield.aca14st.Piece constructor with the char symbol for the queen
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
        Move legalMove = null;
        ArrayList<Move> vector = new ArrayList<>();

        //The queen's moves are the moves of the uk.ac.sheffield.aca14st.Rook and the uk.ac.sheffield.aca14st.Bishop. These loops are identical to those.
        int nextX = getX()+1;
        int nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextX++;
        }

        nextX = getX();
        nextY = getY()+1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextY++;
        }

        nextX = getX()-1;
        nextY = getY();

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextX--;
        }

        nextX = getX();
        nextY = getY()-1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextY--;
        }

        nextX = getX() + 1;
        nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextX++;
            nextY++;
        }

        nextX = getX() - 1;
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextX--;
            nextY--;
        }

        nextX = getX() + 1;
        nextY = getY() - 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextX++;
            nextY--;
        }

        nextX = getX() - 1;
        nextY = getY() + 1;

        while(!getBoard().outOfRange(nextX, nextY)){
            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() != this.getColour()){
                legalMove = new Move(this, x, y, nextX, nextY, true);
            }

            if(getBoard().occupied(nextX, nextY) && getBoard().getPiece(nextX, nextY).getColour() == this.getColour()){
                break;
            }

            if(!getBoard().occupied(nextX, nextY)){
                legalMove = new Move(this, x, y, nextX, nextY, false);
            }

            vector.add(legalMove);
            nextX--;
            nextY++;
        }

        return vector;
    }
}
