package com.group11.model.builders;

import java.awt.*;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.AMovableBody;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.Ship;

/**
 * Builder class representing creation methods and attributes for creating entities with the
 * body being an object of type Ship
 */
public class ShipBuilder implements IEntityBuilder {
    private static double hpScalingFactor = 1.5;
    private static double armorScalingFactor = 1.5;
    private AMovableBody body = null;
    private String name = null;
    private Boolean friendly = null;
    private int shipLevel = 0;
    private double armor = 0;
    private int weapon = 0;
    private boolean sailIsUp = true;
    private boolean anchorDown = false;
    private Point position = null;
    private double hp = 0;

    @Override
    public void setBody() {
        this.body = new Ship(this.position, this.shipLevel, this.armor, this.weapon, this.hp);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setFriendlyStatus(Boolean status) {
        this.friendly = status;
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

    /**
     * Sets the attributes of the builder based on level and scaling factor where applicable
     * @param lvl The desired level or "difficulty" of the entity
     */
    @Override
    public void setAttributesForLevel(int lvl) {
        this.setHp(lvl * ShipBuilder.hpScalingFactor * 15);
        this.setArmor(lvl * ShipBuilder.armorScalingFactor * 4);
        this.setShipLevel(lvl);
        this.setWeapon(lvl);
    }

    private void setShipLevel(int shipLevel) {
        this.shipLevel = shipLevel;
    }

    private void setArmor(double armor) {
        this.armor = armor;
    }

    private void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    private void setHp(double hp) {
        this.hp = hp;
    }
}
