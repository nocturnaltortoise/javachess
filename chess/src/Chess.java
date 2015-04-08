import java.util.Scanner;

public class Chess{

    private static Scanner keyboard = new Scanner(System.in);
    private static HumanPlayer firstPlayer = null;
    private static HumanPlayer secondPlayer = null;

    public static void main(String[] args){

        String firstPlayerName = inputPlayerName();
        String secondPlayerName = inputPlayerName();

        Board board = new Board();

        Pieces whitePieces = new Pieces(board, 1);
        Pieces blackPieces = new Pieces(board, 0);

        TextDisplay consoleOutput = new TextDisplay();

        playerSetup(firstPlayerName, secondPlayerName, whitePieces, blackPieces, board);

        System.out.println("White pieces are lower case, Black pieces are uppercase.");
        consoleOutput.showPiecesOnBoard(board.getData());

        boolean playerOneWon = false;
        boolean playerTwoWon = false;

        playGame(playerOneWon, playerTwoWon, consoleOutput, board);

    }

    private static void playGame(boolean playerOneWon, boolean playerTwoWon, TextDisplay consoleOutput, Board board){
        while(!playerOneWon && !playerTwoWon){
            System.out.println("Player One's Move");
            if(firstPlayer.makeMove()){
                playerOneWon = true;
                break;
            }
            consoleOutput.showPiecesOnBoard(board.getData());
            System.out.println("Player Two's Move");
            if(secondPlayer.makeMove()){
                playerTwoWon = true;
                break;
            }
            consoleOutput.showPiecesOnBoard(board.getData());
        }

        if(playerOneWon){
            System.out.println(firstPlayer.toString() + " has won!");
        }else if(playerTwoWon){
            System.out.println(secondPlayer.toString() + " has won!");
        }

    }

    private static void playerSetup(String firstPlayerName, String secondPlayerName,
                                    Pieces whitePieces, Pieces blackPieces, Board board){

        boolean asking = true;
        while(asking){
            String playerColourChoice = inputPlayerColour();
            if(playerColourChoice.equalsIgnoreCase("white")){
                firstPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, null);
                secondPlayer = new HumanPlayer(secondPlayerName, blackPieces, board, firstPlayer);
                firstPlayer.setOpponent(secondPlayer);
                asking=false;
            }else if(playerColourChoice.equalsIgnoreCase("black")){
                firstPlayer = new HumanPlayer(firstPlayerName, blackPieces, board, null);
                secondPlayer = new HumanPlayer(secondPlayerName, whitePieces, board, firstPlayer);
                firstPlayer.setOpponent(secondPlayer);
                asking=false;
            } else {
                System.out.println("Enter a valid colour (black or white).");
            }
        }

    }

    private static String inputPlayerName(){
        System.out.println("Enter your name: ");
        return keyboard.next();
    }

    private static String inputPlayerColour(){
        System.out.println("Choose a colour, white or black: ");
        String colour = keyboard.next();

        return colour;
    }
}
