package com.group11.controller;

import java.util.Set;

public class KeyboardInterpretor extends AControllerInterpretor{

    @Override
    public int getMovementInput() {
        Set<Integer> inputSet = this.getInputSet();
        return this.keycodeToDir(inputSet, 87, 83, 65, 68);
    }

    @Override
    public int getFireInput() {
        Set<Integer> inputSet = this.getInputSet();
        return this.keycodeToDir(inputSet, 38, 40, 37,39);
    }
}