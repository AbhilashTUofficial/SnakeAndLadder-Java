package com.games;

import javax.swing.*;
import java.awt.*;



public class Screen extends JFrame {
    JPanel panel;
    JPanel dashBoard;
    JPanel playerPanel;
    JPanel dice;
    JLabel playersLabel;
    JLabel diceNumber;
    JLabel enterNumOfPlayers;
    JLabel currentMoveLabel;
    JLabel currentPlayer;
    String[] playerNums={"1","2","3"};
    JComboBox comboBox=new JComboBox(playerNums);
    Icon boardImg;
    JButton board;
    JButton rollDiceButton;
    Screen(){
        // Window setups
        setBounds(200, 100, 890, 630);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Snake And Ladder");
        setResizable(false);
        setAlwaysOnTop(true);
        add(gamePanel());
        add(dashBoard());
        setVisible(true);
    }

    private JPanel gamePanel() {
        panel = new JPanel();
        board=new JButton();
        boardImg= new ImageIcon("src/com/games/snake_and_ladder_board.png");
        board.setIcon(boardImg);
        board.setForeground(Color.gray);
        board.setBackground(Color.white);
        board.setEnabled(true);
        board.setFocusable(false);
        panel.setSize(new Dimension(600,600));
        panel.setLayout(new BorderLayout());

        panel.add(board);
        return  panel;
    }

    private JPanel dashBoard(){
        dashBoard =new JPanel();
        playerPanel=new JPanel();
        dice=new JPanel();
        playersLabel=new JLabel();
        diceNumber=new JLabel();
        enterNumOfPlayers=new JLabel();
        currentMoveLabel =new JLabel();
        currentPlayer =new JLabel();
        rollDiceButton=new JButton();

        dashBoard.setBounds(600,0,300,600);
        dashBoard.setLayout(null);

        playersLabel.setText("Players");
        playersLabel.setForeground(Color.darkGray);
        playersLabel.setBounds(120,0,100,40);

        enterNumOfPlayers.setText("Enter the number of Players");
        enterNumOfPlayers.setForeground(Color.darkGray);
        enterNumOfPlayers.setBounds(20,60,300,40);

        comboBox.setBounds(230,70,40,20);

        playerPanel.setBounds(0,0,300,300);
        playerPanel.setBackground(Color.lightGray);
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        playerPanel.setLayout(null);
        playerPanel.add(playersLabel);
        playerPanel.add(enterNumOfPlayers);
        playerPanel.add(comboBox);

        currentMoveLabel.setText("Current Move : ");
        currentMoveLabel.setForeground(Color.darkGray);
        currentMoveLabel.setBounds(20,40,200,40);

        currentPlayer.setText("Player 1");
        currentPlayer.setForeground(Color.darkGray);
        currentPlayer.setBounds(140,40,100,40);

        diceNumber.setText("6");
        diceNumber.setFont(new Font("Arial",Font.BOLD,64));
        diceNumber.setForeground(Color.darkGray);
        diceNumber.setBounds(130,80,100,100);

        rollDiceButton.setText("Roll");
        rollDiceButton.setBounds(100,200,100,40);
        rollDiceButton.setFocusable(false);

        dice.setBounds(0,300,300,300);
        dice.setBackground(Color.lightGray);
        dice.setBorder(BorderFactory.createLineBorder(Color.gray));
        dice.setLayout(null);
        dice.add(currentMoveLabel);
        dice.add(currentPlayer);
        dice.add(diceNumber);
        dice.add(rollDiceButton);

        dashBoard.setVisible(true);

        dashBoard.add(dice);
        dashBoard.add(playerPanel);
        return dashBoard;
    }
}
