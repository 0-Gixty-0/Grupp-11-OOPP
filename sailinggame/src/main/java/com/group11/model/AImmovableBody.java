package com.group11.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * A class representing a body that doesnt move, such as cities and other locations.
 */
public class AImmovableBody extends ABody {

    /**
     * Constructor for creating immovable bodies
     * @param dimensions The physical dimensions of the body
     * @param pos The position of the body on the map
     * @param hitPoints The hitpoints of the body
     * @param textureId The id represnting the texture of the body
     */
    protected AImmovableBody(ArrayList<ArrayList<Boolean>> dimensions, Point pos, int hitPoints, int textureId, String description) {
        super(dimensions, pos, hitPoints, description);
    }
    
}
