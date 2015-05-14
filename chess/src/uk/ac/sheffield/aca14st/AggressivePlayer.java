package uk.ac.sheffield.aca14st;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

        if(aggressiveMove.targetIsOccupied()){
            kingTaken = this.getBoard().getPiece(newX, newY) instanceof King;
            System.out.println(kingTaken);
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

        GraphicalDisplay.setUserState(UserState.FINISHED_CLICKING);

        return kingTaken;
    }

    private Move getAggressiveMove(Pieces pieces){

        ArrayList<Move> takingMoves = new ArrayList<>();

        for(Piece possiblePiece : pieces.getData()){
            for(Move possibleMove : possiblePiece.availableMoves()){
                if(possibleMove.targetIsOccupied()){
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
