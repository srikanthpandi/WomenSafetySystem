package com.womensafety;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private String username;

    public Dashboard(String username) {

        this.username = username;

        setTitle("Women Safety System");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Theme.BACKGROUND);
        setLayout(new BorderLayout());

        // Sidebar
        add(new SidebarPanel(username), BorderLayout.WEST);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Theme.BACKGROUND);

        // Header
        mainPanel.add(new HeaderPanel(username), BorderLayout.NORTH);

        // Cards Panel
        JPanel cardsPanel = new JPanel(new GridLayout(3, 3, 15, 15));
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cardsPanel.setBackground(Theme.BACKGROUND);

        // SOS
        cardsPanel.add(new FeatureCard(
                "SOS Alert",
                "Send emergency alert instantly",
                "alarm.png",
                () -> SOSAlert.sendSOS(username)
        ));
//alaram
        cardsPanel.add(new FeatureCard(
                "SOS Alert",
                "Send emergency alert instantly",
                "contacts.png",
                () -> SOSAlert.sendSOS(username)
        ));
        // Contacts
        cardsPanel.add(new FeatureCard(
                "Emergency Contacts",
                "Manage emergency contacts",
                "contacts.png",
                () -> new EmergencyContacts(username).setVisible(true)
        ));

        // History
        cardsPanel.add(new FeatureCard(
                "SOS History",
                "View previous SOS alerts",
                "history.png",
                () -> new SOSHistory(username).setVisible(true)
        ));

        // Police
        cardsPanel.add(new FeatureCard(
                "Nearby Police",
                "Locate nearby police stations",
                "police.png",
                () -> PoliceStation.openPoliceMap()
        ));

        // Hospital
        cardsPanel.add(new FeatureCard(
                "Nearby Hospital",
                "Find nearby hospitals",
                "hospital.png",
                () -> Hospital.openHospitalMap()
        ));

        // Laws
        cardsPanel.add(new FeatureCard(
                "Women Safety Laws",
                "Know your legal rights",
                "law.png",
                () -> new WomenSafetyLaws()
        ));

        // Self Defense
        cardsPanel.add(new FeatureCard(
                "Self Defense",
                "Watch self-defense videos",
                "karate.png",
                () -> SelfDefense.openVideo()
        ));

        // Helpline
        cardsPanel.add(new FeatureCard(
                "Helpline",
                "Emergency contact numbers",
                "phone.png",
                () -> new Helpline()
        ));

        // Logout
        cardsPanel.add(new FeatureCard(
                "Logout",
                "Exit your account",
                "logout.png",
                () -> {
                    dispose();
                    new Login().setVisible(true);
                }
        ));

        mainPanel.add(cardsPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}