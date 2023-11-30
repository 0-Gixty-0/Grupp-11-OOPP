package com.group11.controller;

import java.util.Set;

public abstract class AControllerInterpretor{

    /*
     * Function that converts the Keylistener code of keyboard input to a direction 0-7 clockwise starting upwards
     */
        

    public static int inputToDir(Set<Integer> inputSet, int up, int down, int left, int right) {

        /*Direction up-left */
        if (inputSet.contains(up) && inputSet.contains(right) && !inputSet.contains(left) && !inputSet.contains(down)) {
            return 1;
        }
         /*Direction down-left */
         if (inputSet.contains(down) && inputSet.contains(right) && !inputSet.contains(up) && !inputSet.contains(left)){
            return 3;
        }
        /*Direction down-right */
        if (inputSet.contains(left) && inputSet.contains(down) && !inputSet.contains(right) && !inputSet.contains(up)) {
            return 5;
        }
        /*Direction up-left */
        if (inputSet.contains(up) && inputSet.contains(left) && !inputSet.contains(right) && !inputSet.contains(down)) {
            return 7;
        }
        /* Direction up*/
        if (inputSet.contains(up) && !inputSet.contains(down)) {
            return 0;
        }
        /*Direction right */
        if (inputSet.contains(right) && !inputSet.contains(left)) {
            return 2;
        }
        /*Direction down */
        if (inputSet.contains(down) && !inputSet.contains(up)) {
            return 4;
        }
        /*Direction left */
        if (inputSet.contains(left) && !inputSet.contains(right)) {
            return 6;
        }

        /*Returns -1 if none of the inputs corresponds to a direction (-1) is not a valid direction */
        return -1;
    }

}