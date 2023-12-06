package com.group11.view.uicomponents;

import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * this class is used to create an application window (JFrame) for hosting views.
 */ 
public class AppFrame extends JFrame {

    /**
     * Constructor for creating an AppFrame.
     * @param width width of the frame
     * @param height height of the frame
     */
    public AppFrame (int width, int height) {
        super();
        this.setSize(width, height);
        this.setTitle("Sailing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(java.awt.Color.GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
    }
}
