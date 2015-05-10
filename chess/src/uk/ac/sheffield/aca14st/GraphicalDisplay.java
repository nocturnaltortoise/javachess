package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalDisplay extends JFrame implements Display, ActionListener {

    JButton[][] chessSquares = new JButton[8][8];
    static boolean clicking = false;

    public void showPiecesOnBoard(Piece[][] piecesOnBoard){

        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){
                String labelString;
                if(piecesOnBoard[j][i] != null){
                    labelString = piecesOnBoard[j][i].toString();
                }else{
                    labelString = "";
                }

                chessSquares[i][j].setText(labelString);
            }
        }
    }

    public void initialisePanel(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8,8));

        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){

                JButton button = new JButton();

                if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)){
                    button.setBackground(Color.WHITE);
                }else{
                    button.setBackground(Color.BLACK);
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
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocation(new Point(screenSize.width / 4, screenSize.height / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initialisePanel();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Button clicked: " + event.getActionCommand());

        int initX = 0;
        int initY = 0;
        int newX = 0;
        int newY = 0;

        int clickCount = 1;
        for(int i=0; i<chessSquares.length; i++){
            for(int j=0; j<chessSquares[i].length; j++){
                clickCount++;
                if(event.getSource() == chessSquares[i][j]){
                    System.out.println(j + "," + i);
                    System.out.println(Chess.getChessBoard().getPiece(j,i));
                    if(clickCount % 2 == 1){
                        initX = j;
                        initY = i;
                    }else{
                        newX = j;
                        newY = i;
                    }
                }
            }
        }
        System.out.println("Coords: " + initX + "," + initY + "," + newX + "," + newY);
        selectMove(initX, initY, newX, newY);
        clicking = true;
    }

    public static boolean playerIsClicking(){
        return clicking;
    }

    public void selectMove(int initX, int initY, int newX, int newY){
        HumanPlayer.setGraphicalMove(initX,initY,newX,newY);
    }

}
