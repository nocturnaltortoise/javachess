package uk.ac.sheffield.aca14st;

import java.util.Random;

/**
 * RandomPlayer
 * Implements the random moves of the Random AI.
 * @author Simon Turner (aca14st)
 */

public class RandomPlayer extends Player{

    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        boolean kingTaken = false;

        //Very Similar to AggressivePlayer, except our move is always random (no middleman method to
        //check for better moves).
        Move randomMove = getRandomMove(getRandomPiece(this), this);
        int initX = randomMove.getCurrentXPosition();
        int initY = randomMove.getCurrentYPosition();
        int newX = randomMove.getNewXPosition();
        int newY = randomMove.getNewYPosition();
        Piece movingPiece = randomMove.getPiece();

        if(randomMove.targetIsOccupied()){
            kingTaken = this.getBoard().getPiece(newX, newY) instanceof King;
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

        try{
            Thread.sleep(1500);
        }catch(InterruptedException interrupt){
            Thread.currentThread().interrupt();
        }

        ChessBoard.setUserState(UserState.FINISHED_CLICKING);

        return kingTaken;
    }

    private Move getRandomMove(Piece randomPiece, Player player){

        Random randNumGen = new Random();

        while(randomPiece.availableMoves().isEmpty()){
            randomPiece = getRandomPiece(player);
        }

        return randomPiece.availableMoves().get(randNumGen.nextInt(randomPiece.availableMoves().size()));

    }

    private Piece getRandomPiece(Player player){

        Random randNumGen = new Random();

        if(player == this){
            return this.getPieces().getPiece(randNumGen.nextInt(this.getPieces().getNumPieces()));
        }else{
            return this.getOpponent().getPieces().getPiece(randNumGen.nextInt(this.getPieces().getNumPieces()));
        }

    }
}
