package com.group11.model;

/**
 * A entity represents anything interactive in the world, it could be a town, creature, ship etc
 */
public abstract class AEntity {
    
    private String name;
    private Boolean friendly;
    private ABody body;

    /**
     * Used to construct a entity
     * @param name The entities name
     * @param friendly A single factor which assigns the life long allegience of the entity
     */
    protected AEntity(ABody body, String name, Boolean friendly) {
        this.name = name;
        this.friendly = friendly;
    }

    /**
     * 
     * @return (String) Name of the entity
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return (Boolean) The Allegience of the entity
     */
    public Boolean isFriendly() {
        return friendly;
    }

    /**
     * 
     * @param friendly The allegience of the entity
     */
    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }

    /**
     * 
     * @return (ABody) The body of the entity
     */
    protected ABody getBody() {
        return body;
    }
}
