package com.group11.model;

/**
 * A class representing the subset of fixed, immovable, entities in the game world. For example port cities.
 */
public class LocationEntity extends AEntity {

    private AImmovableBody body;

    /**
     * Constructor used to create LocationEntities.
     * @param body The body of the location.
     * @param name The name of the location.
     * @param friendly If the location is of friendly allegience to the player.
     */
    public LocationEntity(AImmovableBody body, String name, Boolean friendly) {
        super(name, friendly);
        this.body = body;
    }

    /**
     * 
     * @return (ABody) of the LocationEntity
     */
    public AImmovableBody getBody() {
        return body;
    }

    /**
     * 
     * @param body New body for the LocationEntity
     */
    public void setBody(AImmovableBody body) {
        this.body = body;
    }

}
