package com.group11.model;

import java.awt.*;

public interface EntityBuilder {
    void setBody();
    void setName(String name);
    void setFriendlyStatus(Boolean status);
    AEntity createEntity();
    void reset();
    void setAttributesForLevel(int lvl);
    void setPosition(Point position);
}
