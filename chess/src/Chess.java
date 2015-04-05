import java.util.Scanner;

/**
 * Created by simon on 31/03/15.
 */

public class Chess implements Display{

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

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
            if(playerColourChoice.equals("white")){
                firstPlayer = new HumanPlayer(firstPlayerName, whitePieces, board, null);
                secondPlayer = new HumanPlayer(secondPlayerName, blackPieces, board, firstPlayer);
                firstPlayer.setOpponent(secondPlayer);
                asking=false;
            }else if(playerColourChoice.equals("black")){
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
        }else if(colour.equalsIgnoreCase("black")){
            return "black";
        }else{
            return "invalid string";
        }

    }

    public void showPiecesOnBoard(Piece[][] piecesOnBoard){
        System.out.println();
        int i,j = 0;

        for(i = 0; i < piecesOnBoard[j].length; i++){
            for(j = 0; j < piecesOnBoard.length-1; j++){
                if(piecesOnBoard[j][i] == null){
                    System.out.print("-");
                }else{
                    System.out.print(piecesOnBoard[j][i]);
                }
            }
            System.out.println();
        }

        //rip in pepperonis old code, enhanced for loop made chess look weird
//        for(Piece[] pieces : piecesOnBoard){
//            for(Piece piece : pieces){
//                System.out.print("|");
//                if(piece == null){
//                    System.out.print(" ");
//                }else {
//                    System.out.print(piece);
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}
