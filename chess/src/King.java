import java.util.ArrayList;

/**
 * Created by simon on 31/03/15.
 */
public class King extends Piece {

    public King(int x, int y, int colour, Board board){
        super(PieceCode.KING, x, y, colour, board);
    }

    @Override
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

        //TODO: could this be done in one loop that checked all adjacent squares? Perhaps a method that returns adjacents would be good.


//        if(getBoard().outOfRange(x,y+1)
//                || getBoard().outOfRange(x+1,y)
//                || getBoard().outOfRange(x-1,y)
//                || getBoard().outOfRange(x+1,y+1)
//                || getBoard().outOfRange(x-1,y-1)
//                || getBoard().outOfRange(x-1,y+1)
//                || getBoard().outOfRange(x+1,y-1)){
//            return vector;
//        }
        //if you're returning an empty arraylist when there are no moves possible, there's no point to this I think?
        // Also it causes problems in it's current state - would need to check whether the move takes the King off the board,
        //not if *any* possible move takes it off the board.

        if(!getBoard().outOfRange(x,y+1)){
            if(getBoard().occupied(x,y+1) && (getBoard().getPiece(x,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x,y-1)){
            if(getBoard().occupied(x,y-1) && (getBoard().getPiece(x,y-1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x, y-1, true);
            }else{
                legalMove = new Move(this, x, y, x, y-1, false);
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

        if(!getBoard().outOfRange(x-1,y)){
            if(getBoard().occupied(x-1,y) && (getBoard().getPiece(x-1,y).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x-1, y, true);
            }else{
                legalMove = new Move(this, x, y, x-1, y, false);
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

//        if(vector.isEmpty()){
//            return null;
//        }

        return vector;
    }

    public ArrayList<Move> blackKing(){
        int x = getX();
        int y = getY();
        ArrayList<Move> vector = new ArrayList<>();
        Move legalMove;

//        if(getBoard().outOfRange(x,y+1)
//                || getBoard().outOfRange(x+1,y)
//                || getBoard().outOfRange(x-1,y)
//                || getBoard().outOfRange(x+1,y+1)
//                || getBoard().outOfRange(x-1,y-1)
//                || getBoard().outOfRange(x-1,y+1)
//                || getBoard().outOfRange(x+1,y-1)){
//            return null;
//        }



        if(!getBoard().outOfRange(x,y+1)){
            if(getBoard().occupied(x,y+1) && (getBoard().getPiece(x,y+1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x, y+1, true);
            }else{
                legalMove = new Move(this, x, y, x, y+1, false);
            }
            vector.add(legalMove);
        }

        if(!getBoard().outOfRange(x,y-1)){
            if(getBoard().occupied(x,y-1) && (getBoard().getPiece(x,y-1).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x, y-1, true);
            }else{
                legalMove = new Move(this, x, y, x, y-1, false);
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

        if(!getBoard().outOfRange(x-1,y)){
            if(getBoard().occupied(x-1,y) && (getBoard().getPiece(x-1,y).getColour() != this.getColour())){
                legalMove = new Move(this, x, y, x-1, y, true);
            }else{
                legalMove = new Move(this, x, y, x-1, y, false);
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
