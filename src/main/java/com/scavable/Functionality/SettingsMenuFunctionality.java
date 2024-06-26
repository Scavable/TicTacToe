package com.scavable.Functionality;

import com.scavable.GUI.MainMenuGUI;
import com.scavable.GUI.SettingsMenuGUI;
import com.scavable.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public final class SettingsMenuFunctionality {
    public SettingsMenuFunctionality(SettingsMenuGUI settingsMenuGUI) {
        actions(settingsMenuGUI);
        settingsMenuGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        settingsMenuGUI.setTitle("Tic Tac Toe");
        settingsMenuGUI.setSize(640, 480);
        settingsMenuGUI.setLocationRelativeTo(MainMenuGUI.getInstance());
        settingsMenuGUI.setVisible(true);
    }

    private void actions(SettingsMenuGUI settingsMenuGUI) {
        settingsMenuGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainMenuGUI.getInstance().setEnabled(true);
            }
        });

        settingsMenuGUI.getCancelButton().addActionListener(e -> settingsMenuGUI.dispose());

        settingsMenuGUI.getSaveButton().addActionListener(e -> {
            Dimension windowSize = new Dimension(Integer.parseInt(settingsMenuGUI.getWindowSizeWidthTextField().getText()),
                    Integer.parseInt(settingsMenuGUI.getWindowSizeHeightTextField().getText()));

            byte rounds = Byte.parseByte(settingsMenuGUI.getRoundsTextField().getText());
            float turnTimeLimit = Float.parseFloat(settingsMenuGUI.getTurnTimeLimitTextField().getText());
            char[] symbols = new char[] {settingsMenuGUI.getSymbols1TextField().getText().charAt(0), settingsMenuGUI.getSymbols2TextField().getText().charAt(0)};

            try {
                Settings.save(windowSize, rounds, turnTimeLimit, symbols);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
