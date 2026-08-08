package com.womensafety;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HeaderPanelPolice extends JPanel {

    private JLabel lblTime;

    public HeaderPanelPolice() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 80));
        setBackground(new Color(25, 118, 210));

        // Left Title
        JLabel lblTitle = new JLabel("WOMEN SAFETY - POLICE CONTROL ROOM");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        add(lblTitle, BorderLayout.WEST);

        // Right Time
        lblTime = new JLabel();
        lblTime.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTime.setForeground(Color.WHITE);
        lblTime.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        add(lblTime, BorderLayout.EAST);

        // Live Clock
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime();
    }

    private void updateTime() {

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd MMM yyyy | hh:mm:ss a");

        lblTime.setText(sdf.format(new Date()));
    }
}