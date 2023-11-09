package com.group11.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AShip extends AMovableBody {

    private int sailArea;
    private int armor;
    private int cannons;
    private Array<item> inventory;

    public AShip(int sailArea, int armor, int cannons, Array<item> inventory){
        this.sailArea = sailArea;
        this.armor = armor;
        this.cannons = cannons;
        this, inventory = inventory;
    }

    abstract public void setSail() {
        bool sailUp;
    }

    abstract public void lowerSail(){
        bool sailDown;
    }

    abstract public void fireCannons(int);
    abstract public void anchor(){
        bool anchorDown;
        if(anchorDown == True){
            velocity = 0;
        }
    }
}