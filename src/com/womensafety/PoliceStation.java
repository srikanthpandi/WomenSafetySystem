package com.womensafety;

import java.awt.Desktop;
import java.net.URI;

public class PoliceStation {

    public static void openPoliceMap() {

        try {

            Desktop.getDesktop().browse(
                    new URI("https://www.google.com/maps/search/police+station+near+me"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}