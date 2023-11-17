package com.group11.model;

import java.awt.Point;

public final class MovementUtility {

    private static Map map;

    private MovementUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static void setMap(Map map) {
        MovementUtility.map = map;
    }

    public static Boolean movementIsPossible(Point currPos, int[] dirVector) {

        if (MovementUtility.map == null) {
            throw new IllegalStateException("Unable to move because a Map has not been set for MovementUtility");
        }

        int newX = (int) currPos.getX() + dirVector[0];
        int newY = (int) currPos.getY() + dirVector[1];

        try {
            //Trying to move over impassable terrain
            if (MovementUtility.map.getTileMatrix().get(newY).get(newX).isPassable()) {
                return true;
            } else {
                return false;
            }
            //Trying to move outside the world
        } catch (IndexOutOfBoundsException e) {
            return false; 
        }

    }
}
