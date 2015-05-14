package uk.ac.sheffield.aca14st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simon Turner (aca14st)
 */
public class StartDialog extends JFrame implements ActionListener {

    private static String[] userTypes = {"Human","Random AI","Aggressive AI"};
    JComboBox playerOneDropdown = new JComboBox(userTypes);
    JComboBox playerTwoDropdown = new JComboBox(userTypes);
    String playerOneType;
    String playerTwoType;

    public StartDialog(){
        setTitle("Chess");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel upperPanel = new JPanel();
        JLabel titleText = new JLabel(ChessBoard.getChessUnicode("P") + "CHESS" + ChessBoard.getChessUnicode("k"));
        titleText.setFont(titleText.getFont().deriveFont(50.0f));

        JPanel lowerPanel = new JPanel();

        playerOneDropdown.addActionListener(this);

        playerTwoDropdown.addActionListener(this);
        JLabel vsText = new JLabel(" VS ");
        vsText.setFont(vsText.getFont().deriveFont(20.0f));

        JPanel playButtonPanel = new JPanel();
        JButton startGame = new JButton("Play!");
        startGame.addActionListener(this);

        playButtonPanel.add(startGame);

        upperPanel.add(titleText);
        lowerPanel.add(playerOneDropdown);
        lowerPanel.add(vsText);
        lowerPanel.add(playerTwoDropdown);

        playButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(upperPanel);
        this.add(lowerPanel);
        this.add(playButtonPanel);
        this.setLayout(new GridLayout(3, 3));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() instanceof JButton){
            playerOneType = playerOneDropdown.getSelectedItem().toString();
            playerTwoType = playerTwoDropdown.getSelectedItem().toString();
            dispose();
        }

    }

    public String getPlayerOneType(){
        return playerOneType;
    }

    public String getPlayerTwoType(){
        return playerTwoType;
    }

}
