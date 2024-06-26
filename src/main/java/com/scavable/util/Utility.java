package com.scavable.util;

import javax.swing.*;
import java.awt.*;

public final class Utility {

    public static void defaultFontSize(Component... component) {
        for (Component c : component) {
            System.out.println(c);
            if (c instanceof JPanel) {
                defaultFontSize(((JPanel)c).getComponents());
            }
            if (c instanceof JLabel) {
                c.setFont(c.getFont().deriveFont(20f));
            }
            if (c instanceof JTextField) {
                c.setFont(c.getFont().deriveFont(20f));
            }
            if (c instanceof JButton) {
                c.setFont(c.getFont().deriveFont(20f));
            }

        }

    }
}
