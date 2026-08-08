package com.womensafety;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.Desktop;
import java.net.URI;
import java.sql.*;

public class PoliceDashboard extends JFrame {

    private int lastAlertId = 0;
    private boolean firstLoad = true;

    private JTable table;
    private DefaultTableModel model;

    private JButton btnRefresh;
    private JButton btnResolve;
    private JButton btnLocation;

    private StatsPanel statsPanel;

    private Timer refreshTimer;

    public PoliceDashboard() {

        setTitle("Women Safety - Police Control Room");
        setSize(1200, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        add(new HeaderPanelPolice(), BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240,242,247));

        // Statistics
        statsPanel = new StatsPanel();
        statsPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        centerPanel.add(statsPanel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Message");
        model.addColumn("Latitude");
        model.addColumn("Longitude");
        model.addColumn("Alert Time");
        model.addColumn("Status");

        table = new JTable(model);

        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        table.setSelectionBackground(new Color(33, 150, 243)); // Blue
        table.setSelectionForeground(Color.WHITE);

        table.setGridColor(new Color(220, 220, 220));

        table.setRowHeight(34);

        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setFocusable(true);
        table.setDefaultEditor(Object.class, null); // Read-only
        table.setRowHeight(34);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(25,118,210));
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER,20,15));
        bottom.setBackground(new Color(245,247,250));

        btnRefresh = new JButton("Refresh");
        btnResolve = new JButton("Resolve");
        btnLocation = new JButton("Open Location");

        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);

        btnRefresh.setFont(btnFont);
        btnResolve.setFont(btnFont);
        btnLocation.setFont(btnFont);

        btnRefresh.setFocusable(false);
        btnResolve.setFocusable(false);
        btnLocation.setFocusable(false);

        bottom.add(btnRefresh);
        bottom.add(btnResolve);
        bottom.add(btnLocation);

        add(bottom, BorderLayout.SOUTH);

        loadAlerts();
        loadStatistics();

        refreshTimer = new Timer(5000, e -> {

            if (table.getSelectedRow() == -1) {
                loadAlerts();
                loadStatistics();
            }

        });

        refreshTimer.start();

        btnRefresh.addActionListener(e -> {

            loadAlerts();
            loadStatistics();

        });

        btnResolve.addActionListener(e -> resolveAlert());

        btnLocation.addActionListener(e -> openLocation());

        setVisible(true);
    }
    private void loadAlerts() {

        try {

            int selectedId = -1;

            if (table.getSelectedRow() != -1) {
                selectedId = Integer.parseInt(
                        model.getValueAt(table.getSelectedRow(), 0).toString());
            }

            model.setRowCount(0);

            Connection con = Database.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM sos_alerts ORDER BY id DESC");

            ResultSet rs = ps.executeQuery();

            int newestId = lastAlertId;
            int rowIndex = 0;
            int selectedRow = -1;

            while (rs.next()) {

                int id = rs.getInt("id");

                if (id > newestId) {
                    newestId = id;
                }

                model.addRow(new Object[]{
                        id,
                        rs.getString("username"),
                        rs.getString("message"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getTimestamp("alert_time"),
                        rs.getString("status")
                });

                if (id == selectedId) {
                    selectedRow = rowIndex;
                }

                rowIndex++;
            }

            if (selectedRow != -1) {
                table.setRowSelectionInterval(selectedRow, selectedRow);
            }

            con.close();

            // Ignore existing alerts when dashboard first opens
            if (firstLoad) {
                lastAlertId = newestId;
                firstLoad = false;
                return;
            }

            // New SOS Alert
            if (newestId > lastAlertId) {

                lastAlertId = newestId;

                new Thread(() -> {

                    Siren.playSiren();

                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    Siren.playSiren();

                }).start();

                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(
                                this,
                                "🚨 NEW SOS ALERT RECEIVED!",
                                "Police Control Room",
                                JOptionPane.WARNING_MESSAGE));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStatistics() {

        try {

            Connection con = Database.getConnection();

            // Active Alerts
            PreparedStatement ps1 = con.prepareStatement(
                    "SELECT COUNT(*) FROM sos_alerts WHERE status='ACTIVE'");
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                statsPanel.activeCard.setValue(String.valueOf(rs1.getInt(1)));
            }

            // Resolved Alerts
            PreparedStatement ps2 = con.prepareStatement(
                    "SELECT COUNT(*) FROM sos_alerts WHERE status='RESOLVED'");
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                statsPanel.resolvedCard.setValue(String.valueOf(rs2.getInt(1)));
            }

            // Total Users
            PreparedStatement ps3 = con.prepareStatement(
                    "SELECT COUNT(*) FROM users");
            ResultSet rs3 = ps3.executeQuery();

            if (rs3.next()) {
                statsPanel.usersCard.setValue(String.valueOf(rs3.getInt(1)));
            }

            // Today's Alerts
            PreparedStatement ps4 = con.prepareStatement(
                    "SELECT COUNT(*) FROM sos_alerts WHERE DATE(alert_time)=CURDATE()");
            ResultSet rs4 = ps4.executeQuery();

            if (rs4.next()) {
                statsPanel.todayCard.setValue(String.valueOf(rs4.getInt(1)));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void resolveAlert() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select an alert.");
            return;
        }

        int id = Integer.parseInt(model.getValueAt(row, 0).toString());

        try {

            Connection con = Database.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE sos_alerts SET status='RESOLVED' WHERE id=?");

            ps.setInt(1, id);

            int updated = ps.executeUpdate();

            con.close();

            if (updated > 0) {

                JOptionPane.showMessageDialog(this,
                        "Alert marked as RESOLVED.");

                loadAlerts();
                loadStatistics();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Unable to update alert.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void openLocation() {

        int row = table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this,
                    "Please select an alert.");

            return;
        }

        try {

            double latitude = Double.parseDouble(
                    model.getValueAt(row, 3).toString());

            double longitude = Double.parseDouble(
                    model.getValueAt(row, 4).toString());

            if (latitude == 0.0 && longitude == 0.0) {

                JOptionPane.showMessageDialog(this,
                        "Location is not available for this alert.");

                return;
            }

            Desktop.getDesktop().browse(
                    new URI("https://www.google.com/maps?q="
                            + latitude + "," + longitude));

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(this,
                    "Unable to open location.");

        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new PoliceDashboard());

    }}