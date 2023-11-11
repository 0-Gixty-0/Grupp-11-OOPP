package com.group11.Model;

public abstract class AEntity implements ICommandable {
    
    private String name;

    private Boolean friendly;

    public AEntity(String name, Boolean friendly) {
        this.name = name;
        this.friendly = friendly;
    }

    public String getName() {
        return name;
    }

    public Boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }
}
