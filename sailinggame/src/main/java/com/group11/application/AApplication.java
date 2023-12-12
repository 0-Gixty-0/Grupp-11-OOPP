package com.group11.application;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.group11.view.uicomponents.AppFrame;

/**
 * Abstract class for applications that use a Swing view consisting of a JFrame displaying different JPanels (different views)
 */
public abstract class AApplication {
    
    AppFrame appWindow;

    protected AApplication(AppFrame appWindow) {
        this.appWindow = appWindow;
        this.appWindow.setSize(500, 500);
    }

    public abstract void run(int cyclespeedMS) throws InterruptedException;

}
