package com.group11.model;

/**
 * This class is an abstraction that gives tiles and entities their texture attribute
 */
public abstract class ATextureIdentifiable {

    /**
     * The texture ID used by tiles or entities.
     */
    private int textureId;

    /**
     * Constructor for the abstract class ATextureIdentifiable
     * @param textureId - An integer that represents the texture ID
     */
    protected ATextureIdentifiable(int textureId) {
        this.textureId = textureId;
    }
    
    /**
     * Getter for the specific texture ID used by a tile or entity
     * @return the texture ID integer that a tile or entity has 
     */
    public int getTextureId(){
        return this.textureId;
    }
}
