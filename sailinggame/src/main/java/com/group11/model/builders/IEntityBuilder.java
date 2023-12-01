package com.group11.model.builders;

import java.awt.*;

import com.group11.model.gameentites.AEntity;

/**
 * Interface representing api for concrete builder classes of an entity
 */
public interface IEntityBuilder {
    /**
     * Sets the body of the entity based on builder attributes
     */
    void setBody();

    /**
     * Sets the name of the entity
     * @param name Name of entity
     */
    void setName(String name);

    /**
     * Sets the friendly status of the entity
     * @param status true = friendly, false = not friendly
     */
    void setFriendlyStatus(Boolean status);

    /**
     * Creates the entity object and returns it
     * @return Created entity object from builder
     */
    AEntity createEntity();

    /**
     * Resets builder attributes
     */
    void reset();

    /**
     * Sets builder attributes based on input level
     * @param lvl The desired level or "difficulty" of the entity
     */
    void setAttributesForLevel(int lvl);

    /**
     * Sets the position of the entity's body upon creation
     * @param position
     */
    void setPosition(Point position);
}
