package com.group11.application;

import com.group11.controller.AControllerInterpretor;
import com.group11.controller.KeyboardInterpretor;
import com.group11.model.modelinitialization.AModelInitializer;
import com.group11.model.modelinitialization.IGameLoop;
import com.group11.model.modelinitialization.SailingGameLoop;
import com.group11.model.modelinitialization.SailingGameModel;
import com.group11.view.uicomponents.AppFrame;

/**
 * A class containing logic specific to the SailingGame application. The idea of our project was to make the source
 * code as extendable as possible, therefore, if you wanted to create a new game you would only need to change this class.
 */
public class SailingGameApplication extends AApplication {

    private static final int WINDOWWITH = 1100;
    private static final int WINDOWHEIGHT = 1000;
    private static final int MAPWIDTH = 65;
    private static final int MAPHEIGHT = 30;

    IGameLoop gameLoop;
    AModelInitializer model;
    AControllerInterpretor keyBoardInterpretor;
    
    /**
     * Constructs a SailingGameApplication.
     */
    public SailingGameApplication() {
        super(new AppFrame(WINDOWWITH, WINDOWHEIGHT, MAPWIDTH, MAPHEIGHT));
        this.keyBoardInterpretor = new KeyboardInterpretor();
        this.model = new SailingGameModel(MAPWIDTH, MAPHEIGHT);
        this.gameLoop = new SailingGameLoop(model);
    }

    @Override
    public void run(int cyclespeedMS) throws InterruptedException {
        
        while (Thread.currentThread().isAlive()) {
            mainMenuLoop(cyclespeedMS);
            gameLoop(cyclespeedMS);
            gameOverLoop(cyclespeedMS);
        }
    }

    private void mainMenuLoop(int cyclespeedMS) throws InterruptedException {
        appWindow.displayMainMenuView();

        while (Thread.currentThread().isAlive()) {
            Thread.sleep(cyclespeedMS);
            if (appWindow.getStartButtonPressed()) {
                appWindow.displayGameView();
                break;
            }
        }
    }

    private void gameLoop(int cyclespeedMS) throws InterruptedException {
        appWindow.displayGameView();
        appWindow.updateTerrain(model.getDecodedTerrainMatrix());

        while (Thread.currentThread().isAlive()) {
            Thread.sleep(cyclespeedMS);
            gameLoop.runLoopOnce(keyBoardInterpretor.getMovementInput(), keyBoardInterpretor.getFireInput());
            appWindow.updateEntities(model.getDecodedEntityMatrix());
            appWindow.updateHp(model.getPlayerHitPoints());
            appWindow.updateScore(model.getPlayerScore());

            if (gameLoop.isGameOver()) {
                model = new SailingGameModel(MAPWIDTH, MAPHEIGHT);
                gameLoop = new SailingGameLoop(model);
                break;
            }
        }
    }

    private void gameOverLoop(int cyclespeedMS) throws InterruptedException {
        appWindow.displayGameOverView();

        while (Thread.currentThread().isAlive()) {
            Thread.sleep(cyclespeedMS);

            if (appWindow.getBackToMenuButtonPressed()) {
                break;
            }
        }
    }
}