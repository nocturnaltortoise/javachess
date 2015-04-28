package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalDisplay extends JFrame implements Display {

    public void showPiecesOnBoard(Piece[][] pieces){

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
        contentPane.setLayout(new GridLayout());
        contentPane.add(new GridSquare());
        contentPane.add(new GridSquare());
        contentPane.add(new GridSquare());
    }

    //some adapters for buttons and things

    private class GridButtonHandler implements ActionListener {

        public GridButtonHandler(){

        }

        public void actionPerformed(ActionEvent event){

        }

    }


    private class GridSquare extends JButton{

        public GridSquare(){

        }

    }



}
