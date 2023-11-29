package com.group11.controller;

import java.util.Set;


public class keyboardInterpretor extends AControllerInterpretor{


    public keyboardInterpretor(Set<Integer> inputSet){
        
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
    
        public static int arrowsToDir(Set<Integer> inputSet){


            return -1;
        }

    }

    






