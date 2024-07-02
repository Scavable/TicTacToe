package com.scavable.functionality;

import com.scavable.gui.MainMenuGUI;
import com.scavable.gui.SettingsMenuGUI;
import com.scavable.Settings;
import com.scavable.util.Utility;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class SettingsMenuFunctionality {

    public SettingsMenuFunctionality(SettingsMenuGUI settingsMenuGUI) {
        actions(settingsMenuGUI);
        settingsMenuGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        settingsMenuGUI.setTitle("Tic Tac Toe");
        settingsMenuGUI.setSize(640, 480);
        settingsMenuGUI.setLocationRelativeTo(MainMenuGUI.getInstance());
        settingsMenuGUI.setVisible(true);

        Utility.defaultFocus(settingsMenuGUI.getContentPane());
        Utility.defaultTextAlignment(settingsMenuGUI.getContentPane());
    }

    //TODO: create actions class to store program actions. Then set action to each component
    private void actions(SettingsMenuGUI settingsMenuGUI) {
        windowAction(settingsMenuGUI);
        cancelButtonAction(settingsMenuGUI);
        saveButtonAction(settingsMenuGUI);
    }

    private void saveButtonAction(SettingsMenuGUI settingsMenuGUI) {
        settingsMenuGUI.getSaveButton().addActionListener(e -> {
            try {
                int windowSizeWidth = Integer.parseInt(settingsMenuGUI.getWindowSizeWidthTextField().getText());
                int windowSizeHeight = Integer.parseInt(settingsMenuGUI.getWindowSizeHeightTextField().getText());

                byte rounds = Byte.parseByte(settingsMenuGUI.getRoundsTextField().getText());
                float turnTimeLimit = Float.parseFloat(settingsMenuGUI.getTurnTimeLimitTextField().getText());
                char symbols1 = settingsMenuGUI.getSymbols1TextField().getText().charAt(0);
                char symbols2 = settingsMenuGUI.getSymbols2TextField().getText().charAt(0);

                if (!Settings.save(windowSizeWidth, windowSizeHeight, rounds, turnTimeLimit, symbols1, symbols2)) {
                    JOptionPane.showMessageDialog(settingsMenuGUI, "Unable to save settings.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                Properties prop = MainMenuGUI.getProp();
                prop.loadFromXML(new FileInputStream("settings.properties"));
                MainMenuGUI.setProp(prop);

                MainMenuGUI.getInstance().setSize(windowSizeWidth, windowSizeHeight);
                settingsMenuGUI.dispose();
                MainMenuGUI.getInstance().repaint();
                MainMenuGUI.getInstance().setLocationRelativeTo(null);
                MainMenuGUI.getInstance().setEnabled(true);
                MainMenuGUI.getInstance().toFront();

            } catch (IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(settingsMenuGUI, "Unable to save settings.", "Error", JOptionPane.ERROR_MESSAGE);
                settingsMenuGUI.dispose();
                MainMenuGUI.getInstance().setEnabled(true);
                MainMenuGUI.getInstance().toFront();
            }

        });
    }

    private void cancelButtonAction(SettingsMenuGUI settingsMenuGUI) {
        settingsMenuGUI.getCancelButton().addActionListener(e ->{
            settingsMenuGUI.dispose();
            MainMenuGUI.getInstance().setEnabled(true);
            MainMenuGUI.getInstance().toFront();
        });
    }

    private void windowAction(SettingsMenuGUI settingsMenuGUI) {
        settingsMenuGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainMenuGUI.getInstance().setEnabled(true);
            }
        });
    }
}
