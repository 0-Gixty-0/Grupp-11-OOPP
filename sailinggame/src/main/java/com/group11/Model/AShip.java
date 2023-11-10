package com.group11.Model;

public abstract class AShip extends AMovableBody {

    private int sailLevel;
    private int armor;
    private int cannons;
    private boolean sailStatus;

    private boolean anchorDown = false;


    public AShip(int sailLevel, int armor, int cannons, boolean sailStatus){
        super(0);
        this.sailLevel = sailLevel;
        this.armor = armor;
        this.cannons = cannons;
        this.sailStatus = sailStatus;
        setVelocity(getVelocity());
    }

    public void raiseSail() {
        sailStatus = true;
    }

    public void lowerSail() {
        sailStatus = false;
    }

    public boolean getSailStatus() {
        return this.sailStatus;
    }

    abstract public void fireCannons(int damage);



    //  Returns the status of the anchor
    //  True if down, false if up
    public boolean getAnchorStatus() {
        return this.anchorDown;
    }

    public void anchorUp() {
        this.anchorDown = false;
    }

    public void anchorDown() {
        this.anchorDown = true;
        if(anchorDown){
            setVelocity(0);
        }
    }
}