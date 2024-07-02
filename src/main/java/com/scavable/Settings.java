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
    //OS dependent file seperator
    private static final String separator = FileSystems.getDefault().getSeparator();

    public static boolean save(int windowSizeWidth, int windowSizeHeight, byte rounds, float turnTimeLimit, char symbols1, char symbols2) throws IOException {
        Properties prop = new Properties();

        String path = new File(".").getCanonicalPath().concat(separator+"settings.properties");

        FileOutputStream fos = new FileOutputStream(new File(".").getCanonicalPath().concat(separator+"settings.properties"));

        prop.setProperty("windowSizeWidth", String.valueOf(windowSizeWidth));
        prop.setProperty("windowSizeHeight", String.valueOf(windowSizeHeight));
        prop.setProperty("rounds", String.valueOf(rounds));
        prop.setProperty("turnTimeLimit", String.valueOf(turnTimeLimit));
        prop.setProperty("symbols1", String.valueOf(symbols1));
        prop.setProperty("symbols2", String.valueOf(symbols2));

        prop.storeToXML(fos, "Settings for Tic Tac Toe", StandardCharsets.UTF_8);

        fos.close();

        return new File(path).exists();
    }

    public static Properties load() throws IOException {
        Properties prop = new Properties();

        String path = new File(".").getCanonicalPath().concat(separator+"settings.properties");
        if(!new File(path).exists())
            return null;

        FileInputStream fis = new FileInputStream(new File(".").getCanonicalPath().concat(separator+"settings.properties"));
        prop.loadFromXML(fis);
        fis.close();

        if(prop.containsKey("windowSizeWidth") && prop.containsKey("windowSizeHeight") && prop.containsKey("rounds")
                && prop.containsKey("turnTimeLimit") && prop.containsKey("symbols1") && prop.containsKey("symbols2"))
            return prop;

        return null;
    }
}
