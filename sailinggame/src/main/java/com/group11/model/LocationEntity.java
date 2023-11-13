package com.group11.model;

public class LocationEntity extends AEntity {

    private ABody body;

    public LocationEntity(String name, Boolean friendly) {
        super(name, friendly);
        //TODO Auto-generated constructor stub
    }

    public ABody getBody() {
        return body;
    }

    public void setBody(ABody body) {
        this.body = body;
    }

}
