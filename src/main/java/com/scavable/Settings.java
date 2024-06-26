package com.scavable;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.Properties;

public class Settings {
    private static final String separator = FileSystems.getDefault().getSeparator();

    public static boolean save(Dimension windowSize, byte rounds, float turnTimeLimit, char[] symbols) throws IOException {
        Properties prop = new Properties();

        String path = new File(".").getCanonicalPath().concat(separator+"settings.properties");

        FileOutputStream fos = new FileOutputStream(new File(".").getCanonicalPath().concat(separator+"settings.properties"));

        prop.setProperty("windowSize", windowSize.getWidth() + "," + windowSize.getHeight());
        prop.setProperty("rounds", String.valueOf(rounds));
        prop.setProperty("turnTimeLimit", String.valueOf(turnTimeLimit));
        prop.setProperty("symbols", String.valueOf(symbols));

        prop.storeToXML(fos, "Settings for Tic Tac Toe", StandardCharsets.UTF_8);

        fos.close();

        return new File(path).exists();
    }

    public static boolean load() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(new File(".").getCanonicalPath().concat(separator+"settings.properties"));
        prop.load(fis);
        fis.close();

        return prop.containsKey("windowSize") && prop.containsKey("rounds") && prop.containsKey("turnTimeLimit") && prop.containsKey("symbols");
    }
}
