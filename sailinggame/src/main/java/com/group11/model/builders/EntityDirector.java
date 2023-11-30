package com.group11.model.builders;

import java.awt.*;

import com.group11.model.gameentites.AEntity;

/**
 * EntityDirector class represents an api into the entity builder hierarchy and is called
 * from other parts of the model to create model representations of entities
 */
public class EntityDirector {
    private IEntityBuilder builder;

    public EntityDirector(IEntityBuilder builder) {
        this.builder = builder;
    }

    /**
     * Changes the currently active builder for the director
     * @param builder The desired concrete builder class
     */
    public void changeBuilder(IEntityBuilder builder) {
        this.builder = builder;
    }

    /**
     * Creates the model representation of a player based on active builder
     * @param position The position of the body at creation
     * @return Object of type AEntity representing the player with body decided by active builder
     */
    public AEntity createPlayer(Point position) {
        builder.reset();
        builder.setName("Player");
        builder.setFriendlyStatus(true);
        builder.setPosition(position);
        builder.setAttributesForLevel(1);
        builder.setBody();
        return builder.createEntity();
    }

    /**
     * Creates the model representation of an enemy based on active builder
     * @param position The position of the body at creation
     * @return Object of type AEntity representing the enemy with body decided by active builder
     */
    public AEntity createEnemy(Point position, int lvl) {
        builder.reset();
        builder.setName(String.format("Enemy: lvl %d",lvl));
        builder.setFriendlyStatus(false);
        builder.setPosition(position);
        builder.setAttributesForLevel(lvl);
        builder.setBody();
        return builder.createEntity();
    }
}

