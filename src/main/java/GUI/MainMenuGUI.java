package GUI;

import Functionality.MainMenuFunctionality;

import javax.swing.*;
import java.awt.*;

public final class MainMenuGUI extends JFrame {
    private static MainMenuGUI INSTANCE = null;
    private final JPanel panel = new JPanel();

    private final JLabel title = new JLabel("Main Menu");
    private final JButton playButton = new JButton("Play");
    private final JButton exitButton = new JButton("Exit");
    private final JButton settingsButton = new JButton("Settings");
    private final JButton aboutButton = new JButton("About");

    public static void main(String[] args) {
        INSTANCE = MainMenuGUI.getInstance();
        MainMenuFunctionality mainMenuFunctionality = new MainMenuFunctionality(INSTANCE);
    }

    private MainMenuGUI(){
        panel.setLayout(new GridLayout(0,1));
        add(panel);
        panel.add(title);
        panel.add(playButton);
        panel.add(settingsButton);
        panel.add(exitButton);
        panel.add(aboutButton);


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
}
