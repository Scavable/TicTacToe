package com.scavable.functionality;

import com.scavable.gui.GameGUI;
import com.scavable.gui.MainMenuGUI;
import com.scavable.gui.SettingsMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public final class MainMenuFunctionality {
    private static SettingsMenuGUI INSTANCE = null;
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
        settingsButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            INSTANCE = SettingsMenuGUI.getInstance();
            new SettingsMenuFunctionality(INSTANCE);
        });
    }

    private void playButtonAction(JButton playButton, Properties prop) {
        playButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            new GameGUI(prop);
        });
    }

    private void menuTitleLayout(JLabel menuTitle) {
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        menuTitle.setBorder(BorderFactory.createLineBorder(Color.black));
        menuTitle.setOpaque(true);
    }

    private void settingsButtonAction(JButton settingsButton) {
        settingsButton.addActionListener(e -> {
            mainMenuGUI.setEnabled(false);
            SettingsMenuGUI.getInstance();
        });
    }

    private void playButtonAction(JButton playButton) {

    }

    private void exitButtonAction(JButton exitButton){
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void aboutButtonAction(JButton aboutButton){
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
