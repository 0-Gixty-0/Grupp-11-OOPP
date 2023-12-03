package com.group11.model.gameworld;

import java.awt.Point;
/**
* This class is used as a concrete implementation for the tile object as a land tile, extending the abstract class ATile.
*/
public class LandTile extends ATile {

    /**
    * Constructor for the class LandTile
    * @param pos - The position of a tile as a Java Point 
    */
    public LandTile(Point pos) {
        super(1, pos, false);
    }
}