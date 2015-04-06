/**
 * Created by simon on 31/03/15.
 */
public class Move {

    private Piece piece;
    private int currentXPosition;
    private int currentYPosition;
    private int newXPosition;
    private int newYPosition;
    private boolean isOccupied;

    public Move(Piece p, int currentX, int currentY, int newX, int newY, boolean occupied){
        piece = p;
        currentXPosition = currentX;
        currentYPosition = currentY;
        newXPosition = newX;
        newYPosition = newY;
        isOccupied = occupied;
    }

    //not sure whether I need setters for this class - add them later as you need them

    public Piece getPiece() {
        return piece;
    }

    public int getCurrentXPosition() {
        return currentXPosition;
    }

    public int getCurrentYPosition() {
        return currentYPosition;
    }

    public int getNewXPosition() {
        return newXPosition;
    }

    public int getNewYPosition() {
        return newYPosition;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String toString(){
        return "Piece: " + piece.toString()
                + " Moving from: " + currentXPosition + ", " + currentYPosition
                + " To: " + newXPosition + ", " + newYPosition
                + " Target Occupied? " + isOccupied;
    }

}
