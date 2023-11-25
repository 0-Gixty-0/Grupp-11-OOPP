package com.group11.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class BufferPanel extends JPanel {
    
    protected BufferPanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width*16, height*16));
        this.setBackground(Color.GRAY);
    }

}
