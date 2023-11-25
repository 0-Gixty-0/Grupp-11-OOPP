package com.group11.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

public class StatsPanel extends BufferPanel {
    
    private JLabel scoreLabel;
    private JLabel lvlLabel;
    private JLabel hpLabel;
    private static final Font FONT = new Font("Arial", Font.PLAIN, 20);

    protected StatsPanel(int width, int height) {
        super(width, height);
        lvlLabel = new JLabel("LVL: 0");
        hpLabel = new JLabel("HP: 100");
        scoreLabel = new JLabel("SCORE: 0");
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        lvlLabel.setFont(FONT);
        hpLabel.setFont(FONT);
        scoreLabel.setFont(FONT);
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
