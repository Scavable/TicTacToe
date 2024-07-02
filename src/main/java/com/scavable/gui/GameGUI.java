package com.scavable.gui;

import com.scavable.functionality.GameFunctionality;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

//TODO: Use one frame only and switch out components and properties
public final class GameGUI extends JFrame {
    public GameGUI(Properties prop){
        //Game layout
        getContentPane().setLayout(new GridLayout(3,3));
        for(int i = 0; i<9; i++){
            getContentPane().add(new JButton(""));
        }
        System.out.println(prop.keySet());
        new GameFunctionality(this, prop);
    }
}
