package com.womensafety;

import javax.sound.sampled.*;

public class Siren {

    public static void playSiren() {

        try {

            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    Siren.class.getResource("/com/womensafety/siren.wav"));

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Unable to play siren.\nCheck if siren.wav is inside src/com/womensafety");
        }
    }
}