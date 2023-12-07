package com.group11.view.uicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * The class is an abstract JPanel that is used as a standard panel for the game.
 */
public abstract class AStandardPanel extends JPanel {
    
    Font bigFont;
    Font smallFont;

    protected AStandardPanel(int width, int height) {
        super();
        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
        this.setBackground(Color.GRAY);
        this.bigFont = new Font("Arial", Font.PLAIN, 50);
        this.smallFont = new Font("Arial", Font.PLAIN, 20);
    }

}
