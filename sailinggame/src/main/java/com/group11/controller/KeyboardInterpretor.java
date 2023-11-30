package com.group11.controller;

import java.util.Set;


public class KeyboardInterpretor extends AControllerInterpretor{


    public KeyboardInterpretor(Set<Integer> inputSet){
        
    }        
    /*
     * Function that converts the ascii code of keyboard input to a direction 0-7 clockwise starting upwards
     */
        public static int inputToDir(Set<Integer> inputSet) {

            /*Direction up-left */
            if (inputSet.contains((int) 'w') && inputSet.contains((int) 'd') && !inputSet.contains((int) 'a') && !inputSet.contains((int) 's')) {
                return 1;
            }
             /*Direction down-left */
             if (inputSet.contains((int) 's') && inputSet.contains((int) 'd') && !inputSet.contains((int) 'w') && !inputSet.contains((int) 'a')) {
                return 3;
            }
            /*Direction down-right */
            if (inputSet.contains((int) 'a') && inputSet.contains((int) 's') && !inputSet.contains((int) 'd') && !inputSet.contains((int) 'w')) {
                return 5;
            }
            /*Direction up-left */
            if (inputSet.contains((int) 'w') && inputSet.contains((int) 'a') && !inputSet.contains((int) 'd') && !inputSet.contains((int) 's')) {
                return 7;
            }
            /* Direction up*/
            if (inputSet.contains((int) 'w') && !inputSet.contains((int) 's')) {
                return 0;
            }
            /*Direction right */
            if (inputSet.contains((int) 'd') && !inputSet.contains((int) 'a')) {
                return 2;
            }
            /*Direction down */
            if (inputSet.contains((int) 's') && !inputSet.contains((int) 'w')) {
                return 4;
            }
            /*Direction left */
            if (inputSet.contains((int) 'a') && !inputSet.contains((int) 'd')) {
                return 6;
            }

            /*Returns -1 if none of the inputs corresponds to a direction (-1) is not a valid direction */
            return -1;
        }
    
        public static int shootDir(Set<Integer> inputSet){
            /*Direction up-left */
            if (inputSet.contains(38) && inputSet.contains(39) && !inputSet.contains(37) && !inputSet.contains(40)) {
                return 1;
            }
             /*Direction down-left */
             if (inputSet.contains(40) && inputSet.contains(39) && !inputSet.contains(38) && !inputSet.contains(37)) {
                return 3;
            }
            /*Direction down-right */
            if (inputSet.contains(37) && inputSet.contains(40) && !inputSet.contains(39) && !inputSet.contains(38)) {
                return 5;
            }
            /*Direction up-left */
            if (inputSet.contains(37) && inputSet.contains(37) && !inputSet.contains(39) && !inputSet.contains(40)) {
                return 7;
            }
            /* Direction up*/
            if (inputSet.contains(37) && !inputSet.contains(40)) {
                return 0;
            }
            /*Direction right */
            if (inputSet.contains(39) && !inputSet.contains(37)) {
                return 2;
            }
            /*Direction down */
            if (inputSet.contains(40) && !inputSet.contains(38)) {
                return 4;
            }
            /*Direction left */
            if (inputSet.contains(37) && !inputSet.contains(39)) {
                return 6;
            }
            return -1;
        }
    }

    






