package com.group11.model.gameentites;

import java.awt.Point;

/**
 * A class representing a body that doesn't move, such as cities and other locations.
 */
public class AImmovableBody extends ABody {

    /**
     * Constructor for creating immovable bodies
     * @param pos       The position of the body on the map
     * @param hitPoints The hitpoints of the body
     */
    protected AImmovableBody(Point pos, int hitPoints) {
        super(pos, hitPoints);
    }
}