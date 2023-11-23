package com.group11.Controller;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyboardController extends JComponent implements KeyListener, Runnable {

    private Set<Integer> inputSet = new HashSet<>();

    public KeyboardController() {
        addKeyListener(this);
        setFocusable(true);

        Thread run = new Thread(this);
        run.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        inputSet.add(keyCode);
        char keyChar = e.getKeyChar();
        System.out.println("Key Pressed: " + keyChar + " (KeyCode: " + keyCode + ")");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        inputSet.remove(keyCode);
        char keyChar = e.getKeyChar();
        System.out.println("Key Released: " + keyChar + " (KeyCode: " + keyCode + ")");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        System.out.println("Key Typed: " + keyChar);
    }

    @Override
    public void run() {
        while (true) {
            if (!inputSet.isEmpty()) {
                System.out.println("Currently pressed keys: " + inputSet);
            }

            try {
                Thread.sleep(50); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Set<Integer> getInput() {
        return inputSet;
    }
}