package uk.ac.sheffield.aca14st;

/**@author Simon Turner (aca14st) */

public class Move {

    private Piece piece;
    private int currentXPosition;
    private int currentYPosition;
    private int newXPosition;
    private int newYPosition;
    private boolean isOccupied;

    //Each move consists of a moving piece, it's original position, new position, and whether the new position is occupied.
    public Move(Piece p, int currentX, int currentY, int newX, int newY, boolean occupied){
        piece = p;
        currentXPosition = currentX;
        currentYPosition = currentY;
        newXPosition = newX;
        newYPosition = newY;
        isOccupied = occupied;
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
