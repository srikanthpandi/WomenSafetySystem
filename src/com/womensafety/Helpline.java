package com.womensafety;

import javax.swing.*;
import java.awt.*;

public class Helpline extends JFrame {

    public Helpline() {

        setTitle("Emergency Helpline Numbers");
        setSize(450,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();

        area.setEditable(false);
        area.setFont(new Font("Arial", Font.BOLD, 16));

        area.setText(
                "EMERGENCY HELPLINE NUMBERS\n\n" +

                "National Emergency : 112\n\n" +

                "Women Helpline     : 181\n\n" +

                "Police             : 100\n\n" +

                "Ambulance          : 108\n\n" +

                "Fire Service       : 101\n\n" +

                "Cyber Crime        : 1930\n\n" +

                "Child Helpline     : 1098"
        );

        add(new JScrollPane(area));

        setVisible(true);
    }
}