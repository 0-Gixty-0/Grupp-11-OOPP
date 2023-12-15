package com.group11.model.modelinitialization;

/**
 * Interface for the application game loop.
 */
public interface IGameLoop {

    public void runLoopOnce(int movementInput, int fireInput);

    public boolean isGameOver();
}