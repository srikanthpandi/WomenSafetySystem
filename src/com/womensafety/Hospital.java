package com.womensafety;

import java.awt.Desktop;
import java.net.URI;

public class Hospital {

    public static void openHospitalMap() {

        try {

            Desktop.getDesktop().browse(
                    new URI("https://www.google.com/maps/search/hospital+near+me"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}