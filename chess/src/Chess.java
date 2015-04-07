import java.util.Scanner;

/**
 * Created by simon on 31/03/15.
 */

public class Chess implements Display{

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        //TODO: should all of this be in main?

        HumanPlayer firstPlayer = null;
        HumanPlayer secondPlayer = null;

        String firstPlayerName = inputPlayerName();
        String secondPlayerName = inputPlayerName();

        Board board = new Board();

        Pieces whitePieces = new Pieces(board, 1);
        Pieces blackPieces = new Pieces(board, 0);

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

        Chess chess = new Chess();
        System.out.println("White pieces are lower case, Black pieces are uppercase.");
        chess.showPiecesOnBoard(board.getData());

        //testing basic setup.
        System.out.println(firstPlayer.toString() + ": " + firstPlayer.getPieces().toString() + ", " + firstPlayer.getOpponent());
        System.out.println(secondPlayer.toString() + ": " + secondPlayer.getPieces().toString() + ", " + secondPlayer.getOpponent());

        boolean gameRunning = true;

        while(gameRunning){
            System.out.println("Player One's Move");
            if(firstPlayer.makeMove()){
                gameRunning = false;
            }
            chess.showPiecesOnBoard(board.getData());
            System.out.println("Player Two's Move");
            if(secondPlayer.makeMove()){
                gameRunning = false;
            }
            chess.showPiecesOnBoard(board.getData());
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

    @Override
    public void showPiecesOnBoard(Piece[][] piecesOnBoard){
        System.out.println();
        int i = 0;
        int j = 1;

        int gridRef = 0;

        System.out.println(" ABCDEFGH");

        for(i = 0; i < piecesOnBoard[j-1].length; i++){
            System.out.print(gridRef);
            gridRef++;
            for(j = 0; j < piecesOnBoard.length; j++){

                if(piecesOnBoard[j][i] == null){
                    System.out.print("-");
                }else{
                    System.out.print(piecesOnBoard[j][i]);
                }

            }
            System.out.println();
        }
    }
}
