package com.group11.model;

import java.awt.*;

public interface EntityBuilder {
    void setBody(ABody body);
    void setName(String name);
    void setFriendlyStatus(Boolean status);
    AEntity createEntity();
    void reset();
    void setAttributesForLevel(int lvl);
    void setPosition(Point position);
}
