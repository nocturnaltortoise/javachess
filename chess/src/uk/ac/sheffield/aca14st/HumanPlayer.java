package uk.ac.sheffield.aca14st;

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
        boolean legalMove = false;
        boolean kingTaken = false;

        //checks whether the user's grid references are valid inputs.
        while(!legalMove && GraphicalDisplay.playerIsClicking()){

            int initX = move[0][0];
            int initY = move[0][1];
            int newX = move[1][0];
            int newY = move[1][1];

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
                System.out.println("Enter a valid move.");
                legalMove = false;
                continue;
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
                legalMove = true;
            }else{
                System.out.println("Move is not legal. Enter a legal move.");
                legalMove = false;
            }
        }

        return kingTaken;
    }

    //Gets the user's input for a move and makes it usable by makeMove.
    private String[][] getMove(){
        System.out.println("Enter a move in the form (grid-ref of piece, grid-ref of target) e.g. (a3,a4).");
        String input = moveInput.next();

        while(!input.contains(",")){
            System.out.println("Enter a valid input in the form grid-ref,grid-ref.");
            input = moveInput.next();
        }

        String[] rawMove = input.split(",");
        //splits the move string into 4 parts - letter,number letter,number
        String[][] move = {
                {rawMove[0].substring(0,1),rawMove[0].substring(1,2)},
                {rawMove[1].substring(0,1),rawMove[1].substring(1,2)}
        };

        return move;

    }

    public static void setGraphicalMove(int initX, int initY, int newX, int newY){
        move[0][0] = initX;
        move[0][1] = initY;
        move[1][0] = newX;
        move[1][1] = newY;
    }

    private int letterToNumber(String letter){
        switch(letter.toLowerCase()){
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            default:
                return 10;
                //only way this would happen would be if the letter isn't a grid ref
        }
    }
}
