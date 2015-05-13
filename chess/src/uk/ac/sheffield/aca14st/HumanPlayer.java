package uk.ac.sheffield.aca14st;

import java.awt.font.GraphicAttribute;
import java.util.Scanner;

/**@author Simon Turner (aca14st) */

public class HumanPlayer extends Player{

    private static Scanner moveInput = new Scanner(System.in);
    static int[][] move = new int[2][2];

    public HumanPlayer(String n, Pieces p, Board b, Player o){
        super(n, p, b, o);
    }

    //Makes a move inputted by the player. Returns true when the player takes the king.
    @Override
    public boolean makeMove(){
//        boolean legalMove = false;
        boolean kingTaken = false;

        waitForMove();
        //checks whether the user's grid references are valid inputs.
        if(GraphicalDisplay.getUserState() == UserState.FINISHED_CLICKING){

            int initX = move[0][0];
            int initY = move[0][1];
            int newX = move[1][0];
            int newY = move[1][1];

            System.out.println("In HumanPlayer: " + initX + "," + initY + "," + newX + "," + newY);

            //check whether the target square is occupied.
            boolean targetOccupied = getBoard().occupied(newX, newY);

            //if taking a piece, check whether the piece is a king.
            if(targetOccupied){
                kingTaken = PieceCode.charToInt(getBoard().getPiece(newX, newY).getChar()) == PieceCode.KING;
            }

            Piece movingPiece = getBoard().getPiece(initX, initY);
            Move playerMove = new Move(movingPiece, initX, initY, newX, newY, targetOccupied, this.getBoard());

            //Make sure that there is a piece on the square the player has inputted.
            if(movingPiece == null){
                GraphicalDisplay.setUserState(UserState.NOT_CLICKING);
                System.out.println("Enter a valid move. (Moving piece is null)");
                waitForMove();
            }

            /*
             *If the moving piece has the suggested move in it's legal moves, and belongs to the player moving it, move the piece.
             *If there's an opposite colour piece under the target, take that piece. If the move isn't legal, prompt the user to enter
             *another move.
             */
            if(movingPiece.availableMoves().contains(playerMove) && movingPiece.getColour() == this.getPieces().getColour()){
                if(targetOccupied && getBoard().getPiece(newX, newY).getColour() != getBoard().getPiece(initX, initY).getColour()){
                    getBoard().remove(newX, newY);
                }
                getBoard().getData()[newX][newY] = movingPiece;
                movingPiece.setPosition(newX, newY);
                getBoard().remove(initX, initY);
            }else{
                System.out.println("Move is not legal. Enter a legal move.");
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

    public static void setGraphicalMove(int initX, int initY, int newX, int newY){
        move[0][0] = initX;
        move[0][1] = initY;
        move[1][0] = newX;
        move[1][1] = newY;
    }

}
