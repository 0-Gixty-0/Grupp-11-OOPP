package com.group11.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

public class StatsPanel extends BufferPanel {
    
    private JLabel scoreLabel;
    private JLabel lvlLabel;
    private JLabel hpLabel;


    protected StatsPanel(int width, int height) {
        super(width, height);
        lvlLabel = new JLabel("LVL: 0");
        hpLabel = new JLabel("HP: 100");
        scoreLabel = new JLabel("SCORE: 0");
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
        lvlLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        hpLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(scoreLabel);
        this.add(lvlLabel);
        this.add(hpLabel);
    }

    public void setScoreLabel(int score) {
        this.scoreLabel.setText("SCORE: " + score);
    }

    public void setLvlLabel(int lvl) {
        this.lvlLabel.setText("LVL: " + lvl);
    }

    public void setHpLabel(int hp) {
        this.hpLabel.setText("HP: " + hp);
    }

}
