package com.group11.model.gameentites;

import java.awt.Point;

/**
 * A class that is used as an abstraction that gives tiles and entities their position attribute
 */
public abstract class APositonable {

    /**
     * The position of a tile or entity as a Java Point.
     */
    private Point pos;

    /**
     * Constructor for the abstract class APositionable
     * @param textureId - Integer for the texture ID for tiles and entities
     * @param pos - The position of a tile or entity as a Java Point 
     */
    protected APositonable(Point pos){
        this.pos = pos;
    }

    /**
    * Returns the position of a tile or entity
    * @return A Java Point for the position of the tile or entity
    */
    public Point getPos() {
        int currentX = (int) this.pos.getX();
        int currentY = (int) this.pos.getY();
        Point safePosCopy = new Point(currentX, currentY);
        return safePosCopy;
    }

    /**
     * Used within the model package to get the true position of the body
     * not a safe copy.
     * @return (Point) The position of the entities body.
     */
    protected Point getTruePos() {
        return this.pos;
    }
}
