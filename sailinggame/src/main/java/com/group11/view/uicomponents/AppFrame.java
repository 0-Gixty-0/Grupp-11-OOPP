package com.group11.view.uicomponents;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * this class is used to create an application window (JFrame) for hosting views. This is the top level class in the view.
 */ 
public class AppFrame extends JFrame {

    private GameOverPanel gameOverView;
    private GamePanel gameView;
    private MainMenuPanel mainMenuView;

    /**
     * Constructor for creating an AppFrame.
     * @param width width of the frame
     * @param height height of the frame
     */
    public AppFrame (int width, int height, int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
        super();
        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);
        this.setTitle("Sailing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(java.awt.Color.GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
        this.gameOverView = new GameOverPanel(width, height);
        this.gameView = new GamePanel(width, height, mapWidth, mapHeight, 16, 16);
        this.mainMenuView = new MainMenuPanel(width, height);
    }

    /**
     * Displays the game view.
     */
    public void displayGameView() {
        this.removeViewFromWindow(this.mainMenuView);
        this.removeViewFromWindow(this.gameOverView);
        this.addViewToWindow(this.gameView);
    }

    /**
     * Displays the main menu view.
     */
    public void displayMainMenuView() {
        this.removeViewFromWindow(this.gameView);
        this.removeViewFromWindow(this.gameOverView);
        this.addViewToWindow(this.mainMenuView);
    }

    /**
     * Displays the game over view.
     */
    public void displayGameOverView() {
        this.removeViewFromWindow(this.gameView);
        this.removeViewFromWindow(this.mainMenuView);
        this.addViewToWindow(this.gameOverView);
    }

    /**
     * Gets the value from the start button and resets it
     * @return boolean value of the start button
     */
    public boolean getStartButtonPressed() {
        boolean isPressed = this.mainMenuView.getStartButtonPressed();
        mainMenuView.resetStartButtonPressed();
        return isPressed;
    }

    /**
     * Gets the value from the back to menu button and resets it
     * @return boolean value of the back to menu button
     */
    public boolean getBackToMenuButtonPressed() {
        boolean isPressed = this.gameOverView.getBackToMenuButtonPressed();
        gameOverView.resetBackToMenuButtonPressed();
        return isPressed;
    }

    /**
     * Updates the entities in the game view.
     * @param entityMatrix the matrix of entities to be updated
     */
    public void updateEntities(List<List<Integer>> entityMatrix) {
        this.gameView.updateEntities(entityMatrix);
    }

    /**
     * Updates the terrain in the game view.
     * @param terrainMatrix the matrix of terrain to be updated
     */
    public void updateTerrain(List<List<Integer>> terrainMatrix) {
        this.gameView.updateTerrain(terrainMatrix);
    }

    /**
     * Updates the score in the game view.
     * @param score the score to be updated
     */
    public void updateScore(int score) {
        this.gameView.updateScore(score);
        this.gameOverView.setScoreLabel(score);
    }

    /**
     * Updates the hp in the game view.
     * @param hp the hp to be updated
     */
    public void updateHp(int hp) {
        this.gameView.updateHp(hp);
    }

    /**
     * Removes a view from the window
     * @param view The view to be removed
     */
    private void removeViewFromWindow(JComponent view) {
        this.remove(view);
        this.repaint();
    }


    /**
     * Adds a view to the window
     * @param view The view to be added
     */
    private void addViewToWindow(JComponent view) {
        this.add(view);
        this.validate();
    }
}
