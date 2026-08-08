package com.womensafety;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FeatureCard extends JPanel {

    public FeatureCard(String title, String description, String iconName, Runnable action) {

        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(240, 150));

        setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(20, 20, 20, 20)));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // ================= TOP =================

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        topPanel.setOpaque(false);

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(IconUtil.getIcon(iconName, 32, 32));

        topPanel.add(iconLabel);

        // ================= CENTER =================

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTitle.setForeground(new Color(33, 37, 41));

        JLabel lblDesc = new JLabel(
                "<html><div style='width:180px;'>" + description + "</div></html>");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDesc.setForeground(Color.GRAY);

        centerPanel.add(lblTitle);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(lblDesc);

        // ================= BOTTOM =================

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        bottomPanel.setOpaque(false);

        JLabel openLabel = new JLabel("Open  ➜");
        openLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        openLabel.setForeground(new Color(37, 99, 235));

        bottomPanel.add(openLabel);

        // ================= ADD COMPONENTS =================

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // ================= HOVER EFFECT =================

        MouseAdapter mouse = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setBackground(new Color(240, 248, 255));

                setBorder(new CompoundBorder(
                        new LineBorder(new Color(37, 99, 235), 2, true),
                        new EmptyBorder(20, 20, 20, 20)));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(Color.WHITE);

                setBorder(new CompoundBorder(
                        new LineBorder(new Color(220, 220, 220), 1, true),
                        new EmptyBorder(20, 20, 20, 20)));
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                if (action != null) {
                    action.run();
                }
            }
        };

        addMouseListener(mouse);

        // Make child components clickable too
        for (Component c : getComponents()) {
            c.addMouseListener(mouse);
        }
    }
}