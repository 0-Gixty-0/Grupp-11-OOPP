package com.group11.controller;

import java.util.Set;


public class KeyboardInterpretor extends AControllerInterpretor{


    public KeyboardInterpretor(Set<Integer> inputSet){
        
    }        

        public static int arrowsToDir(Set<Integer> inputSet){

            return inputToDir(inputSet, 38, 40, 37,39);
        }
        
        public static int WASDToDir(Set<Integer> inputSet){

            return inputToDir(inputSet, 87, 83, 65, 68);
        }
        
    }

    






