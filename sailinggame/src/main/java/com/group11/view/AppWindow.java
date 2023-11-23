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
public class AppWindow {
    private static int windowWidth;
    private static int windowHeight;
    private final GameWorld gameWorld;
    private final GameEntities gameEntities;

    private final JFrame mainFrame;
    private final JPanel gameWorldPanel;

    private List<List<Integer>> terrainMatrix;
    private List<List<Integer>> entityMatrix;

    /**
     * Constructor creates a new GameWorld object, a new GameEntities object, and initializes the window
     */
    public AppWindow(int windowWidth, int windowHeight) {
        AppWindow.windowWidth = windowWidth;
        AppWindow.windowHeight = windowHeight;
        this.terrainMatrix = this.initializeTerrainTest();
        this.entityMatrix = this.initializeEntityTest();
        gameWorld = new GameWorld(terrainMatrix, windowWidth, windowHeight);
        gameEntities = new GameEntities(entityMatrix);
        gameWorldPanel = new JPanel();
        mainFrame = new JFrame("Sailing Game");
        this.initializeWindow();
    }

    /**
     * Testing purposes. Will be removed later.
     * @return Matrix of integers corresponding to entity texture id:s
     */
    private List<List<Integer>> initializeEntityTest() {
        List<List<Integer>> testEntityMatrix = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k < 50; k++) {
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
        for (int i = 0; i < 50; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k < 50; k++) {
                row.add(rand.nextInt(2));
            }
            testTerrainMatrix.add(row);
        }
        return testTerrainMatrix;
    }

    /**
     * Initializes the mainFrame window.
     */
    private void initializeWindow() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(this.windowWidth, this.windowHeight);
        this.addTilesToPanel();
        gameWorldPanel.setPreferredSize(new Dimension(75*16, 25*16));
        gameWorldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
        gameWorldPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        gameWorldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainFrame.add(gameWorldPanel);
    }

    /**
     * Adds each JLabel component, obtained from the AViewTile object, on the map to the main window frame.
     * If a position in the entity tile matrix is null then the terrain component will be added.
     * Otherwise, the entity tile component for that position will be added.
     */
    private void addTilesToPanel() {
        ArrayList<ArrayList<AViewTile>> tileMatrix = this.gameWorld.getTileMatrix();
        for (ArrayList<AViewTile> tileRow : tileMatrix) {
            for (AViewTile tile : tileRow) {
                Point matrixPosition = tile.getMatrixPosition();
                if (this.gameEntities.getTileMatrix().get(matrixPosition.x).get(matrixPosition.y) == null) {
                    gameWorldPanel.add(tile.getComponent());
                } else {
                    gameWorldPanel.add(this.gameEntities.getTileMatrix().get(matrixPosition.x).get(matrixPosition.y).getComponent());
                }
            }
        }
    }

    /**
     * Sets visibility of the main window to true
     */
    public void showGame() {
        mainFrame.setVisible(true);
    }
}
