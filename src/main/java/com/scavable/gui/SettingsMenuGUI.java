package com.scavable.gui;

import com.scavable.functionality.SettingsMenuFunctionality;
import com.scavable.util.Utility;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public final class SettingsMenuGUI extends JFrame {

    private final JLabel title = new JLabel("Settings");

    private final JLabel windowSizeLabel = new JLabel("Window Size:");
    private final JPanel windowSizePanel = new JPanel();

    private final JTextField windowSizeWidthTextField = new JTextField("1920", 5);
    private final JTextField windowSizeHeightTextField = new JTextField("1080", 5);

    private final JLabel roundsLabel = new JLabel("Rounds:");
    private final JTextField roundsTextField = new JTextField("1", 2);

    private final JLabel turnTimeLimitLabel = new JLabel("Turn Time Limit:");
    private final JTextField turnTimeLimitTextField = new JTextField("5", 2);

    private final JLabel symbolsLabel = new JLabel("Symbols:");
    private final JPanel symbolsPanel = new JPanel();
    private final JTextField symbols1TextField = new JTextField("X", 2);
    private final JTextField symbols2TextField = new JTextField("O", 2);

    private final JButton saveButton = new JButton("Save");
    private final JButton cancelButton = new JButton("Cancel");

    //If no settings file exist
    public SettingsMenuGUI(){

        getContentPane().setLayout(new GridLayout(6,2));

        addToContentPane();

        Utility.defaultFontSize(getContentPane());

        SettingsMenuFunctionality settingsMenuFunctionality = new SettingsMenuFunctionality(this);
    }

    //If settings file exist
    public SettingsMenuGUI(Properties prop){

        windowSizeWidthTextField.setText(prop.getProperty("windowSizeWidth"));
        windowSizeHeightTextField.setText(prop.getProperty("windowSizeHeight"));
        roundsTextField.setText(prop.getProperty("rounds"));
        turnTimeLimitTextField.setText(prop.getProperty("turnTimeLimit"));
        symbols1TextField.setText(prop.getProperty("symbols1"));
        symbols2TextField.setText(prop.getProperty("symbols2"));

        getContentPane().setLayout(new GridLayout(6,2));

        addToContentPane();

        Utility.defaultFontSize(getContentPane());

        SettingsMenuFunctionality settingsMenuFunctionality = new SettingsMenuFunctionality(this);
    }

    private void addToContentPane() {
        getContentPane().add(title);
        getContentPane().add(new JLabel());

        getContentPane().add(windowSizeLabel);
        windowSizePanel.add(windowSizeWidthTextField);
        windowSizePanel.add(windowSizeHeightTextField);
        getContentPane().add(windowSizePanel);

        getContentPane().add(roundsLabel);
        getContentPane().add(roundsTextField);

        getContentPane().add(turnTimeLimitLabel);
        getContentPane().add(turnTimeLimitTextField);

        getContentPane().add(symbolsLabel);
        symbolsPanel.add(symbols1TextField);
        symbolsPanel.add(symbols2TextField);
        getContentPane().add(symbolsPanel);

        getContentPane().add(saveButton);
        getContentPane().add(cancelButton);
    }

    public JTextField getWindowSizeWidthTextField() {
        return windowSizeWidthTextField;
    }

    public JTextField getWindowSizeHeightTextField() {
        return windowSizeHeightTextField;
    }

    public JTextField getRoundsTextField() {
        return roundsTextField;
    }

    public JTextField getTurnTimeLimitTextField() {
        return turnTimeLimitTextField;
    }

    public JTextField getSymbols1TextField() {
        return symbols1TextField;
    }

    public JTextField getSymbols2TextField() {
        return symbols2TextField;
    }
    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

}
