import java.util.Scanner;

/**
 * Created by simon on 31/03/15.
 */
public class HumanPlayer extends Player{

    private static Scanner moveInput = new Scanner(System.in);

    public HumanPlayer(String n, Pieces p, Board b, Player o){
        super(n, p, b, o);
    }

    @Override
    public boolean makeMove(){
        boolean legalMove = false;
        boolean kingTaken = false;

        while(!legalMove){
            //returns true when move takes the king.
            String[][] move = getMove();

            if(letterToNumber(move[0][0]) > 7
                    || letterToNumber(move[0][0]) < 0
                    || letterToNumber(move[1][0]) > 7
                    || letterToNumber(move[1][0]) < 0) {
                System.out.println("Enter a valid move.");
                legalMove = false;
                continue;
            }

            int initX = letterToNumber(move[0][0]);
            int initY = Integer.parseInt(move[0][1]);
            int newX = letterToNumber(move[1][0]);
            int newY = Integer.parseInt(move[1][1]);
            boolean targetOccupied = getBoard().occupied(newX, newY);
            if(targetOccupied){
                kingTaken = PieceCode.charToInt(getBoard().getPiece(newX, newY).getChar()) == PieceCode.KING;
            }
//            System.out.println("" + initX + "," + initY + "," + newX +"," + newY + "," + targetOccupied);
//            System.out.println(getBoard().getPiece(initX,initY));

            Piece movingPiece = getBoard().getPiece(initX, initY);
            Move playerMove = new Move(movingPiece, initX, initY, newX, newY, targetOccupied);

            System.out.println(movingPiece.getClass() + playerMove.toString());
            System.out.println(movingPiece.availableMoves());

            if(movingPiece.availableMoves().contains(playerMove) && movingPiece.getColour() == this.getPieces().getColour()){
                if(targetOccupied && getBoard().getPiece(newX, newY).getColour() != getBoard().getPiece(initX, initY).getColour()){
                    getBoard().remove(newX, newY);
                }
                getBoard().getData()[newX][newY] = movingPiece;
                movingPiece.setPosition(newX, newY);
                System.out.println(getBoard().getPiece(initX, initY));

                getBoard().remove(initX, initY);
                legalMove = true;
            }else{
                System.out.println("Move is not legal. Enter a legal move.");
                legalMove = false;
            }

        }

        return kingTaken;

    }

    private String[][] getMove(){
        System.out.println("Enter a move in the form (grid-ref of piece, grid-ref of target) e.g. (a3,a4).");
        String[] rawMove = moveInput.next().split(",");
        //splits the move string into 4 parts - letter,number letter,number
        String[][] move = {{rawMove[0].substring(0,1),rawMove[0].substring(1,2)},{rawMove[1].substring(0,1),rawMove[1].substring(1,2)}};

        return move;
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
                return 100;
                //only way this would happen would be if the letter isn't a grid ref
                //could be anything over 7

        }
    }
}
