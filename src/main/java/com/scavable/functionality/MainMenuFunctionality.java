package com.scavable.functionality;

import com.scavable.gui.MainMenuGUI;
import com.scavable.gui.SettingsMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public final class MainMenuFunctionality {
    MainMenuGUI mainMenuGUI;
    public MainMenuFunctionality(MainMenuGUI instance) {
        System.out.println("No Settings Loaded");
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

    public MainMenuFunctionality(MainMenuGUI instance, Properties prop) {
        System.out.println("Settings Loaded");
        mainMenuGUI = instance;

        playButtonAction(instance.getPlayButton(), prop);
        settingsButtonAction(instance.getSettingsButton(), prop);
        exitButtonAction(instance.getExitButton());
        aboutButtonAction(instance.getAboutButton());
        menuTitleLayout(instance.getMenuTitle());

        instance.setTitle("Tic Tac Toe");
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.setSize(new Dimension(Integer.parseInt(prop.getProperty("windowSizeWidth")), Integer.parseInt(prop.getProperty("windowSizeHeight"))));
        instance.setLocationRelativeTo(null);
        instance.setVisible(true);
    }

    private void settingsButtonAction(JButton settingsButton, Properties prop) {
        //settingsButton.setFont(settingsButton.getFont().deriveFont(20f));
        settingsButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            new SettingsMenuGUI(prop);
        });
    }

    private void playButtonAction(JButton playButton, Properties prop) {
        //playButton.setFont(playButton.getFont().deriveFont(20f));
    }

    private void menuTitleLayout(JLabel menuTitle) {
        //menuTitle.setFont(menuTitle.getFont().deriveFont(20f));
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        menuTitle.setBorder(BorderFactory.createLineBorder(Color.black));
        menuTitle.setOpaque(true);
    }

    private void settingsButtonAction(JButton settingsButton) {
        //settingsButton.setFont(settingsButton.getFont().deriveFont(20f));
        settingsButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            new SettingsMenuGUI();
        });
    }

    private void playButtonAction(JButton playButton) {
        //playButton.setFont(playButton.getFont().deriveFont(20f));

    }

    private void exitButtonAction(JButton exitButton){
        //exitButton.setFont(exitButton.getFont().deriveFont(20f));
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void aboutButtonAction(JButton aboutButton){
        //aboutButton.setFont(aboutButton.getFont().deriveFont(20f));
        JTextArea aboutTextArea = new JTextArea();

        String message = """
                This is a simple Tic Tac Toe game developed for\s
                 the sole purpose of developing and improving my coding skills.\s
                https://github.com/Scavable\s
                -Scavable""";

        aboutTextArea.setText(message);

        aboutTextArea.setEditable(false);
        aboutTextArea.setFont(aboutButton.getFont().deriveFont(20f));

        aboutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, aboutTextArea, "About", JOptionPane.INFORMATION_MESSAGE);
        });
    }


}
