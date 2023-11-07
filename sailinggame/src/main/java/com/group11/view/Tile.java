package com.group11.view;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private int id;
    private int size;
    private Point matrixPosition;
    private Point pixelPosition;
    private JLabel component;

    public Tile(int id, int size, Point matrixPosition, JLabel component, Point pixelPosition) {
        this.id = id;
        this.size = size;
        this.matrixPosition = matrixPosition;
        this.pixelPosition = pixelPosition;
        this.component = component;
    }

    public int getId() {
        return id;
    }
    
    public int getSize() {
        return size;
    }

    public Point getMatrixPosition() {
        return matrixPosition;
    }

    public Point getPixelPosition() {
        return pixelPosition;
    }

    public JLabel getComponent() {
        return component;
    }
}
