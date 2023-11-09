package com.group11.Model;

public abstract class AMovableBody extends ABody implements IMovable{

    private int velocity;

    public AMovableBody(int velocity){
        super(new ArrayList<>(), (0,0), 100, velocity);
        this.velocity = velocity;
    }
    @Override
    public void move(int x, int y){
    }
}