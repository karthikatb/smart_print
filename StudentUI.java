package com.smartprint.ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class StudentUI extends JFrame {

    private JTextField txtDocument, txtPages, txtCopies;
    private JCheckBox chkPrepay;
    private JTable tableQueue;
    private JLabel lblWallet;

    public StudentUI(String username) {
        setTitle("Student Dashboard - " + username);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lblHeader = new JLabel("Welcome, " + username, SwingConstants.CENTER);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblHeader, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Submit Print Request"));

        inputPanel.add(new JLabel("Document Name:"));
        txtDocument = new JTextField();
        inputPanel.add(txtDocument);

        inputPanel.add(new JLabel("Pages:"));
        txtPages = new JTextField();
        inputPanel.add(txtPages);

        inputPanel.add(new JLabel("Copies:"));
        txtCopies = new JTextField();
        inputPanel.add(txtCopies);

        chkPrepay = new JCheckBox("Prepay from wallet");
        inputPanel.add(chkPrepay);

        JButton btnSubmit = new JButton("Submit Request");
        inputPanel.add(btnSubmit);

        add(inputPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        lblWallet = new JLabel("Wallet Balance: ₹500.00");
        lblWallet.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        bottomPanel.add(lblWallet, BorderLayout.NORTH);

        tableQueue = new JTable(new DefaultTableModel(
                new Object[]{"Request ID", "Document", "Pages", "Copies", "Status"}, 0
        ));
        JScrollPane scrollPane = new JScrollPane(tableQueue);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.CENTER);

        btnSubmit.addActionListener(e -> JOptionPane.showMessageDialog(this, "Print request submitted! (Backend to be added)"));

        setVisible(true);
    }
}
