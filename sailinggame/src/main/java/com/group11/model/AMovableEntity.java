package com.group11.model;

/**
 * A movable entity is a subset of entities that can move around the gameworld
 */
public abstract class AMovableEntity extends AEntity implements ICommandable {

    private AMovableBody body;
    /**
     * Used to create a movable entity
     * @param body The body it should use
     * @param name The entities name
     * @param friendly A single factor which assigns the life long allegience of the entity
     */
    protected AMovableEntity(AMovableBody body, String name, Boolean friendly) {
        super(name, friendly);
        this.body = body;
    }
    
    /**
     * 
     * @return (AMovableBody) body of the entity
     */
    public AMovableBody getBody() {
        return body;
    }

    /**
     * 
     * @param body New body of the entity
     */
    public void setBody(AMovableBody body) {
        this.body = body;
    }

}
