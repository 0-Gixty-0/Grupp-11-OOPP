package com.group11.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class representing an abstract body. Implements the IDamageable interface
 * since a body can take damage.
 */

public abstract class ABody extends ATextureIdentifiable implements IDamageable {

    private ArrayList<ArrayList<Boolean>> dimensions;
    private Point pos;
    private int hitPoints;
    String description;

    /**
     * Constructor for creating objects of type ABody, the physical part of an entity in the game.
     * @param dimension - the dimension of the body
     * @param pos       - the position of the body in the tilemap
     * @param hitPoints - the hitpoints of the body
     */
    protected ABody(ArrayList<ArrayList<Boolean>> dimensions, Point pos, int hitPoints, int textureId, String description) {
        super(textureId);
        this.dimensions = dimensions;
        this.pos        = pos;
        this.hitPoints  = hitPoints;
    }

    /**
     * Reduces the hitpoints of the body
     * @param damage - the amount of damage taken by the body
     */
    @Override
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }

    /**
     * Returns the current hitpoints of the body
     * @return the current hitpoints of the body
     */
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * Sets the hitpoints of the body
     * @param newHitpoints - the new hitpoints value of the body
     */
    public void setHitPoints(int newHitpoints) {
        this.hitPoints = newHitpoints;
    }

    /**
     * A safe (wihout giving outside access and possibilty to modify position) 
     * way to return the positon of the entities body.
     * @return (Point) The position of the entities body
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

    /**
     * Sets the position of the body
     * @param newPosition - the new position of the body
     */
    public void setPos(Point newPosition){
        this.pos = newPosition;
    }

    /**
     * 
     * @return dimensions of an object.
     */
    public ArrayList<ArrayList<Boolean>> getDimensions() {
        return dimensions;
    }
    
    /**
     * 
     * @param dimensions desired body dimensions.
     */
    public void setDimensions(ArrayList<ArrayList<Boolean>> dimensions) {
        this.dimensions = dimensions;
    }
}