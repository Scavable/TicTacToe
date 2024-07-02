package com.scavable.functionality;

import com.scavable.gui.GameGUI;
import com.scavable.gui.MainMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

public final class GameFunctionality {
    public GameFunctionality(GameGUI gameGUI, Properties prop) {

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
