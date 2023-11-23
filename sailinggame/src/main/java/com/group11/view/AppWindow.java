package com.group11.view;

import javax.swing.*;

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
    
    private final GameWorld gameWorld;
    private final GameEntities gameEntities;

    private List<List<Integer>> terrainMatrix;
    private List<List<Integer>> entityMatrix;
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
        this.terrainMatrix = this.initializeTerrainTest();
        this.entityMatrix = this.initializeEntityTest();
        gameWorld = new GameWorld(terrainMatrix, windowWidth, windowHeight);
        gameEntities = new GameEntities(entityMatrix);
        this.addComponents();
    }

    /**
     * Testing purposes. Will be removed later.
     * @return Matrix of integers corresponding to entity texture id:s
     */
    private List<List<Integer>> initializeEntityTest() {
        List<List<Integer>> testEntityMatrix = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k < 45; k++) {
                int num = rand.nextInt(40);
                if (num > 0) {
                    row.add(null);
                } else {
                    row.add(0);
                }
            }
            testEntityMatrix.add(row);
        }
        return testEntityMatrix;
    }

    /**
     * Testing purposes. Will be removed later.
     * @return Matrix of integers corresponding to terrain texture id:s
     */
    private List<List<Integer>> initializeTerrainTest() {
        List<List<Integer>> testTerrainMatrix = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k < 45; k++) {
                row.add(rand.nextInt(2));
            }
            testTerrainMatrix.add(row);
        }
        return testTerrainMatrix;
    }

    /**
     * Initializes the mainFrame window.
     */
    private void addComponents() {

        this.bufferPanel = new BufferPanel(1000, 12);
        this.statsPanel = new StatsPanel(1000, 12);

        this.add(statsPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
        
        this.gameWorldPanel = new GameWorldPanel(45, 30, gameWorld.getTileMatrix(), gameEntities.getTileMatrix());

        this.add(gameWorldPanel);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.add(bufferPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
    }

    

    /**
     * Sets visibility of the main window to true
     */
    public void showGame() {
        this.setVisible(true);
    }
}
