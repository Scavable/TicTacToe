package Functionality;

import GUI.MainMenuGUI;
import GUI.SettingsMenuGUI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingsMenuFunctionality {
    public SettingsMenuFunctionality(SettingsMenuGUI settingsMenuGUI) {

        settingsMenuGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsMenuGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainMenuGUI.getInstance().setEnabled(true);
            }
        });
        settingsMenuGUI.setTitle("Tick Tack Toe");
        settingsMenuGUI.setSize(640, 480);
        settingsMenuGUI.setLocationRelativeTo(MainMenuGUI.getInstance());
        settingsMenuGUI.setVisible(true);
    }
}
