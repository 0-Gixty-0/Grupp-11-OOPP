package com.group11.view.uicomponents;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * The class is a JPanel that is used as a buffer panel containing the stats of the player.
 */
public class StatsPanel extends BufferPanel {
    
    private JLabel scoreLabel;
    private JLabel lvlLabel;
    private JLabel hpLabel;
    private JLabel movementIconLabel;
    private JLabel arrowsIconLabel;

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

        lvlLabel.setFont(smallFont);
        hpLabel.setFont(smallFont);
        scoreLabel.setFont(smallFont);

        this.add(movementIconLabel);
        this.add(arrowsIconLabel);
        this.add(scoreLabel);
        this.add(lvlLabel);
        this.add(hpLabel);
    }

    protected void setScoreLabel(int score) {
        this.scoreLabel.setText("SCORE: " + score);
    }

    protected void setLvlLabel(int lvl) {
        this.lvlLabel.setText("LVL: " + lvl);
    }

    protected void setHpLabel(int hp) {
        this.hpLabel.setText("HP: " + hp);
    }

}
