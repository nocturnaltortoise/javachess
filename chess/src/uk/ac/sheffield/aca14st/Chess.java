package uk.ac.sheffield.aca14st;

import java.util.Scanner;

/**
 * Chess
 * Runs the main parts of the program and does the setup for the Chess program.
 * @author Simon Turner (aca14st)
 */

public class Chess{

    private static Scanner keyboard = new Scanner(System.in);
    private static Player firstPlayer;
    private static Player secondPlayer;
    private static Board board = new Board();
    private static String currentTurn = "";
    private static String alertMessage = "";

    public static void main(String[] args){

        StartDialog gameSetupDialog = new StartDialog();

        //Wait for the user to pick the player types before starting setup.
        while(gameSetupDialog.getPlayerOneType() == null || gameSetupDialog.getPlayerTwoType() == null){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException interrupt){
                Thread.currentThread().interrupt();
            }
        }

        startSetup(gameSetupDialog.getPlayerOneType(),gameSetupDialog.getPlayerTwoType());

    }

    public static void startSetup(String playerOneType, String playerTwoType){
        Pieces whitePieces = new Pieces(board, 1);
        Pieces blackPieces = new Pieces(board, 0);
        playerSetup("Player One", "Player Two", whitePieces, blackPieces, board, playerOneType, playerTwoType);
        GraphicalDisplay graphicalOutput = new GraphicalDisplay();
        playGame(graphicalOutput, board);
    }

    //Method to run the game itself.
    private static void playGame(GraphicalDisplay graphicalOutput, Board board){
        boolean playerOneWon = false;
        boolean playerTwoWon = false;

        graphicalOutput.showPiecesOnBoard(board.getData());

        //checks that neither player has won, and if not continues to ask for moves.
        while(!playerOneWon && !playerTwoWon) {
            InfoPanel.getTurnLabel().setText("Player One's Move");
            if(firstPlayer.makeMove()){
                playerOneWon = true;
                graphicalOutput.showPiecesOnBoard(board.getData());
                break;
            }
            graphicalOutput.showPiecesOnBoard(board.getData());
            InfoPanel.getTurnLabel().setText("Player Two's Move");
            if(secondPlayer.makeMove()){
                playerTwoWon = true;
                graphicalOutput.showPiecesOnBoard(board.getData());
                break;
            }
            graphicalOutput.showPiecesOnBoard(board.getData());
        }

        //depending on which player has won, display a different message.
        if(playerOneWon){
            InfoPanel.getAlertLabel().setText(firstPlayer.toString() + " has won!");
        }else if(playerTwoWon){
            InfoPanel.getAlertLabel().setText(secondPlayer.toString() + " has won!");
        }

    }

    //Depending on the type of player selected, sets up the players and their opponents.
    private static void playerSetup(String firstPlayerName, String secondPlayerName, Pieces whitePieces, Pieces blackPieces, Board board, String p1Type, String p2Type){

        switch(p1Type) {
            case "Human":
                firstPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, null);
                break;
            case "Random AI":
                firstPlayer = new RandomPlayer(firstPlayerName, whitePieces, board, null);
                break;
            case "Aggressive AI":
                firstPlayer = new AggressivePlayer(firstPlayerName, whitePieces, board, null);
                break;
        }

        switch(p2Type) {
            case "Human":
                secondPlayer = new HumanPlayer(secondPlayerName, blackPieces, board, null);
                firstPlayer.setOpponent(secondPlayer);
                break;
            case "Random AI":
                secondPlayer = new RandomPlayer(secondPlayerName, blackPieces, board, null);
                firstPlayer.setOpponent(secondPlayer);
                break;
            case "Aggressive AI":
                secondPlayer = new AggressivePlayer(secondPlayerName, blackPieces, board, null);
                firstPlayer.setOpponent(secondPlayer);
                break;
        }

    }

    public static String getCurrentTurn(){
        return currentTurn;
    }

    public static String getAlert(){
        return alertMessage;
    }

    public static Player getFirstPlayer(){
        return firstPlayer;
    }

    public static Player getSecondPlayer(){
        return secondPlayer;
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
