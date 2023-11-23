package com.group11.Controller;

import javax.swing.*;

public class keyboardtester {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());

    }

    private static void createAndShowGUI() {
        // Create the JFrame
        JFrame frame = new JFrame("Simple JFrame Example");
        frame.add(new KeyboardController());

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Set the layout manager (optional)

        // Add a JLabel to the frame
        JLabel label = new JLabel("Hello, JFrame!");
        frame.add(label);

        // Make the frame visible
        frame.setVisible(true);
    }
}

