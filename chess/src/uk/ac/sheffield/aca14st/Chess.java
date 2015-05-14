package uk.ac.sheffield.aca14st;

import java.util.Scanner;

/**@author Simon Turner (aca14st) */

/*
 * Main Class for Chess
 * Runs the main parts of the program and does the setup for the Chess program.
 */

public class Chess{

    private static Scanner keyboard = new Scanner(System.in);
    private static AggressivePlayer firstPlayer = null;
    private static AggressivePlayer secondPlayer = null;
    private static Board board = new Board();

    public static void main(String[] args){

        String firstPlayerName = inputPlayerName();
        String secondPlayerName = inputPlayerName();
//
        Pieces whitePieces = new Pieces(board, 1);
        Pieces blackPieces = new Pieces(board, 0);
//
        playerSetup(firstPlayerName, secondPlayerName, whitePieces, blackPieces, board);

//        TextDisplay consoleOutput = new TextDisplay();
        GraphicalDisplay graphicalOutput = new GraphicalDisplay();
        graphicalOutput.showPiecesOnBoard(board.getData());
//
        playGame(graphicalOutput, board);

    }

    //Method to run the game itself.
    private static void playGame(GraphicalDisplay graphicalOutput, Board board){
        boolean playerOneWon = false;
        boolean playerTwoWon = false;

        //Starts with brief detail about reading the board for the players, and then displays the board.
        System.out.println("White pieces are lower case, Black pieces are uppercase.");
        graphicalOutput.showPiecesOnBoard(board.getData());

        //checks that neither player has won, and if not continues to ask for moves.
        while(!playerOneWon && !playerTwoWon) {
            System.out.println("Player One");
            if(firstPlayer.makeMove()){
                playerOneWon = true;
                graphicalOutput.showPiecesOnBoard(board.getData());
                break;
            }
            graphicalOutput.showPiecesOnBoard(board.getData());
            System.out.println("Player Two");
            if(secondPlayer.makeMove()){
                playerTwoWon = true;
                graphicalOutput.showPiecesOnBoard(board.getData());
                break;
            }
            graphicalOutput.showPiecesOnBoard(board.getData());
        }

        //depending on which player has won, display a different message.
        if(playerOneWon){
            System.out.println(firstPlayer.toString() + " has won!");
        }else if(playerTwoWon){
            System.out.println(secondPlayer.toString() + " has won!");
        }

    }

    //Setup the different players based on user input.
    private static void playerSetup(String firstPlayerName, String secondPlayerName, Pieces whitePieces, Pieces blackPieces, Board board){

        //Make sure the player colour choice is valid, and set the colour of each player, and their opponent, accordingly.
        boolean valid = false;
        while(!valid){
            String playerColourChoice = inputPlayerColour();
            if(playerColourChoice.equalsIgnoreCase("white")){
                firstPlayer = new AggressivePlayer(firstPlayerName, whitePieces, board, null);
                secondPlayer = new AggressivePlayer(secondPlayerName, blackPieces, board, firstPlayer);
                firstPlayer.setOpponent(secondPlayer);
                valid=true;
            }else if(playerColourChoice.equalsIgnoreCase("black")){
                firstPlayer = new AggressivePlayer(firstPlayerName, blackPieces, board, null);
                secondPlayer = new AggressivePlayer(secondPlayerName, whitePieces, board, firstPlayer);
                firstPlayer.setOpponent(secondPlayer);
                valid=true;
            } else {
                System.out.println("Enter a valid colour (black or white).");
            }
        }

    }

    public static Board getChessBoard(){
        return board;
    }

    private static String inputPlayerName(){
        System.out.println("Enter your name: ");
        return keyboard.next();
    }

    private static String inputPlayerColour(){
        System.out.println("Choose a colour, white or black: ");
        return keyboard.next();
    }
}
