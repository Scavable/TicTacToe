package com.scavable.Functionality;

import com.scavable.GUI.MainMenuGUI;
import com.scavable.GUI.SettingsMenuGUI;

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
        menuTitleLayout(instance.getMenuTitle());

        instance.setTitle("Tic Tac Toe");
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.setSize(new Dimension(640, 480));
        instance.setLocationRelativeTo(null);
        instance.setVisible(true);

    }

    private void menuTitleLayout(JLabel menuTitle) {
        menuTitle.setFont(menuTitle.getFont().deriveFont(20f));
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        menuTitle.setBorder(BorderFactory.createLineBorder(Color.black));
        menuTitle.setOpaque(true);
    }

    private void settingsButtonAction(JButton settingsButton) {
        settingsButton.setFont(settingsButton.getFont().deriveFont(20f));
        settingsButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            new SettingsMenuGUI();
        });
    }

    private void playButtonAction(JButton playButton) {
        playButton.setFont(playButton.getFont().deriveFont(20f));

    }

    private void exitButtonAction(JButton exitButton){
        exitButton.setFont(exitButton.getFont().deriveFont(20f));
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void aboutButtonAction(JButton aboutButton){
        aboutButton.setFont(aboutButton.getFont().deriveFont(20f));
        String message = "This is a simple Tick Tack Toe game developed for \n the sole purpose of developing and improving my coding skills. \n" +
                "https://github.com/Scavable \n" +
                "-Scavable";

        aboutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, message, "About", JOptionPane.INFORMATION_MESSAGE);
        });
    }


}
