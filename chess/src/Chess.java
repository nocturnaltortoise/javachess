import java.util.Scanner;

/**
 * Created by simon on 31/03/15.
 */

public class Chess implements Display{

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        HumanPlayer firstPlayer;
        HumanPlayer secondPlayer;

        String firstPlayerName = inputPlayerName();
        String secondPlayerName = inputPlayerName();

        Board board = new Board();

        Pieces whitePieces = new Pieces(board, 1);
        Pieces blackPieces = new Pieces(board, 0);

        if(inputPlayerColour().equals("white")){
            firstPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, null);
            secondPlayer = new HumanPlayer(secondPlayerName, blackPieces, board, firstPlayer);
            firstPlayer.setOpponent(secondPlayer);
        }else{
            firstPlayer = new HumanPlayer(firstPlayerName, blackPieces, board, null);
            secondPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, firstPlayer);
            firstPlayer.setOpponent(secondPlayer);
        }

        Piece[][] piecesOnBoard = new Piece[4][8];

        for(int i=0; i < whitePieces.getNumPieces(); i++){

        }

        Chess chess = new Chess();
//        chess.showPiecesOnBoard();

    }

    private static String inputPlayerName(){
        System.out.println("Enter your name: ");
        return keyboard.next();
    }

    private static String inputPlayerColour(){
        System.out.println("Choose a colour, white or black: ");
        String colour = keyboard.next();

        if(colour.equalsIgnoreCase("white")){
            return "white";
        }
        return "black";
    }

    public void showPiecesOnBoard(Piece[][] piecesOnBoard){
        for(Piece[] pieces : piecesOnBoard){
            for(Piece piece : pieces){
                System.out.print(piece);
            }
            System.out.println();
        }
    }
}
