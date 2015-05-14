package uk.ac.sheffield.aca14st;

/**@author Simon Turner (aca14st) */

public class HumanPlayer extends Player{

    static int[][] move = GraphicalDisplay.getClickCoordinates();

    public HumanPlayer(String n, Pieces p, Board b, Player o){
        super(n, p, b, o);
    }

    //Makes a move inputted by the player. Returns true when the player takes the king.
    @Override
    public boolean makeMove(){
        boolean legalMove = false;
        boolean kingTaken = false;

        waitForMove();
        //checks whether the user's grid references are valid inputs.
        while(!legalMove && GraphicalDisplay.getUserState() == UserState.FINISHED_CLICKING){

            int initX = move[0][0];
            int initY = move[0][1];
            int newX = move[1][0];
            int newY = move[1][1];

            System.out.println("In HumanPlayer: " + initX + "," + initY + "," + newX + "," + newY);

            //check whether the target square is occupied.
            boolean targetOccupied = getBoard().occupied(newX, newY);

            //if taking a piece, check whether the piece is a king.
            if(targetOccupied){
//                kingTaken = PieceCode.charToInt(getBoard().getPiece(newX, newY).getChar()) == PieceCode.KING;
                kingTaken = this.getBoard().getPiece(newX, newY) instanceof King;
            }

            Piece movingPiece = getBoard().getPiece(initX, initY);
            Move playerMove = new Move(movingPiece, initX, initY, newX, newY, targetOccupied, this.getBoard());

            //Make sure that there is a piece on the square the player has inputted.
            if(movingPiece == null){
                GraphicalDisplay.setUserState(UserState.NOT_CLICKING);
                System.out.println("Enter a valid move. (Moving piece is null)");
                legalMove = false;
                waitForMove();
                continue;
            }

            /*
             *If the moving piece has the suggested move in it's legal moves, and belongs to the player moving it, move the piece.
             *If there's an opposite colour piece under the target, take that piece. If the move isn't legal, prompt the user to enter
             *another move.
             */

            System.out.println(movingPiece.availableMoves());
            if(movingPiece.availableMoves().contains(playerMove) && movingPiece.getColour() == this.getPieces().getColour()){
                if(targetOccupied && getBoard().getPiece(newX, newY).getColour() != getBoard().getPiece(initX, initY).getColour()){
                    getBoard().remove(newX, newY);
                }
                getBoard().getData()[newX][newY] = movingPiece;
                movingPiece.setPosition(newX, newY);
                getBoard().remove(initX, initY);
                legalMove = true;
            }else{
                GraphicalDisplay.setUserState(UserState.NOT_CLICKING);
                System.out.println("Move is not legal. Enter a legal move." + GraphicalDisplay.getUserState());
                legalMove = false;
                waitForMove();
            }
        }

        GraphicalDisplay.setUserState(UserState.NOT_CLICKING);
        return kingTaken;

    }

    private static void waitForMove(){
        while(GraphicalDisplay.getUserState() != UserState.FINISHED_CLICKING) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException interrupt) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
