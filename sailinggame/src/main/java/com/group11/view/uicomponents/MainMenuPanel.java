package com.group11.view.uicomponents;

import java.awt.Button;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Class used to represent the main meni of the game as a JPanel with components
 */
public class MainMenuPanel extends JPanel {
    
    Button startButton;
    Button exitButton;
    Boolean startButtonPressed = false;

    public MainMenuPanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(java.awt.Color.GRAY);
        Dimension buttonSize = new Dimension(200, 50);
        this.startButton = new Button("Start Game");
        this.exitButton = new Button("Exit Application");
        startButton.setMaximumSize(buttonSize);
        exitButton.setMaximumSize(buttonSize);
        this.startButton.addActionListener(e -> startButtonPressed());
        this.exitButton.addActionListener(e -> System.exit(0));
        this.add(new BufferPanel(width, 50));
        this.add(startButton);
        this.add(exitButton);
    }

    /**
     * Method used to get the start button pressed boolean
     * @return Boolean
     */
    public Boolean getStartButtonPressed() {
        return this.startButtonPressed;
    }   

    /**
     * Method used to reset the start button to not pressed
     */
    public void resetStartButtonPressed() {
        this.startButtonPressed = false;
    }

    /**
     * Method used to set the start button to pressed
     */
    private void startButtonPressed() {
        if (startButton.hasFocus()) {
            this.startButtonPressed = true;
        }
    }

}
