package com.group11.Model;

public abstract class AShip extends AMovableBody {

    private int sailLevel;
    private int armor;
    private int cannons;

    private int velocity = getVelocity();


    public AShip(int sailLevel, int armor, int cannons){
        this.sailLevel = sailLevel;
        this.armor = armor;
        this.cannons = cannons;
    }

    public void setSail() {boolean sailUp = true;
    }

    public void lowerSail(){boolean sailDown = true;
    }

    abstract public void fireCannons(int damage);
    public void anchor(){
        boolean anchorDown = false;
        if(anchorDown == true){
            setVelocity(0);
        }
    }
}