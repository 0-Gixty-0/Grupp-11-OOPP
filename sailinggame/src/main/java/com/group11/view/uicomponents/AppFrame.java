package com.group11.view.uicomponents;

import java.awt.Dimension;
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
        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);
        this.setTitle("Sailing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(java.awt.Color.GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
    }
}
