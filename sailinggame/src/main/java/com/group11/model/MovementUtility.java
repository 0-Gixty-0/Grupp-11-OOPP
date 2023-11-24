package com.group11.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for checking if a body is going to collide with another body.
 *
 */
public final class MovementUtility {

    /**
     * Matrix of ATiles to check for collision.
     */
    private static List<List<ATile>> tileMatrix;

    private MovementUtility() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Set the tileMatrix to be used for checking if movement is possible.
     * @param tileMatrix
     */
    public static void setTileMatrix(List<List<ATile>> tileMatrix) {
        MovementUtility.tileMatrix = tileMatrix;
    }

    /**
     * Check if movement is possible in a given direction.
     * @param currPos Current position of the body.
     * @param dirVector Direction vector of the movement.
     * @return (Boolean) true if movement is possible, false otherwise.
     */
    public static Boolean movementIsPossible(Point currPos, int[] dirVector) {

        if (MovementUtility.tileMatrix == null) {
            throw new IllegalStateException("Unable to move because a tileMatrix has not been set for MovementUtility");
        }

        int newX = (int) currPos.getX() + dirVector[0];
        int newY = (int) currPos.getY() + dirVector[1];

        try {
            //Trying to move over impassable terrain
            if (MovementUtility.tileMatrix.get(newX).get(newY).isPassable()) {
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
