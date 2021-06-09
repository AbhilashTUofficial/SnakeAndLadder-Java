package com.games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;


public class Screen extends JFrame implements ActionListener {
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
    int player=1;
    int maxPlayer=0;
    Icon boardImg;
    JButton board;
    JButton rollDiceButton;
    JButton saveSettings;
    JButton restartGame;

    Random random=new Random();
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
        saveSettings=new JButton();
        restartGame=new JButton();

        dashBoard.setBounds(600,0,300,600);
        dashBoard.setLayout(null);

        playersLabel.setText("Players");
        playersLabel.setForeground(Color.darkGray);
        playersLabel.setBounds(120,0,100,40);

        enterNumOfPlayers.setText("Enter the number of Players");
        enterNumOfPlayers.setForeground(Color.darkGray);
        enterNumOfPlayers.setBounds(20,60,300,40);

        comboBox.setBounds(230,70,40,20);

        saveSettings.setText("Save");
        saveSettings.setBounds(20,120,100,30);
        saveSettings.addActionListener(this);
        saveSettings.setFocusable(false);

        restartGame.setText("Restart");
        restartGame.setBounds(140,120,100,30);
        restartGame.addActionListener(this);
        restartGame.setEnabled(false);
        restartGame.setFocusable(false);

        playerPanel.setBounds(0,0,300,300);
        playerPanel.setBackground(Color.lightGray);
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        playerPanel.setLayout(null);
        playerPanel.add(playersLabel);
        playerPanel.add(enterNumOfPlayers);
        playerPanel.add(saveSettings);
        playerPanel.add(restartGame);
        playerPanel.add(comboBox);

        currentMoveLabel.setText("Current Move : ");
        currentMoveLabel.setForeground(Color.darkGray);
        currentMoveLabel.setBounds(20,40,200,40);

        currentPlayer.setText("Player 1");
        currentPlayer.setForeground(Color.darkGray);
        currentPlayer.setBounds(140,40,100,40);

        diceNumber.setText("0");
        diceNumber.setFont(new Font("Arial",Font.BOLD,64));
        diceNumber.setForeground(Color.darkGray);
        diceNumber.setBounds(130,80,100,100);

        rollDiceButton.setText("Roll");
        rollDiceButton.setEnabled(false);
        rollDiceButton.setBounds(100,200,100,40);
        rollDiceButton.setFocusable(false);
        rollDiceButton.addActionListener(this);

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
    private int rollDice(){
        int n=random.nextInt(7);
        if(n==0) {
            n=rollDice();
        }
        return n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rollDiceButton){

            if(player<=maxPlayer){
                currentPlayer.setText("Player "+player);
                player++;
                if(player==4){
                    player=1;
                }
            }else{
                player=1;
                currentPlayer.setText("Player "+player);
            }
            System.out.println(player);
            diceNumber.setText(""+rollDice());

        }
        if(e.getSource()==saveSettings){
            maxPlayer= Integer.parseInt(Objects.requireNonNull(comboBox.getSelectedItem()).toString());
            rollDiceButton.setEnabled(true);
            restartGame.setEnabled(true);
            comboBox.setEnabled(false);
            saveSettings.setEnabled(false);
        }
        if(e.getSource()==restartGame){
            rollDiceButton.setEnabled(false);
            comboBox.setEnabled(true);
            saveSettings.setEnabled(true);
            restartGame.setEnabled(false);
            comboBox.setSelectedIndex(0);
        }
    }
}
