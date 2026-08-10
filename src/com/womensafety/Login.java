
package com.womensafety;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnAdminLogin;

    private JCheckBox chkShowPassword;

    public Login() {

        setTitle("Women Safety System");
        setSize(1265, 585);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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

        JLabel subtitle = new JLabel("Your Safety, Our Priority");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitle.setForeground(Color.DARK_GRAY);

        JLabel info = new JLabel(
                "<html><center>"
                + "</center></html>");

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

        JPanel loginCard = new JPanel();
        loginCard.setPreferredSize(new Dimension(420, 500));
        loginCard.setBackground(Color.WHITE);

        loginCard.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(30, 30, 30, 30)));

        loginCard.setLayout(new BoxLayout(loginCard, BoxLayout.Y_AXIS));

        // ================= LOGIN TITLE =================

        JLabel loginTitle = new JLabel("");
        loginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));

        // ================= USERNAME =================

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 20));

        txtUsername = new JTextField();
        txtUsername.setMaximumSize(new Dimension(300, 42));
        txtUsername.setPreferredSize(new Dimension(300, 42));
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtUsername.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ================= PASSWORD =================

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));

        txtPassword = new JPasswordField();
        txtPassword.setMaximumSize(new Dimension(300, 42));
        txtPassword.setPreferredSize(new Dimension(300, 42));
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ================= SHOW PASSWORD =================

        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setBackground(Color.WHITE);
        chkShowPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        chkShowPassword.addActionListener(e -> {

            if (chkShowPassword.isSelected())
                txtPassword.setEchoChar((char) 0);
            else
                txtPassword.setEchoChar('•');

        });

        // ================= BUTTONS =================

        btnLogin = new JButton("LOGIN");
        btnRegister = new JButton("REGISTER");
        btnAdminLogin = new JButton("ADMIN LOGIN");

        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAdminLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnLogin.setMaximumSize(new Dimension(180, 40));
        btnRegister.setMaximumSize(new Dimension(180, 40));
        btnAdminLogin.setMaximumSize(new Dimension(180, 40));

        // LOGIN BUTTON

        btnLogin.setBackground(new Color(25, 118, 210));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);

        // REGISTER BUTTON

        btnRegister.setBackground(new Color(76, 175, 80));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFocusPainted(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setOpaque(true);

        // ADMIN LOGIN BUTTON

        btnAdminLogin.setBackground(new Color(156, 39, 176));
        btnAdminLogin.setForeground(Color.WHITE);
        btnAdminLogin.setFocusPainted(false);
        btnAdminLogin.setBorderPainted(false);
        btnAdminLogin.setOpaque(true);

        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnAdminLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // ==================================================
        // CENTER EVERYTHING INSIDE THE WHITE CARD
        // ==================================================

        loginCard.add(Box.createVerticalGlue());

        loginCard.add(loginTitle);

        loginCard.add(Box.createVerticalStrut(20));

        loginCard.add(lblUsername);
        loginCard.add(Box.createVerticalStrut(8));
        loginCard.add(txtUsername);

        loginCard.add(Box.createVerticalStrut(25));

        loginCard.add(lblPassword);
        loginCard.add(Box.createVerticalStrut(8));
        loginCard.add(txtPassword);

        loginCard.add(Box.createVerticalStrut(15));

        loginCard.add(chkShowPassword);

        loginCard.add(Box.createVerticalStrut(25));

        // LOGIN

        loginCard.add(btnLogin);

        loginCard.add(Box.createVerticalStrut(15));

        // REGISTER

        loginCard.add(btnRegister);

        loginCard.add(Box.createVerticalStrut(15));

        // ADMIN LOGIN

        loginCard.add(btnAdminLogin);

        loginCard.add(Box.createVerticalGlue());

        // ================= ADD CARD =================

        rightPanel.add(loginCard);

        // ================= ADD PANELS =================

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);

        // ================= LOGIN BUTTON =================

        btnLogin.addActionListener(e -> {

            String username = txtUsername.getText().trim();
            String password =
                    String.valueOf(txtPassword.getPassword());

            if (username.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Username and Password.");

                return;
            }

            try {

                Connection con = Database.getConnection();

                String sql =
                        "SELECT * FROM users WHERE username=? AND password=?";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    dispose();

                    new Dashboard(username).setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Username or Password.");

                }

                con.close();

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Database Connection Failed.");

            }

        });

        // ================= REGISTER BUTTON =================

        btnRegister.addActionListener(e -> {

            dispose();

            new Register().setVisible(true);

        });

        // ================= ADMIN LOGIN BUTTON =================

        btnAdminLogin.addActionListener(e -> {

            dispose();

            new AdminLogin().setVisible(true);

        });

        // ================= ENTER TO LOGIN =================

        getRootPane().setDefaultButton(btnLogin);

        // ================= FOCUS USERNAME =================

        SwingUtilities.invokeLater(() ->
                txtUsername.requestFocusInWindow());

    }

    // ================= MAIN =================

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {

            e.printStackTrace();

        }

        SwingUtilities.invokeLater(() -> {

            new Login().setVisible(true);

        });

    }
}
