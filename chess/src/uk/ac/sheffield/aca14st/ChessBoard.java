package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simon Turner (aca14st)
 */
public class ChessBoard extends JPanel implements ActionListener{

    static JButton[][] chessSquares = new JButton[8][8];
    static UserState state = UserState.NOT_CLICKING;
    static int[][] clickCoordinates = new int[2][2];

    public ChessBoard(){
        this.setLayout(new GridLayout(8, 8));

        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){
                JButton button = new JButton();
                chessSquares[i][j] = button;
                button.addActionListener(this);
            }
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                this.add(chessSquares[i][j]);
            }
        }

        setNormalBackground();
//        this.setSize(500,500);
    }

    public static void showPiecesOnBoard(Piece[][] piecesOnBoard){
        setNormalBackground();

        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){
                String labelString;
                if(piecesOnBoard[j][i] != null){
                    labelString = getChessUnicode(piecesOnBoard[j][i].toString());
                }else{
                    labelString = "";
                }

                chessSquares[i][j].setText(labelString);
                chessSquares[i][j].setFont(chessSquares[i][j].getFont().deriveFont(30.0f));
            }
        }
    }

    public void actionPerformed(ActionEvent event){

        setNormalBackground();

        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){
                if(event.getSource() == chessSquares[i][j]){

                    if(state == UserState.NOT_CLICKING) {
                        state = UserState.STARTED_CLICKING;
                    }else if(state == UserState.STARTED_CLICKING){
                        state = UserState.FINISHED_CLICKING;
                    }

                    if(Chess.getChessBoard().getPiece(j,i) != null){
                        for(Move move : Chess.getChessBoard().getPiece(j,i).availableMoves()){
                            chessSquares[move.getNewYPosition()][move.getNewXPosition()].setBackground(Color.yellow);
                        }
                    }

                    if(state == UserState.STARTED_CLICKING){
                        clickCoordinates[0][0] = j;
                        clickCoordinates[0][1] = i;
                    }else{
                        clickCoordinates[1][0] = j;
                        clickCoordinates[1][1] = i;
                    }
                }
            }
        }
    }

    public static int[][] getClickCoordinates(){
        return clickCoordinates;
    }

    public static UserState getUserState(){
        return state;
    }

    public static void setUserState(UserState newState){
        state = newState;
    }

    public static String getChessUnicode(String piece){
        switch(piece){
            case "P":
                return "\u265F";
            case "p":
                return "\u2659";
            case "R":
                return "\u265C";
            case "r":
                return "\u2656";
            case "N":
                return "\u265E";
            case "n":
                return "\u2658";
            case "B":
                return "\u265D";
            case "b":
                return "\u2657";
            case "Q":
                return "\u265B";
            case "q":
                return "\u2655";
            case "K":
                return "\u265A";
            case "k":
                return "\u2654";
            default:
                return piece;
        }
    }

    private static void setNormalBackground(){

        for(int i=0; i<chessSquares.length; i++) {
            for (int j = 0; j < chessSquares[i].length; j++) {

                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    chessSquares[i][j].setBackground(Color.WHITE);
                } else {
                    chessSquares[i][j].setBackground(Color.LIGHT_GRAY);
                }


            }
        }
    }

}
