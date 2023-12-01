package com.group11.controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
/*
 * This is a globalkeylistener that exists in the background and takes the keyboard input from your computer
 */


public class GlobalKeyListener implements KeyEventDispatcher, Runnable {

    /*
     * Hashset that contains currently pressed keys
     */
    private Set<Integer> inputSet = new HashSet<>();

    public GlobalKeyListener() {
        /**
         *  Install the global key listener
         * */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);

        /**
         *  Start a separate thread to handle the key events
         * */
        Thread run = new Thread(this);
        run.start();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        int keyCode = e.getKeyCode();

        /*If the the event is a key pressed, add it to the inputSet */
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            inputSet.add(keyCode);
        } 
        /*If the the event is a key released, remove it from the inputSet */
        else if (e.getID() == KeyEvent.KEY_RELEASED) {
            inputSet.remove(keyCode);
        } 

        /*Return false to allow normal processing of the event*/ 
        return false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(50); /* Adjust the sleep duration as needed to not stress the processor as much*/
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }


    /*Getter that can be called to get keyboardinputs */
    public Set<Integer> getInput() {
        return inputSet;
    }
}
