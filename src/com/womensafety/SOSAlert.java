package com.womensafety;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class SOSAlert {

    public static void sendSOS(String username) {

        try (Connection con = Database.getConnection()) {

            double latitude = 0.0;
            double longitude = 0.0;

            // Fetch user's registered location
            String locationSql = "SELECT latitude, longitude FROM users WHERE username=?";

            PreparedStatement locationPs = con.prepareStatement(locationSql);
            locationPs.setString(1, username);

            ResultSet rs = locationPs.executeQuery();

            if (rs.next()) {
                latitude = rs.getDouble("latitude");
                longitude = rs.getDouble("longitude");
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "User location not found!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }

            // Save SOS Alert
            String alertSql = "INSERT INTO sos_alerts(username, message, latitude, longitude, status) VALUES(?,?,?,?,?)";

            PreparedStatement alertPs = con.prepareStatement(alertSql);

            alertPs.setString(1, username);
            alertPs.setString(2, "I am in danger. Please help.");
            alertPs.setDouble(3, latitude);
            alertPs.setDouble(4, longitude);
            alertPs.setString(5, "ACTIVE");

            alertPs.executeUpdate();

            // Save SOS History
            String historySql = "INSERT INTO sos_history(username) VALUES(?)";

            PreparedStatement historyPs = con.prepareStatement(historySql);
            historyPs.setString(1, username);
            historyPs.executeUpdate();

            // Success dialog
            JOptionPane optionPane = new JOptionPane(
                    "🚨 SOS Activated!",
                    JOptionPane.INFORMATION_MESSAGE);

            JDialog dialog = optionPane.createDialog("SOS Alert");

            Timer timer = new Timer(2000, e -> {
                dialog.dispose();
                Siren.playSiren();
            });

            timer.setRepeats(false);
            timer.start();

            dialog.setVisible(true);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    null,
                    "Failed to activate SOS Alert.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}