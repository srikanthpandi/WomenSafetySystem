package com.womensafety;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class IconUtil {

    public static ImageIcon getIcon(String fileName, int width, int height) {

        URL url = IconUtil.class.getResource("/com/womensafety/icons/" + fileName);

        if (url == null) {
            System.out.println("Icon not found : " + fileName);
            return null;
        }

        ImageIcon icon = new ImageIcon(url);

        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(img);
    }
}