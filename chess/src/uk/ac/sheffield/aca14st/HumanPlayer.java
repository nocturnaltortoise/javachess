package uk.ac.sheffield.aca14st;

/**
 * HumanPlayer
 * Checks validity of moves for human players (as opposed to AI).
 * @author Simon Turner (aca14st)
 */

public class HumanPlayer extends Player{

    static int[][] move = ChessBoard.getClickCoordinates();

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
        while(!legalMove && ChessBoard.getUserState() == UserState.FINISHED_CLICKING){

            int initX = move[0][0];
            int initY = move[0][1];
            int newX = move[1][0];
            int newY = move[1][1];

            //check whether the target square is occupied.
            boolean targetOccupied = getBoard().occupied(newX, newY);

            //if taking a piece, check whether the piece is a king.
            if(targetOccupied){
                kingTaken = this.getBoard().getPiece(newX, newY) instanceof King;
            }

            Piece movingPiece = getBoard().getPiece(initX, initY);
            Move playerMove = new Move(movingPiece, initX, initY, newX, newY, targetOccupied, this.getBoard());

            //Make sure that there is a piece on the square the player has inputted.
            if(movingPiece == null){
                ChessBoard.setUserState(UserState.NOT_CLICKING);
                InfoPanel.getAlertLabel().setText("There's no piece there. Select a valid piece.");
                legalMove = false;
                waitForMove();
                continue;
            }

            /*
             *If the moving piece has the suggested move in it's legal moves, and belongs to the player moving it, move the piece.
             *If there's an opposite colour piece under the target, take that piece. If the move isn't legal, prompt the user to enter
             *another move.
             */

            if(movingPiece.availableMoves().contains(playerMove) && movingPiece.getColour() == this.getPieces().getColour()){
                if(targetOccupied && getBoard().getPiece(newX, newY).getColour() != getBoard().getPiece(initX, initY).getColour()){
                    super.getTakenPieces().add(getBoard().getPiece(newX, newY));
                    InfoPanel.getTakenPieceLabel().setText(super.takenPiecesToString(getTakenPieces()));
                    getBoard().remove(newX, newY);
                }
                getBoard().getData()[newX][newY] = movingPiece;
                movingPiece.setPosition(newX, newY);
                getBoard().remove(initX, initY);
                legalMove = true;
                InfoPanel.getAlertLabel().setText("");
            }else{
                ChessBoard.setUserState(UserState.NOT_CLICKING);
                InfoPanel.getAlertLabel().setText("Move is not legal. Enter a legal move.");
                legalMove = false;
                waitForMove();
            }
        }

        ChessBoard.setUserState(UserState.NOT_CLICKING);
        return kingTaken;

    }

    private static void waitForMove(){
        while(ChessBoard.getUserState() != UserState.FINISHED_CLICKING) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interrupt) {
                System.err.println(interrupt);
                Thread.currentThread().interrupt();
            }
        }
    }

}
