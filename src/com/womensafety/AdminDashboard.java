package com.womensafety;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private StatsPanel statsPanel;

    private JTable table;

    private JTextField txtSearch;

    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnDelete;

    public AdminDashboard() {

        setTitle("Women Safety - Admin Dashboard");
        setSize(1200, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel title = new JLabel("👨‍💼 WOMEN SAFETY - ADMIN DASHBOARD", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(13, 71, 161));
        header.setPreferredSize(new Dimension(1200, 80));
        header.add(title, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);

        // Center Panel
        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(new Color(236,239,241));

        // Statistics Cards
        statsPanel = new StatsPanel();
        center.add(statsPanel, BorderLayout.NORTH);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        searchPanel.add(new JLabel("Search Username"));

        txtSearch = new JTextField(20);
        searchPanel.add(txtSearch);

        btnSearch = new JButton("🔍 Search");
        btnRefresh = new JButton("🔄 Refresh");

        searchPanel.add(btnSearch);
        searchPanel.add(btnRefresh);

        center.add(searchPanel, BorderLayout.CENTER);

        // Table
        String columns[] = {
                "ID",
                "Name",
                "Username",
                "Phone",
                "Latitude",
                "Longitude"
        };

        table = new JTable(new Object[][]{}, columns);

        table.setRowHeight(30);

        JScrollPane scroll = new JScrollPane(table);

        center.add(scroll, BorderLayout.SOUTH);

        add(center, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottom = new JPanel();

        btnDelete = new JButton("🗑 Delete User");

        bottom.add(btnDelete);

        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new AdminDashboard());

    }

}