package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simon Turner (aca14st)
 */
public class InfoPanel extends JPanel {

    static JLabel turnLabel = new JLabel(Chess.getCurrentTurn());
    static JLabel alertLabel = new JLabel(Chess.getAlert());
    static String takenPieceList = getTakenPieceList();
    static JLabel takenPieces = new JLabel(takenPieceList);

    public InfoPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel playerOneLabel = new JLabel(Chess.getFirstPlayer() + " is " + toColour(Chess.getFirstPlayer().getPieces().getColour()));
        JLabel playerTwoLabel = new JLabel(Chess.getSecondPlayer() + " is " + toColour(Chess.getSecondPlayer().getPieces().getColour()));

        this.add(turnLabel);
        turnLabel.setAlignmentX(this.CENTER_ALIGNMENT);
        turnLabel.setFont(turnLabel.getFont().deriveFont(20.0f));
        this.add(playerOneLabel);
        playerOneLabel.setAlignmentX(this.CENTER_ALIGNMENT);
        this.add(playerTwoLabel);
        playerTwoLabel.setAlignmentX(this.CENTER_ALIGNMENT);
        this.add(takenPieces);
        takenPieces.setAlignmentX(this.CENTER_ALIGNMENT);
        this.add(alertLabel);
        alertLabel.setAlignmentX(this.CENTER_ALIGNMENT);
        alertLabel.setFont(alertLabel.getFont().deriveFont(15.0f));
        this.setSize(200, 500);
    }

    private static String getTakenPieceList(){
        String list = "";
        for(Piece piece : Chess.getFirstPlayer().getTakenPieces()){
            list += ChessBoard.getChessUnicode(piece.toString());
        }

        for(Piece piece : Chess.getSecondPlayer().getTakenPieces()){
            list += ChessBoard.getChessUnicode(piece.toString());
        }

        return list;
    }

    public static JLabel getTakenPieceLabel(){
        return takenPieces;
    }

    public static JLabel getTurnLabel(){
        return turnLabel;
    }

    public static JLabel getAlertLabel(){
        return alertLabel;
    }

    private static String toColour(int colourCode){
        if(colourCode == PieceCode.BLACK){
            return "Black";
        }else{
            return "White";
        }
    }

}
