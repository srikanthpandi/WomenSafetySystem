
package com.womensafety;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends JFrame {

    JTextField txtName, txtUsername, txtPhone;
    JTextField txtLatitude, txtLongitude;
    JPasswordField txtPassword;

    JButton btnRegister, btnBack;

    public Register() {

        setTitle("Women Safety System - User Registration");
        setSize(1265, 585);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // ================= LEFT PANEL =================

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 228, 236));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createVerticalGlue());

        JLabel logo = new JLabel("🛡");
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));

        JLabel title = new JLabel("Women Safety");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 34));
        title.setForeground(Color.BLACK);

        JLabel subtitle = new JLabel("Create Your Account");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitle.setForeground(Color.DARK_GRAY);

        JLabel info = new JLabel(
                "<html><center>"
                 
                + "</center></html>"
        );

        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        info.setForeground(new Color(60, 60, 60));

        leftPanel.add(logo);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(title);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(subtitle);
        leftPanel.add(Box.createVerticalStrut(35));
        leftPanel.add(info);

        leftPanel.add(Box.createVerticalGlue());

        // ================= RIGHT PANEL =================

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(240, 248, 255));

        // ================= REGISTER CARD =================

        JPanel registerCard = new JPanel();

        registerCard.setPreferredSize(new Dimension(500, 530));
        registerCard.setBackground(Color.WHITE);

        registerCard.setBorder(new CompoundBorder(
                new LineBorder(
                        new Color(220, 220, 220),
                        1,
                        true
                ),
                new EmptyBorder(
                        25, 35, 25, 35
                )
        ));

        registerCard.setLayout(
                new BoxLayout(
                        registerCard,
                        BoxLayout.Y_AXIS
                )
        );

        // ================= TITLE =================

        JLabel registerTitle =
                new JLabel("USER REGISTRATION");

        registerTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        registerTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        registerTitle.setForeground(
                new Color(25, 118, 210)
        );

        // ================= NAME =================

        JLabel lblName = createLabel("FULL NAME");

        txtName = createTextField();

        // ================= USERNAME =================

        JLabel lblUsername = createLabel("USERNAME");

        txtUsername = createTextField();

        // ================= PASSWORD =================

        JLabel lblPassword = createLabel("PASSWORD");

        txtPassword = new JPasswordField();

        txtPassword.setMaximumSize(
                new Dimension(350, 38)
        );

        txtPassword.setPreferredSize(
                new Dimension(350, 38)
        );

        txtPassword.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        // ================= PHONE =================

        JLabel lblPhone = createLabel("PHONE NUMBER");

        txtPhone = createTextField();

        // ================= LATITUDE =================

        JLabel lblLatitude = createLabel("LATITUDE");

        txtLatitude = createTextField();

        txtLatitude.setToolTipText(
                "Example: 17.385044"
        );

        // ================= LONGITUDE =================

        JLabel lblLongitude = createLabel("LONGITUDE");

        txtLongitude = createTextField();

        txtLongitude.setToolTipText(
                "Example: 78.486671"
        );

        // ================= BUTTONS =================

        btnRegister =
                new JButton("REGISTER");

        btnBack =
                new JButton("BACK");

        // Register Button

        btnRegister.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        btnRegister.setMaximumSize(
                new Dimension(180, 40)
        );

        btnRegister.setBackground(
                new Color(76, 175, 80)
        );

        btnRegister.setForeground(Color.WHITE);

        btnRegister.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        btnRegister.setFocusPainted(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setOpaque(true);

        // Back Button

        btnBack.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        btnBack.setMaximumSize(
                new Dimension(180, 40)
        );

        btnBack.setBackground(
                new Color(96, 125, 139)
        );

        btnBack.setForeground(Color.WHITE);

        btnBack.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        btnBack.setFocusPainted(false);
        btnBack.setBorderPainted(false);
        btnBack.setOpaque(true);

        // ================= ADD COMPONENTS =================

        registerCard.add(Box.createVerticalGlue());

        registerCard.add(registerTitle);

        registerCard.add(
                Box.createVerticalStrut(18)
        );

        // Name

        registerCard.add(lblName);
        registerCard.add(Box.createVerticalStrut(5));
        registerCard.add(txtName);

        registerCard.add(Box.createVerticalStrut(10));

        // Username

        registerCard.add(lblUsername);
        registerCard.add(Box.createVerticalStrut(5));
        registerCard.add(txtUsername);

        registerCard.add(Box.createVerticalStrut(10));

        // Password

        registerCard.add(lblPassword);
        registerCard.add(Box.createVerticalStrut(5));
        registerCard.add(txtPassword);

        registerCard.add(Box.createVerticalStrut(10));

        // Phone

        registerCard.add(lblPhone);
        registerCard.add(Box.createVerticalStrut(5));
        registerCard.add(txtPhone);

        registerCard.add(Box.createVerticalStrut(10));

        // Latitude

        registerCard.add(lblLatitude);
        registerCard.add(Box.createVerticalStrut(5));
        registerCard.add(txtLatitude);

        registerCard.add(Box.createVerticalStrut(10));

        // Longitude

        registerCard.add(lblLongitude);
        registerCard.add(Box.createVerticalStrut(5));
        registerCard.add(txtLongitude);

        registerCard.add(Box.createVerticalStrut(18));

        // Buttons

        registerCard.add(btnRegister);

        registerCard.add(
                Box.createVerticalStrut(10)
        );

        registerCard.add(btnBack);

        registerCard.add(Box.createVerticalGlue());

        // ================= ADD CARD =================

        rightPanel.add(registerCard);

        // ================= ADD PANELS =================

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);

        // ================= BACK BUTTON =================

        btnBack.addActionListener(e -> {

            dispose();

            new Login().setVisible(true);

        });

        // ================= REGISTER BUTTON =================

        btnRegister.addActionListener(e -> {

            String name =
                    txtName.getText().trim();

            String username =
                    txtUsername.getText().trim();

            String password =
                    String.valueOf(
                            txtPassword.getPassword()
                    );

            String phone =
                    txtPhone.getText().trim();

            String latitude =
                    txtLatitude.getText().trim();

            String longitude =
                    txtLongitude.getText().trim();

            // ================= VALIDATION =================

            if (name.isEmpty()
                    || username.isEmpty()
                    || password.isEmpty()
                    || phone.isEmpty()
                    || latitude.isEmpty()
                    || longitude.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields.",
                        "Registration",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            try {

                double lat =
                        Double.parseDouble(latitude);

                double lon =
                        Double.parseDouble(longitude);

                // ================= DATABASE =================

                Connection con =
                        Database.getConnection();

                String sql =
                        "INSERT INTO users"
                        + "(name, username, password, phone, latitude, longitude)"
                        + " VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, phone);
                ps.setDouble(5, lat);
                ps.setDouble(6, lon);

                int rows =
                        ps.executeUpdate();

                System.out.println(
                        "Rows Inserted : " + rows
                );

                System.out.println(
                        "Latitude      : " + lat
                );

                System.out.println(
                        "Longitude     : " + lon
                );

                ps.close();
                con.close();

                // ================= SUCCESS =================

                JOptionPane.showMessageDialog(
                        this,
                        "Registration Successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose();

                new Login().setVisible(true);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Latitude and Longitude must be valid numbers.",
                        "Invalid Location",
                        JOptionPane.ERROR_MESSAGE
                );

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Registration Failed!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        });

        // ================= ENTER TO REGISTER =================

        getRootPane()
                .setDefaultButton(btnRegister);

        // ================= INITIAL FOCUS =================

        SwingUtilities.invokeLater(() ->
                txtName.requestFocusInWindow()
        );
    }

    // ==================================================
    // CREATE LABEL
    // ==================================================

    private JLabel createLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        label.setForeground(Color.BLACK);

        return label;
    }

    // ==================================================
    // CREATE TEXT FIELD
    // ==================================================

    private JTextField createTextField() {

        JTextField field =
                new JTextField();

        field.setMaximumSize(
                new Dimension(350, 38)
        );

        field.setPreferredSize(
                new Dimension(350, 38)
        );

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        field.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        return field;
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager
                            .getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            e.printStackTrace();

        }

        SwingUtilities.invokeLater(() ->
                new Register().setVisible(true)
        );
    }
}
