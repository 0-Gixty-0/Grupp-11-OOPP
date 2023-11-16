package com.group11.model;

import java.awt.Point;


/**
 * A movable entity is a subset of entities that can move around the gameworld
 */
public abstract class AMovableEntity extends AEntity implements ICommandable {

    /**
     * Used to create a movable entity
     * @param body The body it should use
     * @param name The entities name
     * @param friendly A single factor which assigns the life long allegience of the entity
     */
    protected AMovableEntity(AMovableBody body, String name, Boolean friendly) {
        super(body, name, friendly);
    }

    /**
     * A Helper method for movement implementation using pseudo linear algebra. This should be the method
     * that does the actual moving of the body in subclasses.
     * @param velocity The amount of tiles each move moves.
     * @param dirVector The direction the body should move in.
     */
    protected void moveHelper(int [] dirVector) {
        Point currPos = this.getBody().getPos();
        if (MovementUtility.movementIsPossible(currPos, dirVector)) {
            int currX = (int) currPos.getX();
            int currY = (int) currPos.getY();
            this.getBody().move(currX + dirVector[0],currY + dirVector[1]);
        }
    }

    /**
     * @return (AMovableBody) body of the entity
     */
    @Override
    protected AMovableBody getBody() {
        return (AMovableBody) this.getBody();
    }

    /**
     * @param body New body of the entity
     */
    public void setBody(AMovableBody body) {
        this.setBody(body);
    }

}
