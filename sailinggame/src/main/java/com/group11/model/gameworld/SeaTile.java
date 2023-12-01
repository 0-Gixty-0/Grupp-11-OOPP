package com.group11.model.gameworld;

import java.awt.Point;
/**
* This class represents a concrete implementation for sea tiles, extending the abstract class ATile.
*/
public class SeaTile extends ATile {

    /**
    * Constructor for the class SeaTile
    * @param pos - The position of a tile as a Java Point 
    */
    public SeaTile(Point pos) {
        super(0, pos, true);
    }
    
}