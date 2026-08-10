
package com.womensafety;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AdminLogin extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;

    private JButton btnLogin;
    private JButton btnBack;

    private JCheckBox chkShowPassword;

    public AdminLogin() {

        setTitle("Police Admin Login");
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

        JLabel title = new JLabel("Police Admin");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 34));
        title.setForeground(Color.BLACK);

        JLabel subtitle = new JLabel("Police Control Room");
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

        // ================= LOGIN CARD =================

        JPanel loginCard = new JPanel();

        loginCard.setPreferredSize(new Dimension(420, 500));
        loginCard.setBackground(Color.WHITE);

        loginCard.setBorder(new CompoundBorder(
                new LineBorder(
                        new Color(220, 220, 220),
                        1,
                        true
                ),
                new EmptyBorder(
                        30, 30, 30, 30
                )
        ));

        loginCard.setLayout(
                new BoxLayout(
                        loginCard,
                        BoxLayout.Y_AXIS
                )
        );

        // ================= TITLE =================

        JLabel loginTitle =
                new JLabel("ADMIN LOGIN");

        loginTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        loginTitle.setForeground(
                new Color(156, 39, 176)
        );

        // ================= USERNAME =================

        JLabel lblUsername =
                new JLabel("USERNAME");

        lblUsername.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        lblUsername.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        txtUser = new JTextField();

        txtUser.setMaximumSize(
                new Dimension(300, 42)
        );

        txtUser.setPreferredSize(
                new Dimension(300, 42)
        );

        txtUser.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        txtUser.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ================= PASSWORD =================

        JLabel lblPassword =
                new JLabel("PASSWORD");

        lblPassword.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        lblPassword.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        txtPass = new JPasswordField();

        txtPass.setMaximumSize(
                new Dimension(300, 42)
        );

        txtPass.setPreferredSize(
                new Dimension(300, 42)
        );

        txtPass.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        txtPass.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ================= SHOW PASSWORD =================

        chkShowPassword =
                new JCheckBox("Show Password");

        chkShowPassword.setBackground(
                Color.WHITE
        );

        chkShowPassword.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        chkShowPassword.addActionListener(e -> {

            if (chkShowPassword.isSelected()) {

                txtPass.setEchoChar((char) 0);

            } else {

                txtPass.setEchoChar('•');

            }

        });

        // ================= LOGIN BUTTON =================

        btnLogin =
                new JButton("ADMIN LOGIN");

        btnLogin.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        btnLogin.setMaximumSize(
                new Dimension(180, 40)
        );

        btnLogin.setBackground(
                new Color(156, 39, 176)
        );

        btnLogin.setForeground(
                Color.WHITE
        );

        btnLogin.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);

        // ================= BACK BUTTON =================

        btnBack =
                new JButton("BACK");

        btnBack.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        btnBack.setMaximumSize(
                new Dimension(180, 40)
        );

        btnBack.setBackground(
                new Color(96, 125, 139)
        );

        btnBack.setForeground(
                Color.WHITE
        );

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

        loginCard.add(Box.createVerticalGlue());

        loginCard.add(loginTitle);

        loginCard.add(
                Box.createVerticalStrut(30)
        );

        loginCard.add(lblUsername);

        loginCard.add(
                Box.createVerticalStrut(8)
        );

        loginCard.add(txtUser);

        loginCard.add(
                Box.createVerticalStrut(25)
        );

        loginCard.add(lblPassword);

        loginCard.add(
                Box.createVerticalStrut(8)
        );

        loginCard.add(txtPass);

        loginCard.add(
                Box.createVerticalStrut(15)
        );

        loginCard.add(chkShowPassword);

        loginCard.add(
                Box.createVerticalStrut(25)
        );

        loginCard.add(btnLogin);

        loginCard.add(
                Box.createVerticalStrut(15)
        );

        loginCard.add(btnBack);

        loginCard.add(Box.createVerticalGlue());

        // ================= ADD CARD =================

        rightPanel.add(loginCard);

        // ================= ADD PANELS =================

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);

        // ================= ADMIN LOGIN =================

        btnLogin.addActionListener(e -> {

            String user =
                    txtUser.getText().trim();

            String pass =
                    String.valueOf(
                            txtPass.getPassword()
                    );

            if (user.isEmpty() ||
                    pass.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Username and Password."
                );

                return;
            }

            if (user.equals("admin") &&
                    pass.equals("admin123")) {

                dispose();

                new PoliceDashboard()
                        .setVisible(true);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Admin Username or Password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        });

        // ================= BACK BUTTON =================

        btnBack.addActionListener(e -> {

            dispose();

            new Login().setVisible(true);

        });

        // ================= ENTER TO LOGIN =================

        getRootPane()
                .setDefaultButton(btnLogin);

        // ================= FOCUS =================

        SwingUtilities.invokeLater(() ->
                txtUser.requestFocusInWindow()
        );
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

        SwingUtilities.invokeLater(() -> {

            new AdminLogin()
                    .setVisible(true);

        });
    }
}

