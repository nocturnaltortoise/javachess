package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalDisplay extends JFrame implements Display, ActionListener {

    public void showPiecesOnBoard(Piece[][] piecesOnBoard){
        ChessBoard.showPiecesOnBoard(piecesOnBoard);
    }

    public GraphicalDisplay(){
        //set up a basic Jframe window
        setTitle("Java Chess");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
//        setSize(screenSize.width / 2, screenSize.height / 2);
        setSize(550,550);
        setLocation(new Point(screenSize.width / 4, screenSize.height / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessBoard board = new ChessBoard();
        InfoPanel info = new InfoPanel();
        Container content = getContentPane();
        content.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        content.add(board);
        content.add(info);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){

    }



}
