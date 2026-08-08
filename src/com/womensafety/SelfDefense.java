package com.womensafety;

import java.awt.Desktop;
import java.net.URI;

public class SelfDefense {

    public static void openVideo() {

        try {

            Desktop.getDesktop().browse(
                new URI("https://www.youtube.com/results?search_query=women+self+defense+techniques"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}