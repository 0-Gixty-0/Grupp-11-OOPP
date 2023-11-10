package com.group11.Model;

import java.awt.*;
import java.util.ArrayList;

public abstract class AMovableBody extends ABody implements IMovable {


    public AMovableBody(int velocity){
        super(new ArrayList<>(), (new Point()), 100, velocity);
    }

    public void move(int x, int y) {
        Point new_position = new Point (x, y);
        this.setPos(new_position);
    }
}