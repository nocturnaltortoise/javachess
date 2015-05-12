package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalDisplay extends JFrame implements Display, ActionListener {

    JButton[][] chessSquares = new JButton[8][8];
    UserState state = UserState.NOT_CLICKING;

//    static boolean clicking = false;
//    static int clickCount = 1;
//    static int initX = 0;
//    static int initY = 0;
//    static int newX = 0;
//    static int newY = 0;

    public void showPiecesOnBoard(Piece[][] piecesOnBoard){
        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){
                String labelString;
                if(piecesOnBoard[j][i] != null){
                    labelString = getChessUnicode(piecesOnBoard[j][i].toString());
                }else{
                    labelString = "";
                }

                chessSquares[i][j].setText(labelString);
            }
        }
    }

    public String getChessUnicode(String piece){
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

    public void initialisePanel(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8, 8));

        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){

                JButton button = new JButton();

                if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)){
                    button.setBackground(Color.WHITE);
                }else{
                    button.setBackground(Color.LIGHT_GRAY);
                }

                button.addActionListener(this);
                chessSquares[i][j] = button;
            }
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                contentPane.add(chessSquares[i][j]);
            }
        }
    }

    public GraphicalDisplay(){
        //set up a basic Jframe window
        setTitle("Java Chess");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
//        setSize(screenSize.width / 2, screenSize.height / 2);
        setSize(500,500);
        setLocation(new Point(screenSize.width / 4, screenSize.height / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initialisePanel();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Button clicked: " + event.getActionCommand());

        if(state == UserState.NOT_CLICKING) {
            state = UserState.STARTED_CLICKING;
        }else if(state == UserState.STARTED_CLICKING){
            state = UserState.FINISHED_CLICKING;
        }

        System.out.println(state);
//        //Needs work
//        for(int i=0; i<chessSquares.length; i++){
//            for(int j=0; j<chessSquares[i].length; j++){
//                if(event.getSource() == chessSquares[i][j]){
//                    System.out.println(j + "," + i);
//                    System.out.println(Chess.getChessBoard().getPiece(j,i));
//                    if(clickCount % 2 == 0){
//                        newX = j;
//                        newY = i;
//                        System.out.println(clickCount);
//                        selectMove(initX, initY, newX, newY);
//                    }else{
//                        initX = j;
//                        initY = i;
//                        System.out.println(clickCount);
//                    }
//                    clickCount++;
//                }
//            }
//        }
    }

//    public void selectMove(int initX, int initY, int newX, int newY){
//        if(clickCount % 2 == 0){
//            System.out.println("Coords: " + initX + "," + initY + "," + newX + "," + newY);
//            System.out.println("" + Chess.getChessBoard().getPiece(initX, initY) + Chess.getChessBoard().getPiece(newX, newY));
//            HumanPlayer.setGraphicalMove(initX, initY, newX, newY);
//        }
//
//    }

}
