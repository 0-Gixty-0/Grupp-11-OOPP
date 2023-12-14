package com.group11.controller;

import javax.swing.*;

/*A pure testclass for testing input */
public class KeyboardTester {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Keyboard Controller Test");
        GlobalKeyListener keyboardController = new GlobalKeyListener();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        while (true){
        System.out.println(keyboardController.getInput());
        Thread.sleep(100);
        }
    }
}