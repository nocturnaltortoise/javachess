import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(int x, int y, int colour, Board board){
        super(PieceCode.BISHOP,x,y,colour,board);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        return bishop();
    }

    //bishop's legal moves account for half of the queen's legal moves (the diagonals).
    public ArrayList<Move> bishop(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove = null;

        int nextX = getX() + 1;
        int nextY = getY() + 1;

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
