package uk.ac.sheffield.aca14st;

import java.util.Random;

public class RandomPlayer extends Player{

    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        boolean kingTaken = false;

        Move randomMove = getRandomMove(getRandomPiece(this), this);
        int initX = randomMove.getCurrentXPosition();
        int initY = randomMove.getCurrentYPosition();
        int newX = randomMove.getNewXPosition();
        int newY = randomMove.getNewYPosition();
        Piece movingPiece = randomMove.getPiece();

        if(randomMove.targetIsOccupied()){
            kingTaken = PieceCode.charToInt(this.getBoard().getPiece(newX, newY).getChar()) == PieceCode.KING;
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
            Thread.sleep(1000);
        }catch(InterruptedException interrupt){
            Thread.currentThread().interrupt();
        }

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
