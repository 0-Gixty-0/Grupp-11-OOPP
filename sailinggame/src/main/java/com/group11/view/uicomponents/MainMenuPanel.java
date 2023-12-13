package com.group11.view.uicomponents;

import java.awt.Button;
import java.awt.Dimension;

import javax.swing.BoxLayout;

/**
 * Class used to represent the main meni of the game as a JPanel with components
 */
public class MainMenuPanel extends AStandardPanel {
    
    private Button startButton;
    private Button exitButton;
    private Boolean startButtonPressed = false;

    public MainMenuPanel(int width, int height) {
        super(width, height);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Dimension buttonSize = new Dimension(200, 50);
        this.startButton = new Button("Start Game");
        this.exitButton = new Button("Rage quit >:(");
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
    protected Boolean getStartButtonPressed() {
        return this.startButtonPressed;
    }   

    /**
     * Method used to reset the start button to not pressed
     */
    protected void resetStartButtonPressed() {
        this.startButtonPressed = false;
    }

    /**
     * Method used to set the start button to pressed
     */
    protected void startButtonPressed() {
        if (startButton.hasFocus()) {
            this.startButtonPressed = true;
        }
    }

}
