package com.scavable.gui;

import com.scavable.functionality.MainMenuFunctionality;
import com.scavable.Settings;
import com.scavable.util.Utility;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public final class MainMenuGUI extends JFrame {
    private static MainMenuGUI INSTANCE = null;
    private final JPanel panel = new JPanel();

    private final JLabel menuTitle = new JLabel("Main Menu");
    private final JButton playButton = new JButton("Play");
    private final JButton exitButton = new JButton("Exit");
    private final JButton settingsButton = new JButton("Settings");
    private final JButton aboutButton = new JButton("About");
    private static Properties prop;

    public static void main(String[] args) {
        INSTANCE = MainMenuGUI.getInstance();

        try {
            prop = Settings.load();
            MainMenuFunctionality mainMenuFunctionality;
            if(prop != null)
                mainMenuFunctionality = new MainMenuFunctionality(INSTANCE, prop);
            else {
                mainMenuFunctionality = new MainMenuFunctionality(INSTANCE);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private MainMenuGUI(){
        panel.setLayout(new GridLayout(0,1));
        add(panel);
        panel.add(menuTitle);
        panel.add(playButton);
        panel.add(settingsButton);
        panel.add(exitButton);
        panel.add(aboutButton);

        Utility.defaultFontSize(panel);

    }

    public static MainMenuGUI getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MainMenuGUI();
        }
        return INSTANCE;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getAboutButton() {
        return aboutButton;
    }

    public JLabel getMenuTitle() {
        return menuTitle;
    }

    public static Properties getProp() {
        return prop;
    }

    public static void setProp(Properties prop) {
        MainMenuGUI.prop = prop;
    }
}
