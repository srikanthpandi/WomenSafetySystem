package com.womensafety;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmergencyContacts extends JFrame {

    private String username;

    JTextField txtName, txtPhone;
    JButton btnSave;

    public EmergencyContacts(String username) {

        this.username = username;

        setTitle("Emergency Contacts");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Contact Name"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Phone Number"));
        txtPhone = new JTextField();
        panel.add(txtPhone);

        btnSave = new JButton("Save Contact");
        panel.add(btnSave);

        add(panel);

        btnSave.addActionListener(e -> {

            String name = txtName.getText();
            String phone = txtPhone.getText();

            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            try {

                Connection con = Database.getConnection();

                String sql = "INSERT INTO emergency_contacts(username, contact_name, contact_phone) VALUES(?, ?, ?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, username);
                ps.setString(2, name);
                ps.setString(3, phone);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Contact Saved Successfully!");

                txtName.setText("");
                txtPhone.setText("");

                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to Save Contact!");
            }

        });
    }
}