package com.womensafety;

import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JFrame {

    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin;

    public AdminLogin() {

        setTitle("Police Admin Login");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Username"));

        txtUser = new JTextField();
        panel.add(txtUser);

        panel.add(new JLabel("Password"));

        txtPass = new JPasswordField();
        panel.add(txtPass);

        btnLogin = new JButton("Login");
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> {

            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if(user.equals("admin") && pass.equals("admin123")){

                dispose();
                new PoliceDashboard().setVisible(true);

            }else{

                JOptionPane.showMessageDialog(this,"Invalid Login");

            }

        });

    }

}