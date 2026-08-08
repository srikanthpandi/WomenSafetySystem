package com.womensafety;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DashboardCard extends JPanel {

    private JLabel lblValue;

    public DashboardCard(String title, String value, Color color) {

        setPreferredSize(new Dimension(180,100));
        setBackground(color);
        setLayout(new BorderLayout());

        setBorder(new CompoundBorder(
                new LineBorder(color.darker(),1,true),
                new EmptyBorder(15,15,15,15)));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));

        lblValue = new JLabel(value);
        lblValue.setForeground(Color.WHITE);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 34));

        add(lblTitle, BorderLayout.NORTH);
        add(lblValue, BorderLayout.CENTER);
    }

    public void setValue(String value) {
        lblValue.setText(value);
    }
}