package com.smartprint.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OperatorUI extends JFrame {

    private JTable tableRequests;
    private DefaultTableModel model;

    public OperatorUI(String operatorName) {
        setTitle("Operator Dashboard - " + operatorName);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitle = new JLabel("Print Queue Management", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitle, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new Object[]{"Request ID", "Student", "Document", "Pages", "Status"}, 0
        );
        tableRequests = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableRequests);
        add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnProcess = new JButton("Start Processing");
        JButton btnComplete = new JButton("Mark Completed");
        btnPanel.add(btnProcess);
        btnPanel.add(btnComplete);
        add(btnPanel, BorderLayout.SOUTH);

        btnProcess.addActionListener(e -> JOptionPane.showMessageDialog(this, "Request status changed to Processing."));
        btnComplete.addActionListener(e -> JOptionPane.showMessageDialog(this, "Request marked as Completed."));

        setVisible(true);
    }
}
