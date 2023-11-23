package com.group11.Controller;

import javax.swing.*;

public class keyboardtester {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard Controller Test");
        KeyboardController keyboardController = new KeyboardController();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().add(keyboardController);
        frame.setVisible(true);

        // Give focus to the KeyboardController to receive key events
        keyboardController.requestFocus();

        // Continuously check if a specific key is pressed
       
    }
}