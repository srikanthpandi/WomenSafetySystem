package com.womensafety;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends JFrame {

    JTextField txtName, txtUsername, txtPhone;
    JTextField txtLatitude, txtLongitude;
    JPasswordField txtPassword;

    JButton btnRegister, btnBack;

    public Register() {

        setTitle("User Registration");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Name
        panel.add(new JLabel("Full Name"));
        txtName = new JTextField();
        panel.add(txtName);

        // Username
        panel.add(new JLabel("Username"));
        txtUsername = new JTextField();
        panel.add(txtUsername);

        // Password
        panel.add(new JLabel("Password"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        // Phone
        panel.add(new JLabel("Phone Number"));
        txtPhone = new JTextField();
        panel.add(txtPhone);

        // Latitude
        panel.add(new JLabel("Latitude"));
        txtLatitude = new JTextField();
        txtLatitude.setToolTipText("Example: 17.385044");
        panel.add(txtLatitude);

        // Longitude
        panel.add(new JLabel("Longitude"));
        txtLongitude = new JTextField();
        txtLongitude.setToolTipText("Example: 78.486671");
        panel.add(txtLongitude);

        // Buttons
        btnRegister = new JButton("Register");
        btnBack = new JButton("Back");

        panel.add(btnRegister);
        panel.add(btnBack);

        add(panel);

        // Back Button
        btnBack.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });

        // Register Button
        btnRegister.addActionListener(e -> {

            String name = txtName.getText().trim();
            String username = txtUsername.getText().trim();
            String password = String.valueOf(txtPassword.getPassword());
            String phone = txtPhone.getText().trim();
            String latitude = txtLatitude.getText().trim();
            String longitude = txtLongitude.getText().trim();

            if (name.isEmpty() || username.isEmpty() || password.isEmpty()
                    || phone.isEmpty() || latitude.isEmpty() || longitude.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            try {

                double lat = Double.parseDouble(latitude);
                double lon = Double.parseDouble(longitude);

                Connection con = Database.getConnection();

                String sql = "INSERT INTO users(name, username, password, phone, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, phone);
                ps.setDouble(5, lat);
                ps.setDouble(6, lon);

                int rows = ps.executeUpdate();

                System.out.println("Rows Inserted : " + rows);
                System.out.println("Latitude      : " + lat);
                System.out.println("Longitude     : " + lon);

                con.close();

                JOptionPane.showMessageDialog(this, "Registration Successful!");

                dispose();
                new Login().setVisible(true);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(this,
                        "Latitude and Longitude must be valid numbers.");

            } catch (Exception ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Registration Failed!");

            }

        });

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Register().setVisible(true));

    }

}