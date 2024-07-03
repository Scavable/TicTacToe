package com.scavable.functionality;

import com.scavable.Player;
import com.scavable.gui.GameGUI;
import com.scavable.gui.MainMenuGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

public final class GameFunctionality {
    public GameFunctionality(GameGUI gameGUI, Properties prop) {

        Player player1 = new Player(1, "Player One", prop.getProperty("symbols1").charAt(0));
        Player player2 = new Player(2, "Player Two", prop.getProperty("symbols2").charAt(0));

        player1.setMyTurn(true);

        for(int i = 0; i<9; i++){
            JButton button = new JButton("");
            button.setBorder(new LineBorder(Color.black, 5));
            gameGUI.getContentPane().add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (player1.isMyTurn()){
                        button.setText(String.valueOf(player1.getPlayerSymbol()));
                        player1.setMyTurn(false);
                        player2.setMyTurn(true);
                    } else if (player2.isMyTurn()){
                        button.setText(String.valueOf(player2.getPlayerSymbol()));
                        player2.setMyTurn(false);
                        player1.setMyTurn(true);
                    }else{
                        int choice = JOptionPane.showOptionDialog(gameGUI, "Something went wrong. Whose turn is it currently?", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Player 1", "Player 2"}, null);
                        if (choice == 0){
                            player1.setMyTurn(true);
                            player2.setMyTurn(false);
                        }else if (choice == 1){
                            player2.setMyTurn(true);
                            player1.setMyTurn(false);
                        }
                    }

                    button.setEnabled(false);

                }
            });
        }

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
