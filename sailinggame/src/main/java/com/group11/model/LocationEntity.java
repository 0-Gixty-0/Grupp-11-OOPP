package com.group11.model;

/**
 * A class representing the subset of fixed, immovable, entities in the game world. For example port cities.
 */
public class LocationEntity extends AEntity {

    /**
     * Constructor used to create LocationEntities.
     * @param body The body of the location.
     * @param name The name of the location.
     * @param friendly If the location is of friendly allegience to the player.
     */
    public LocationEntity(AImmovableBody body, String name, Boolean friendly) {
        super(body, name, friendly);
    }


    /**
     * Sets the body of the location entity.
     * @param body The new body of the location entity.
     */
    public void setImmovableBody(AImmovableBody body) {
        this.setBody(body);
    }

}
