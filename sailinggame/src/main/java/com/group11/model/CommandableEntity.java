package com.group11.model;

import java.awt.Point;


/**
 * A movable entity is a subset of entities that can move around the gameworld
 */
public class CommandableEntity extends AEntity implements ICommandable {

    /**
     * Used to create a commandable entity
     * @param body The body it should use
     * @param name The entity's name
     * @param friendly A single factor which assigns the life long allegience of the entity
     */
    public CommandableEntity(AMovableBody body, String name, Boolean friendly) {
        super(body, name, friendly);
    }

    /**
     * A Helper method for movement implementation using pseudo linear algebra. This should be the method
     * that does the actual moving of the body in subclasses.
     * @param dirVector The direction the body should move in.
     */
    protected void moveHelper(int [] dirVector) {
        Point currPos = this.getBody().getPos();
        if (MovementUtility.movementIsPossible(currPos, dirVector)) {
            int currX = (int) currPos.getX();
            int currY = (int) currPos.getY();
            AMovableBody body = (AMovableBody) this.getBody();
            body.move(currX + dirVector[0],currY + dirVector[1]);
        }
    }

    /**
     * Sets the body of the movable entity.
     * @param body The new body of the movable entity.
     */
    public void setMovableBody(AMovableBody body) {
        this.setBody(body);
    }

    /**
     * Issue a move command to a entity in 8 difference directions using these integers as arguments:
     * 0 moves straight up,
     * 1 moves at a right angle up,
     * 2 moves straight right,
     * 3 moves at a right angle down,
     * 4 moves at straight down,
     * 5 moves at a left angle down,
     * 6 moves straight left,
     * 7 move at a left angle up,
     * @param direction Moves the Entity in the chosen direction (see the index above).
     */
    @Override
    public void moveCommand(Integer direction) {
        int[][] directions = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        if (this.getBody() instanceof IMovable) {
            this.moveHelper(directions[direction]);
        } else {
            System.out.println(String.format("Objects of type %s cannot move",this.getBody().getClass().getName()));
        }
    }

    /**
     * This method checks if the entities body has a weapon and if so fires it in the desired direction
     * @param direction The direction to fire the weapon
     */
    @Override
    public void attackCommand(Integer direction) {
        int[][] directions = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        if (this.getBody() instanceof HasWeapon) {
            ((HasWeapon) this.getBody()).fireWeapon(directions[direction]);
        } else {
            System.out.println(String.format("Objects of type %s cannot attack",this.getBody().getClass().getName()));
        }
    }

    @Override
    public void interactCommand() {
        if (this.getBody() instanceof ICanInteract) {
            //Placeholder for later implementation.
        } else {
            System.out.println(String.format("Objects of type %s cannot interact",this.getBody().getClass().getName()));
        }
    }
}
