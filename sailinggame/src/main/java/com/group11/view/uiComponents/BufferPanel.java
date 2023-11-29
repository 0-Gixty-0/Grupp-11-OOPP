package com.group11.view.uiComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * The class is a JPanel that is used as a buffer panel for the game world.
 */
public class BufferPanel extends JPanel {
    
    /**
     * Constructor for creating a BufferPanel.
     * @param width width of the panel
     * @param height height of the panel
     */
    protected BufferPanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width*16, height*16));
        this.setBackground(Color.GRAY);
    }

}
