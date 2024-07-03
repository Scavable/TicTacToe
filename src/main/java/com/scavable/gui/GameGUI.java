package com.scavable.gui;

import com.scavable.functionality.GameFunctionality;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

//TODO: Use one frame only and switch out components and properties
public final class GameGUI extends JFrame {
    private static GameGUI INSTANCE = null;

    public GameGUI(){

    }

    public GameGUI(Properties prop){
        //Game layout
        getContentPane().setLayout(new GridLayout(3,3));

        new GameFunctionality(this, prop);
    }

    public static GameGUI getInstance(){
        if(INSTANCE == null){
            if(MainMenuGUI.getProp() != null)
                INSTANCE = new GameGUI(MainMenuGUI.getProp());
            else
                INSTANCE = new GameGUI();
        }
        return INSTANCE;
    }
}
