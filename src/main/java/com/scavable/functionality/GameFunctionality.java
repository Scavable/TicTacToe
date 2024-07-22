package com.scavable.functionality;

import com.scavable.Move;
import com.scavable.Player;
import com.scavable.gui.GameGUI;
import com.scavable.gui.MainMenuGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;
import java.util.Stack;

public final class GameFunctionality {
    private final Player player1;
    private final Player player2;
    private final JPanel panel;
    private final char[][] gameBoard = new char[3][3];
    private byte turns = 0;

    public GameFunctionality(GameGUI gameGUI, Properties prop) {

        player1 = new Player(0, "Player One", prop.getProperty("symbols1").charAt(0));
        player2 = new Player(1, "Player Two", prop.getProperty("symbols2").charAt(0));

        player1.setMyTurn(true);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        JLabel playerTurnLabel = new JLabel("Player 1 Turn");

        Stack<Move> moves = new Stack<>();

        gameGUI.getContentPane().setLayout(new BorderLayout());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setName(i + "," + j);
                button.setBorder(new LineBorder(Color.black, 5));
                panel.add(button, null, -1);

                button.addActionListener(e -> {
                    if (player1.isMyTurn()) {
                        turns++;
                        button.setText(String.valueOf(player1.getPlayerSymbol()));
                        String[] positions = button.getName().split(",");
                        moves.add(new Move(0, player1.getPlayerSymbol(), Integer.parseInt(button.getName().split(",")[0]), Integer.parseInt(button.getName().split(",")[1])));
                        gameBoard[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])] = player1.getPlayerSymbol();
                        player1.setMyTurn(false);
                        player2.setMyTurn(true);
                        playerTurnLabel.setText("Player 2 Turn");
                    } else if (player2.isMyTurn()) {
                        turns++;
                        button.setText(String.valueOf(player2.getPlayerSymbol()));
                        String[] positions = button.getName().split(",");
                        moves.add(new Move(1, player2.getPlayerSymbol(), Integer.parseInt(button.getName().split(",")[0]), Integer.parseInt(button.getName().split(",")[1])));
                        gameBoard[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])] = player2.getPlayerSymbol();
                        player2.setMyTurn(false);
                        player1.setMyTurn(true);
                        playerTurnLabel.setText("Player 1 Turn");
                    } else {
                        int choice = JOptionPane.showOptionDialog(gameGUI, "Something went wrong. Whose turn is it currently?", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Player 1", "Player 2"}, null);
                        if (choice == 0) {
                            player1.setMyTurn(true);
                            player2.setMyTurn(false);
                            playerTurnLabel.setText("Player 1 Turn");
                        } else if (choice == 1) {
                            player2.setMyTurn(true);
                            player1.setMyTurn(false);
                            playerTurnLabel.setText("Player 2 Turn");
                        }
                    }

                    button.setEnabled(false);

                    Move move = moves.peek();
                    if (isWin(move)) {
                        JOptionPane.showMessageDialog(gameGUI, "Good Game Player " + (move.player()+1));
                        gameGUI.dispose();
                        MainMenuGUI.getInstance().setEnabled(true);
                        MainMenuGUI.getInstance().toFront();
                    } else if (moves.size() >= Math.pow(gameBoard.length, 2)) {
                        JOptionPane.showMessageDialog(gameGUI, "Tie Game");
                        gameGUI.dispose();
                        MainMenuGUI.getInstance().setEnabled(true);
                        MainMenuGUI.getInstance().toFront();

                    }
                });

            }
        }

        gameGUI.getContentPane().add(playerTurnLabel, BorderLayout.NORTH);
        gameGUI.getContentPane().add(panel, BorderLayout.CENTER);

        gameGUI.setTitle("Tic Tac Toe");
        gameGUI.setLocation(MainMenuGUI.getInstance().getLocation());
        gameGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameGUI.setSize(new Dimension(Integer.parseInt(prop.getProperty("windowSizeWidth")), Integer.parseInt(prop.getProperty("windowSizeHeight"))));
        gameGUI.setVisible(true);

        gameGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainMenuGUI.getInstance().setEnabled(true);
                MainMenuGUI.getInstance().toFront();
                gameGUI.dispose();
            }
        });
        
    }

    private boolean isWin(Move lastMove) {
        char symbol = lastMove.symbol();
        boolean continous1 = false;
        boolean continous2 = false;
        boolean continous3 = false;

        //row
        for (int i = 0; i < gameBoard.length; i++){
            if(symbol == gameBoard[lastMove.pos1()][i]){
                prettyPrint(gameBoard);
                continous1 = true;
                System.out.println("True");
            }else{
                continous1 = false;
                System.out.println("False");
                break;
            }
        }
        if(continous1){
            System.out.println("Row Win");
            return true;
        }

        //col
        for (int i = 0; i < gameBoard.length; i++){
            if(symbol == gameBoard[i][lastMove.pos2()]){
                prettyPrint(gameBoard);
                continous2 = true;
            }else{
                continous2 = false;
                break;
            }
        }
        if(continous2){
            System.out.println("Column Win");
            return true;
        }

        //diag 1
        for (int i = 0; i < gameBoard.length; i++){
            if(symbol == gameBoard[i][lastMove.pos2()]){
                continous3 = true;
            }else{
                continous3 = false;
                break;
            }
        }
        if(continous3){
            return true;
        }

        //diag 2
        for (int i = 0; i < gameBoard.length; i++){

        }
        if(continous3){
            return true;
        }
        
        return false;
    }

    private void prettyPrint(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

}