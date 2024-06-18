package GUI;

import Functionality.SettingsMenuFunctionality;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public final class SettingsMenuGUI extends JFrame {

    private final JLabel title = new JLabel("Settings");

    private final JLabel windowSizeLabel = new JLabel("Window Size:");
    private final JPanel windowSizePanel = new JPanel();
    private final JTextField windowSizeWidthTextField = new JTextField("Width", 5);
    private final JTextField windowSizeHeightTextField = new JTextField("Height", 5);

    private final JLabel roundsLabel = new JLabel("Rounds:");
    private final JTextField roundsTextField = new JTextField("Rounds", 2);

    private final JLabel turnTimeLimitLabel = new JLabel("Turn Time Limit:");
    private final JTextField turnTimeLimitTextField = new JTextField("5", 2);

    private final JLabel symbolsLabel = new JLabel("Symbols:");
    private final JPanel symbolsPanel = new JPanel();
    private final JTextField symbols1TextField = new JTextField("X", 2);
    private final JTextField symbols2TextField = new JTextField("O", 2);

    public SettingsMenuGUI(){

        getContentPane().setLayout(new GridLayout(5,2));

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

        SettingsMenuFunctionality settingsMenuFunctionality = new SettingsMenuFunctionality(this);
    }

}
