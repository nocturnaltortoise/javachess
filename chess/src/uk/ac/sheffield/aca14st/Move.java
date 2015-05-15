package uk.ac.sheffield.aca14st;

/**
 * Move
 * Represents a move of a piece from one square to another.
 * @author Simon Turner (aca14st)
 */

public class Move implements Comparable<Move>{

    private Piece piece;
    private int currentXPosition;
    private int currentYPosition;
    private int newXPosition;
    private int newYPosition;
    private boolean isOccupied;
    private int value;

    //Each move consists of a moving piece, it's original position, new position, and whether the new position is occupied.
    public Move(Piece p, int currentX, int currentY, int newX, int newY, boolean occupied, Board board){
        piece = p;
        currentXPosition = currentX;
        currentYPosition = currentY;
        newXPosition = newX;
        newYPosition = newY;
        isOccupied = occupied;
        if(isOccupied){
            value = getPieceValue(board.getPiece(newXPosition, newYPosition));
        }else{
            value = 0;
        }

    }

    //Returns the moving piece.
    public Piece getPiece() {
        return piece;
    }

    public int getCurrentXPosition(){
        return currentXPosition;
    }

    public int getCurrentYPosition(){
        return currentYPosition;
    }

    public int getNewXPosition(){
        return newXPosition;
    }

    public int getNewYPosition(){
        return newYPosition;
    }

    public boolean targetIsOccupied(){
        return isOccupied;
    }

    public int getValue(){
        return value;
    }

    public int compareTo(Move moveTwo){
        Integer valueOne = this.getValue();
        Integer valueTwo = moveTwo.getValue();
        return valueOne.compareTo(valueTwo);
    }

    //returns the conventional value of a piece in chess.
    private int getPieceValue(Piece piece){
        switch(piece.getChar()){
            case 'p':
            case 'P':
                return 1;
            case 'r':
            case 'R':
                return 5;
            case 'n':
            case 'N':
                return 3;
            case 'b':
            case 'B':
                return 3;
            case 'q':
            case 'Q':
                return 9;
            case 'k':
            case 'K':
                return 10; //King not usually given a value in chess, could be anything higher than 9.
            default:
                return 0;
        }
    }

    //Returns some basic info about a move - mostly useful for debugging.
    public String toString(){
        return "Piece: " + piece.toString()
                + " Moving from: " + currentXPosition + ", " + currentYPosition
                + " To: " + newXPosition + ", " + newYPosition
                + " Target Occupied? " + isOccupied;
    }

    //Checks whether one move is equal to another.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (currentXPosition != move.currentXPosition) return false;
        if (currentYPosition != move.currentYPosition) return false;
        if (newXPosition != move.newXPosition) return false;
        if (newYPosition != move.newYPosition) return false;
        if (isOccupied != move.isOccupied) return false;
        return piece == move.piece;
    }

    @Override
    public int hashCode() {
        int result = piece.hashCode();
        result = 31 * result + currentXPosition;
        result = 31 * result + currentYPosition;
        result = 31 * result + newXPosition;
        result = 31 * result + newYPosition;
        result = 31 * result + (isOccupied ? 1 : 0);
        return result;
    }
}
