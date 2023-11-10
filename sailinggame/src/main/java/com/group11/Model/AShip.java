package com.group11.Model;

public abstract class AShip extends AMovableBody {

    private int sailLevel;
    private int armor;
    private int cannons;

    private boolean anchorDown = false;


    public AShip(int sailLevel, int armor, int cannons){
        super(0);
        this.sailLevel = sailLevel;
        this.armor = armor;
        this.cannons = cannons;
        setVelocity(getVelocity());
    }

    public void setSail() {boolean sailUp = true;
    }

    public void lowerSail(){boolean sailDown = true;
    }

    abstract public void fireCannons(int damage);
    public void anchor(){
        this.anchorDown = !anchorDown;
        if(anchorDown){
            setVelocity(0);
        }
    }
}