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
    public GameFunctionality(GameGUI gameGUI, Properties prop) {

        Player player1 = new Player(1, "Player One", prop.getProperty("symbols1").charAt(0));
        Player player2 = new Player(2, "Player Two", prop.getProperty("symbols2").charAt(0));

        player1.setMyTurn(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        JLabel playerTurnLabel = new JLabel("Player 1 Turn");

        Stack<Move> moves = new Stack<>();

        gameGUI.getContentPane().setLayout(new BorderLayout());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setName(i + "," + j);
                button.setBorder(new LineBorder(Color.black, 5));
                panel.add(button);

                button.addActionListener(e -> {
                    if (player1.isMyTurn()) {
                        button.setText(String.valueOf(player1.getPlayerSymbol()));
                        moves.add(new Move(0, Integer.parseInt(button.getName().split(",")[0]), Integer.parseInt(button.getName().split(",")[1])));
                        player1.setMyTurn(false);
                        player2.setMyTurn(true);
                        playerTurnLabel.setText("Player 2 Turn");
                    } else if (player2.isMyTurn()) {
                        button.setText(String.valueOf(player2.getPlayerSymbol()));
                        moves.add(new Move(1, Integer.parseInt(button.getName().split(",")[0]), Integer.parseInt(button.getName().split(",")[1])));
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

                    if (moves.size() >= 9) {
                        System.out.println(moves.toString());
                        JOptionPane.showMessageDialog(gameGUI, "Good Game");
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

            }
        });
    }
}
