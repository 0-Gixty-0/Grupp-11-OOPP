package com.group11.model;

import java.awt.*;

public class ShipBuilder implements EntityBuilder {
    private static double hpScalingFactor = 1.5;
    private static double armorScalingFactor = 1.5;
    private AMovableBody body = null;
    private String name = null;
    private Boolean friendly = null;
    private int shipLevel = 0;
    private int armor = 0;
    private int weapon = 0;
    private boolean sailIsUp = true;
    private boolean anchorDown = false;
    private Point position = null;
    private double hp = 0;

    @Override
    public void setBody(ABody body) {
        if (body.equals(null)) {
            this.body = new Ship(this.position);
        } else {
            this.body = new Ship(this.position, this.shipLevel, this.armor, this.weapon, this.hp);
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setFriendlyStatus(Boolean status) {
        this.friendly = true;
    }

    @Override
    public AEntity createEntity() {
        AEntity product = new CommandableEntity(this.body, this.name, this.friendly);
        return product;
    }

    @Override
    public void reset() {
        this.body = null;
        this.name = null;
        this.friendly = true;
        this.hp = 0;
        this.weapon = 0;
        this.anchorDown = false;
        this.armor = 0;
        this.position = null;
        this.sailIsUp = true;
        this.shipLevel = 0;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void setAttributesForLevel(int lvl) {
        this.setHp(lvl * ShipBuilder.hpScalingFactor * 15);
    }

    private void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }

    private void setShipLevel(int shipLevel) {
        this.shipLevel = shipLevel;
    }

    private void setArmor(int armor) {
        this.armor = armor;
    }

    private void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    private void setSailIsUp(boolean sailIsUp) {
        this.sailIsUp = sailIsUp;
    }

    private void setAnchorDown(boolean anchorDown) {
        this.anchorDown = anchorDown;
    }

    private void setHp(double hp) {
        this.hp = hp;
    }
}
