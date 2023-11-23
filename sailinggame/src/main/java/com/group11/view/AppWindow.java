package com.group11.view;

import javax.swing.*;

import com.group11.view.moveoutofthewayplease.GameEntities;
import com.group11.view.moveoutofthewayplease.GameWorld;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * AppWindow is the top-level class for the View component of the MVC design.
 * It is responsible for drawing the map terrain and entities on the map
 */
public class AppWindow extends JFrame {
    
    private BufferPanel bufferPanel;
    private StatsPanel statsPanel;
    private GameWorldPanel gameWorldPanel;

    /**
     * Constructor creates a new GameWorld object, a new GameEntities object, and initializes the window
     */
    public AppWindow(int windowWidth, int windowHeight) {
        super();
        this.setSize(windowWidth, windowHeight);
        this.setTitle("Sailing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.GRAY);
        this.addComponents();
    }

    /**
     * Initializes the mainFrame window.
     */
    private void addComponents() {

        this.bufferPanel = new BufferPanel(1000, 6);

        this.statsPanel = new StatsPanel(1000, 6);

        this.add(statsPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
        
        this.gameWorldPanel = new GameWorldPanel(60, 30);

        this.add(gameWorldPanel);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.add(bufferPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
    }

    public void updateHp() {
        // @TODO set hp
    }

    public void updateLvl() {
        // @TODO set lvl
    }

    public void updateScore() {
        // @TODO set score
    }

    public void updateEntities( List<List<Integer>> entityMatrix) {
        EntityUtility.getInstance().updateTileMatrix(entityMatrix);
        List<List<AViewTile>> tileMatrix = EntityUtility.getInstance().getTileMatrix();
        this.gameWorldPanel.updateEntityMatrix(tileMatrix);
    }

    public void updateTerrain( List<List<Integer>> terrainMatrix) {
        TerrainUtility.getInstance().updateTileMatrix(terrainMatrix);
        List<List<AViewTile>> tileMatrix = TerrainUtility.getInstance().getTileMatrix();
        this.gameWorldPanel.updateTerrainMatrix(tileMatrix);
    }

    /**
     * Sets visibility of the main window to true
     */
    public void showGame() {
        this.setVisible(true);
    }
}
