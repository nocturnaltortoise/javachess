package uk.ac.sheffield.aca14st;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Aggressive Player
 * Class for the aggressive version of the AI.
 * @author Simon Turner (aca14st)
 */
public class AggressivePlayer extends Player{

    public AggressivePlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        boolean kingTaken = false;

        Move aggressiveMove = getAggressiveMove(this.getPieces());
        int initX = aggressiveMove.getCurrentXPosition();
        int initY = aggressiveMove.getCurrentYPosition();
        int newX = aggressiveMove.getNewXPosition();
        int newY = aggressiveMove.getNewYPosition();
        Piece movingPiece = aggressiveMove.getPiece();
        //Sets up the moving piece and the move it will make.

        //if the target is occupied, take the target piece and move, otherwise just move.
        if(aggressiveMove.targetIsOccupied()){
            kingTaken = this.getBoard().getPiece(newX, newY) instanceof King;
            //adds taken piece to a list and updates the label displaying the list.
            super.getTakenPieces().add(getBoard().getPiece(newX, newY));
            InfoPanel.getTakenPieceLabel().setText(super.takenPiecesToString(getTakenPieces()));
            this.getBoard().remove(newX, newY);
            movingPiece.setPosition(newX, newY);
            this.getBoard().getData()[newX][newY] = movingPiece;
            this.getBoard().remove(initX, initY);
        }else{
            this.getBoard().getData()[newX][newY] = movingPiece;
            movingPiece.setPosition(newX, newY);
            this.getBoard().remove(initX, initY);
        }

        //Makes the AI take more time so the game isn't over immediately.
        try{
           Thread.sleep(1500);
        }catch(InterruptedException interrupt){
           Thread.currentThread().interrupt();
        }

        ChessBoard.setUserState(UserState.FINISHED_CLICKING);

        return kingTaken;
    }

    //Gets the highest value capturing move, or a random move if piece can't capture.
    private Move getAggressiveMove(Pieces pieces){

        ArrayList<Move> takingMoves = new ArrayList<>();

        for(Piece possiblePiece : pieces.getData()){
            for(Move possibleMove : possiblePiece.availableMoves()) {
                if (possibleMove.targetIsOccupied()) {
                    takingMoves.add(possibleMove);
                }
            }
        }

        Collections.sort(takingMoves);

        if(!takingMoves.isEmpty() && takingMoves.size() > 0){
            return takingMoves.get(0);
        }else{
            return getRandomMove(getRandomPiece(this), this);
        }

    }

    //Gets a random move for a piece. If the random piece has no available moves, pick another piece.
    private Move getRandomMove(Piece randomPiece, Player player){

        Random randNumGen = new Random();

        while(randomPiece.availableMoves().isEmpty()){
            randomPiece = getRandomPiece(player);
        }

        return randomPiece.availableMoves().get(randNumGen.nextInt(randomPiece.availableMoves().size()));

    }

    //Generates a random number, selects a random friendly piece or a random hostile piece.
    private Piece getRandomPiece(Player player){

        Random randNumGen = new Random();

        if(player == this){
            return this.getPieces().getPiece(randNumGen.nextInt(this.getPieces().getNumPieces()));
        }else{
            return this.getOpponent().getPieces().getPiece(randNumGen.nextInt(this.getPieces().getNumPieces()));
        }

    }
}
