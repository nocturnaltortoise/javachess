import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class King extends Piece {

    public King(int x, int y, int colour, Board board){
        super(PieceCode.KING, x, y, colour, board);
    }

    public ArrayList<Move> availableMoves(){
        if(getColour() == PieceCode.WHITE){
            return whiteKing();
        }else{
            return blackKing();
        }
    }

    public ArrayList<Move> whiteKing(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

        if(getBoard().outOfRange(x,y+1)
                || getBoard().outOfRange(x+1,y)
                || getBoard().outOfRange(x-1,y)
                || getBoard().outOfRange(x+1,y+1)
                || getBoard().outOfRange(x-1,y-1)
                || getBoard().outOfRange(x-1,y+1)
                || getBoard().outOfRange(x+1,y-1)){
            return null;
        }

        if(!getBoard().outOfRange(x,y+1)){
            if(getBoard().occupied(x,y+1) && (getBoard().getPiece(x,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x+1,y)){
            if(getBoard().occupied(x+1,y) && (getBoard().getPiece(x+1,y).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x+1, y, true);
            }else{
                legalMove = new Move(this, x, y, x+1, y, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x+1,y+1)){
            if(getBoard().occupied(x+1,y+1) && (getBoard().getPiece(x+1,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x+1, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x+1, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x-1,y+1)){
            if(getBoard().occupied(x-1,y+1) && (getBoard().getPiece(x-1,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x-1, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x-1, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x+1,y-1)){
            if(getBoard().occupied(x+1,y-1) && (getBoard().getPiece(x+1,y-1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x+1, y-1, true);
            }else{
                legalMove = new Move(this, x, y, x+1, y-1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x-1,y-1)){
            if(getBoard().occupied(x-1,y-1) && (getBoard().getPiece(x-1,y-1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x-1, y-1, true);
            }else{
                legalMove = new Move(this, x, y, x-1, y-1, false);
            }
            vector.add(legalMove);
        }

        if(vector.isEmpty()){
            return null;
        }

        return vector;
    }

    public ArrayList<Move> blackKing(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

        if(getBoard().outOfRange(x,y+1)
                || getBoard().outOfRange(x+1,y)
                || getBoard().outOfRange(x-1,y)
                || getBoard().outOfRange(x+1,y+1)
                || getBoard().outOfRange(x-1,y-1)
                || getBoard().outOfRange(x-1,y+1)
                || getBoard().outOfRange(x+1,y-1)){
            return null;
        }

        if(!getBoard().outOfRange(x,y+1)){
            if(getBoard().occupied(x,y+1) && (getBoard().getPiece(x,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x+1,y)){
            if(getBoard().occupied(x+1,y) && (getBoard().getPiece(x+1,y).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x+1, y, true);
            }else{
                legalMove = new Move(this, x, y, x+1, y, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x+1,y+1)){
            if(getBoard().occupied(x+1,y+1) && (getBoard().getPiece(x+1,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x+1, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x+1, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x-1,y+1)){
            if(getBoard().occupied(x-1,y+1) && (getBoard().getPiece(x-1,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x-1, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x-1, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x+1,y-1)){
            if(getBoard().occupied(x+1,y-1) && (getBoard().getPiece(x+1,y-1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x+1, y-1, true);
            }else{
                legalMove = new Move(this, x, y, x+1, y-1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x-1,y-1)){
            if(getBoard().occupied(x-1,y-1) && (getBoard().getPiece(x-1,y-1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x-1, y-1, true);
            }else{
                legalMove = new Move(this, x, y, x-1, y-1, false);
            }
            vector.add(legalMove);
        }

        if(vector.isEmpty()){
            return null;
        }

        return vector;
    }

}
