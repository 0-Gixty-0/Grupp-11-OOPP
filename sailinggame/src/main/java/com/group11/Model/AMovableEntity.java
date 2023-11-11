package com.group11.model;

public abstract class AMovableEntity extends AEntity implements ICommandable {

    private AMovableBody body;

    public AMovableEntity(AMovableBody body, String name, Boolean friendly) {
        super(name, friendly);
        this.body = body;
    }
    
}
