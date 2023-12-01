package com.group11.controller;

import java.util.Set;

/**
 * A class that interprets input from a global key listener.
 */
public abstract class AControllerInterpretor{

    private GlobalKeyListener globalKeyListener;

    protected AControllerInterpretor() {
        this.globalKeyListener = new GlobalKeyListener();
    }

    /**
     * Takes the inputSet and returns a direction based on the inputSet
     * @param inputSet Set of currently pressed keys.
     * @param up Keycode for up.
     * @param down Keycode for down.
     * @param left Keycode for left.
     * @param right Keycode for right.
     * @return Returns a direction based on the inputSet.
     */
    protected int keycodeToDir(Set<Integer> inputSet, int up, int down, int left, int right) {

        boolean containsUp = inputSet.contains(up);
        boolean containsDown = inputSet.contains(down);
        boolean containsLeft = inputSet.contains(left);
        boolean containsRight = inputSet.contains(right);

        /*Direction up-left */
        if (containsUp && containsRight && !containsLeft && !containsDown) {
            return 1;
        }
        /*Direction down-left */
        if (containsDown && containsRight && !containsUp && !containsLeft) {
            return 3;
        }
        /*Direction down-right */
        if (containsLeft && containsDown && !containsRight && !containsUp) {
            return 5;
        }
        /*Direction up-left */
        if (containsUp && containsLeft && !containsRight && !containsDown) {
            return 7;
        }
        /* Direction up*/
        if (containsUp && !containsDown) {
            return 0;
        }
        /*Direction right */
        if (containsRight && !containsLeft) {
            return 2;
        }
        /*Direction down */
        if (containsDown && !containsUp) {
            return 4;
        }
        /*Direction left */
        if (containsLeft && !containsRight) {
            return 6;
        }

        /*Returns -1 if none of the inputs corresponds to a direction (-1) is not a valid direction */
        return -1;
    }

    /**
     * Returns the inputSet, primarily used for testing.
     * @return Returns the inputSet
     */
    public Set<Integer> getInputSet() {
        return this.globalKeyListener.getInput();
    }

    /**
     * Returns the movement input
     * @return Returns the movement input
     */
    public abstract int getMovementInput();

    /**
     * Returns the fire input
     * @return Returns the fire input
     */
    public abstract int getFireInput();

}