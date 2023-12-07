package com.group11.application;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Abstract class for applications that use a Swing view consisting of a JFrame displaying different JPanels (different views)
 */
public abstract class AApplication {
    
    JFrame appWindow;

    protected AApplication(JFrame appWindow) {
        this.appWindow = appWindow;
        this.appWindow.setSize(500, 500);
    }

    /**
     * Adds a view to the window
     * @param view The view to be added
     */
    protected void addViewToWindow(JComponent view) {
        this.appWindow.add(view);
        this.appWindow.validate();
    }

    /**
     * Removes a view from the window
     * @param view The view to be removed
     */
    protected void removeViewFromWindow(JComponent view) {
        this.appWindow.remove(view);
        this.appWindow.repaint();
    }

    public abstract void run() throws InterruptedException;

}
