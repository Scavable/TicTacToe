package Functionality;

import GUI.MainMenuGUI;
import GUI.SettingsMenuGUI;

import javax.swing.*;
import java.awt.*;

public final class MainMenuFunctionality {
    MainMenuGUI mainMenuGUI;
    public MainMenuFunctionality(MainMenuGUI instance) {
        mainMenuGUI = instance;

        playButtonAction(instance.getPlayButton());
        settingsButtonAction(instance.getSettingsButton());
        exitButtonAction(instance.getExitButton());
        aboutButtonAction(instance.getAboutButton());

        instance.setTitle("Tick Tack Toe");
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.setSize(new Dimension(640, 480));
        instance.setLocationRelativeTo(null);
        instance.setVisible(true);

    }

    private void settingsButtonAction(JButton settingsButton) {
        settingsButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            new SettingsMenuGUI();
        });
    }

    private void playButtonAction(JButton playButton) {

    }

    private void exitButtonAction(JButton exitButton){
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void aboutButtonAction(JButton aboutButton){
        String message = "This is a simple Tick Tack Toe game developed for \n the sole purpose of developing and improving my coding skills. \n" +
                "https://github.com/Scavable \n" +
                "-Scavable";

        aboutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, message, "About", JOptionPane.INFORMATION_MESSAGE);
        });
    }


}
