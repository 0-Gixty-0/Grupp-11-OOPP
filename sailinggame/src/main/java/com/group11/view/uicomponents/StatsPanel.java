package com.group11.view.uicomponents;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * The class is a JPanel that is used as a buffer panel containing the stats of the player.
 * It contains labels for the player's level, hit points, and score, as well as icons for movement and shooting.
 * The layout of the panel is a centered FlowLayout.
 */

public class StatsPanel extends AStandardPanel {

    /**
     * JLabel for displaying the player's score.
     */
    private JLabel scoreLabel;


    /**
     * JLabel for displaying the player's level.
     */
    private JLabel lvlLabel;

    /**
     * JLabel for displaying the player's hit points.
     */
    private JLabel hpLabel;

    /**
     * JLabel for displaying the movement icon.
     */
    private JLabel movementIconLabel;

    /**
     * JLabel for displaying the shooting icon.
     */
    private JLabel arrowsIconLabel;

    /**
     * Constructs a new StatsPanel with a specified width and height.
     * Initializes the score, level, and hitpoints labels, as well as the movement and shooting icons.
     * Set the layout to a centered FlowLayout.
     *
     * @param width the width of the panel
     * @param height the height of the panel
     */
    protected StatsPanel(int width, int height) {
        super(width, height);
        lvlLabel = new JLabel("LVL: 0");
        hpLabel = new JLabel("HP: 100");
        scoreLabel = new JLabel("SCORE: 0");

        Icon arrowsIcon = new ImageIcon(getClass().getResource("/shoot.png"));
        arrowsIconLabel = new JLabel(arrowsIcon);

        Icon movementIcon = new ImageIcon(getClass().getResource("/move.png"));
        movementIconLabel = new JLabel(movementIcon);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));

        lvlLabel.setFont(this.getSmallFont());
        hpLabel.setFont(this.getSmallFont());
        scoreLabel.setFont(this.getSmallFont());

        this.add(movementIconLabel);
        this.add(arrowsIconLabel);
        this.add(scoreLabel);
        this.add(lvlLabel);
        this.add(hpLabel);
    }

    /**
     * Sets the text of the score label to the specified score.
     *
     * @param score the player's score
     */
    protected void setScoreLabel(int score) {
        this.scoreLabel.setText("SCORE: " + score);
    }

    /**
     * Sets the text of the level label to the specified level.
     *
     * @param lvl the player's level
     */
    protected void setLvlLabel(int lvl) {
        this.lvlLabel.setText("LVL: " + lvl);
    }

    /**
     * Sets the text of the hit points label to the specified hit points.
     *
     * @param hp the player's hit points
     */
    protected void setHpLabel(int hp) {
        this.hpLabel.setText("HP: " + hp);
    }
}