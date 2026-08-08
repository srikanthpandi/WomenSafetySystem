package com.womensafety;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class SidebarPanel extends JPanel {

    private String username;

    public SidebarPanel(String username) {

        this.username = username;

        // Sidebar Background (Baby Pink)
        setBackground(new Color(248, 187, 208));
        setPreferredSize(new Dimension(240, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Logo
        JLabel logo = new JLabel("WomenSafety");
        logo.setIcon(IconUtil.getIcon("shield.png", 42, 42));
        logo.setIconTextGap(12);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 21));
        logo.setForeground(Color.BLACK);
        logo.setBorder(new EmptyBorder(25, 20, 25, 20));

        add(logo);
        add(Box.createVerticalStrut(15));

        add(createMenu("Dashboard", "shield.png", () -> {}));

        add(createMenu("Contacts", "contacts.png",
                () -> new EmergencyContacts(username).setVisible(true)));

        add(createMenu("SOS Alert", "alarm.png",
                () -> SOSAlert.sendSOS(username)));

        add(createMenu("SOS History", "history.png",
                () -> new SOSHistory(username).setVisible(true)));

        add(createMenu("Nearby Police", "police.png",
                () -> PoliceStation.openPoliceMap()));

        add(createMenu("Nearby Hospital", "hospital.png",
                () -> Hospital.openHospitalMap()));

        add(createMenu("Women Safety Laws", "law.png",
                () -> new WomenSafetyLaws()));

        add(createMenu("Self Defense", "karate.png",
                () -> SelfDefense.openVideo()));

        add(createMenu("Helpline", "phone.png",
                () -> new Helpline()));

        add(Box.createVerticalGlue());

        add(createMenu("Logout", "logout.png",
                () -> {

                    Window window = SwingUtilities.getWindowAncestor(this);

                    if (window != null) {
                        window.dispose();
                    }

                    new Login().setVisible(true);

                }));
    }

    private JPanel createMenu(String text, String iconName, Runnable action) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        panel.setPreferredSize(new Dimension(240, 55));
        panel.setBackground(new Color(255, 228, 235));
        panel.setBorder(new EmptyBorder(8, 15, 8, 15));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 2));
        content.setOpaque(false);

        JLabel icon = new JLabel(IconUtil.getIcon(iconName, 24, 24));

        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label.setForeground(Color.BLACK);

        content.add(icon);
        content.add(label);

        panel.add(content, BorderLayout.CENTER);

        MouseAdapter mouse = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                panel.setBackground(new Color(255, 192, 203));

            }

            @Override
            public void mouseExited(MouseEvent e) {

                panel.setBackground(new Color(255, 228, 235));

            }

            @Override
            public void mouseClicked(MouseEvent e) {

                if (action != null) {
                    action.run();
                }

            }

        };

        panel.addMouseListener(mouse);
        content.addMouseListener(mouse);
        icon.addMouseListener(mouse);
        label.addMouseListener(mouse);

        return panel;
    }
}