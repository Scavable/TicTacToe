package com.scavable.Functionality;

import com.scavable.GUI.MainMenuGUI;
import com.scavable.GUI.SettingsMenuGUI;
import com.scavable.Settings;
import com.sun.tools.javac.Main;

import javax.swing.*;
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
            try {
                int windowSizeWidth = Integer.parseInt(settingsMenuGUI.getWindowSizeWidthTextField().getText());
                int windowSizeHeight = Integer.parseInt(settingsMenuGUI.getWindowSizeHeightTextField().getText());

                byte rounds = Byte.parseByte(settingsMenuGUI.getRoundsTextField().getText());
                float turnTimeLimit = Float.parseFloat(settingsMenuGUI.getTurnTimeLimitTextField().getText());
                char symbols1 = settingsMenuGUI.getSymbols1TextField().getText().charAt(0);
                char symbols2 = settingsMenuGUI.getSymbols2TextField().getText().charAt(0);

                if(Settings.save(windowSizeWidth, windowSizeHeight, rounds, turnTimeLimit, symbols1, symbols2)){
                    settingsMenuGUI.dispose();
                    MainMenuGUI.getInstance().setEnabled(true);
                    MainMenuGUI.getInstance().toFront();
                }else{
                    JOptionPane.showMessageDialog(settingsMenuGUI, "Unable to save settings.", "Error", JOptionPane.ERROR_MESSAGE);
                    settingsMenuGUI.dispose();
                    MainMenuGUI.getInstance().setEnabled(true);
                    MainMenuGUI.getInstance().toFront();
                }

            } catch (IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(settingsMenuGUI, "Unable to save settings.", "Error", JOptionPane.ERROR_MESSAGE);
                settingsMenuGUI.dispose();
                MainMenuGUI.getInstance().setEnabled(true);
                MainMenuGUI.getInstance().toFront();
            }

        });
    }
}
