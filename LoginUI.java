package com.smartprint.ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    private JTextField txtUsername;
    private JComboBox<String> cmbRole;

    public LoginUI() {
        setTitle("Smart Print Queue Management System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitle = new JLabel("Smart Print Queue System", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitle, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        centerPanel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        centerPanel.add(txtUsername);

        centerPanel.add(new JLabel("Role:"));
        cmbRole = new JComboBox<>(new String[]{"Student", "Operator"});
        centerPanel.add(cmbRole);

        add(centerPanel, BorderLayout.CENTER);

        JButton btnLogin = new JButton("Login");
        add(btnLogin, BorderLayout.SOUTH);

        btnLogin.addActionListener(e -> handleLogin());

        setVisible(true);
    }

    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String role = (String) cmbRole.getSelectedItem();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username.");
            return;
        }

        if ("Student".equals(role)) {
            new StudentUI(username).setVisible(true);
        } else {
            new OperatorUI(username).setVisible(true);
        }

        dispose(); // Close login window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginUI::new);
    }
}
