package com.group11.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;



public class KeyboardController extends AController implements KeyListener, Runnable {
    
    private Set<Integer> inputSet = new HashSet<>();

    public KeyboardController(){
        
        super();
        addKeyListener(this);
        Thread run = new Thread(this);
 		run.start();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        inputSet.add(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        inputSet.remove(keyCode);
    }


    
    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public Set<Integer> getInput(){
        return inputSet;

    }
    public static void main(String[] args) {
        KeyboardController controller = new KeyboardController();

        // Create a window or component to add the KeyListener to
        // For example, a JFrame or a JPanel
        // Add the controller as a KeyListener to the window or component
        // For example, window.addKeyListener(controller);

        // Continuously check if a specific key is pressed
        while (true) {
            if ((controller.getInput()).isEmpty() != true){
            System.out.println(controller.getInput());;
            }

            // You can add more key checks here for different keys
        }
    





    }

    @Override
    public void run()
	{
		while(true)
		{
            
            System.out.println(inputSet);
			
            try {
                Thread.sleep(50); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

    public void main(){
       new KeyboardController();

    }
}