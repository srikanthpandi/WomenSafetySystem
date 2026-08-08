package com.womensafety;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HeaderPanel extends JPanel {

    private JLabel timeLabel;

    public HeaderPanel(String username) {

        setLayout(new BorderLayout());
        setBackground(Theme.HEADER);
        setBorder(new EmptyBorder(20, 25, 20, 25));
        setPreferredSize(new Dimension(100, 120));

        // Left Side
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("WOMEN SAFETY SYSTEM");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.PRIMARY);

        JLabel welcome = new JLabel("Welcome, " + username);
        welcome.setFont(Theme.HEADER_FONT);
        welcome.setForeground(Theme.TEXT_DARK);

        leftPanel.add(title);
        leftPanel.add(Box.createVerticalStrut(6));
        leftPanel.add(welcome);

        // Right Side
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel(
                new SimpleDateFormat("dd MMM yyyy").format(new Date()));

        dateLabel.setFont(Theme.CARD_TITLE);

        timeLabel = new JLabel();
        timeLabel.setFont(Theme.HEADER_FONT);

        updateTime();

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        rightPanel.add(dateLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(timeLabel);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    private void updateTime() {

        timeLabel.setText(
                new SimpleDateFormat("hh:mm:ss a").format(new Date()));

    }
}