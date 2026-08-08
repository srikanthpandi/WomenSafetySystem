package com.womensafety;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SOSHistory extends JFrame {

    JTable table;
    DefaultTableModel model;

    public SOSHistory(String username) {

        setTitle("SOS History");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Alert Time");

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadHistory(username);

        setVisible(true);
    }

    private void loadHistory(String username) {

        try {

            Connection con = Database.getConnection();

            String sql = "SELECT * FROM sos_history WHERE username=? ORDER BY alert_time DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getTimestamp("alert_time")

                });

            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }

    }

}