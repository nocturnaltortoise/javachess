package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalDisplay extends JFrame implements Display, ActionListener {

    public void showPiecesOnBoard(Piece[][] piecesOnBoard){
        int i;
        int j = 1;

        int gridRef = 0;

        System.out.println(" ABCDEFGH");

        for(i = 0; i < piecesOnBoard[j-1].length; i++){
            System.out.print(gridRef);
            gridRef++;
            for(j = 0; j < piecesOnBoard.length; j++){
                //If a square has nothing in it, it's null, so we print a dash.
                if(piecesOnBoard[j][i] == null){
                    System.out.print("-");
                }else{
                    //Otherwise we print the piece.
                    System.out.print(piecesOnBoard[j][i]);
                }

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
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8,8));

        JButton[][] chessSquares = new JButton[8][8];

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

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Button clicked: " + event.getSource());
    }

    //some adapters for buttons and things

//    private class GridButtonHandler implements ActionListener {
//
//        public GridButtonHandler(){
//
//        }
//
//        public void actionPerformed(ActionEvent event){
//
//        }
//
//    }
//
//
//    private class GridSquare extends JButton{
//
//        public GridSquare(){
//
//        }
//
//    }



}
