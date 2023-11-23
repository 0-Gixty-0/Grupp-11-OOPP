package com.group11.Controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class GlobalKeyListener implements KeyEventDispatcher, Runnable {

    private Set<Integer> inputSet = new HashSet<>();

    public GlobalKeyListener() {
        // Install the global key listener
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);

        // Start a separate thread to handle key events
        Thread run = new Thread(this);
        run.start();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (e.getID() == KeyEvent.KEY_PRESSED) {
            inputSet.add(keyCode);
        } 
        
        else if (e.getID() == KeyEvent.KEY_RELEASED) {
            inputSet.remove(keyCode);
        } 

        else if (e.getID() == KeyEvent.KEY_TYPED) {

        }
        // Return false to allow normal processing of the event
        return false;
    }

    @Override
    public void run() {
        while (true) {
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
