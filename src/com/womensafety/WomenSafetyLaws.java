package com.womensafety;

import javax.swing.*;
import java.awt.*;

public class WomenSafetyLaws extends JFrame {

    public WomenSafetyLaws() {

        setTitle("Women Safety Laws");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();

        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        textArea.setText(

                "WOMEN SAFETY LAWS IN INDIA\n\n"

                + "1. IPC Section 354\n"
                + "   Assault or criminal force against a woman.\n\n"

                + "2. IPC Section 376\n"
                + "   Punishment for rape.\n\n"

                + "3. Domestic Violence Act, 2005\n"
                + "   Protection against domestic violence.\n\n"

                + "4. Sexual Harassment of Women at Workplace Act, 2013\n"
                + "   Protects women at workplaces.\n\n"

                + "5. Dowry Prohibition Act, 1961\n"
                + "   Prohibits giving and taking dowry.\n\n"

                + "6. Protection of Women from Domestic Violence Act\n"
                + "   Ensures legal protection and support.\n\n"

                + "Stay aware of your legal rights and seek help whenever required."
        );

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane);

        setVisible(true);
    }
}