import java.util.Scanner;

/**
 * Created by simon on 31/03/15.
 */

public class Chess {

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
            firstPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, secondPlayer);
            secondPlayer = new HumanPlayer(secondPlayerName, blackPieces, board, firstPlayer);
        }else{
            firstPlayer = new HumanPlayer(firstPlayerName, blackPieces, board, secondPlayer);
            secondPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, firstPlayer);
        }

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
}
