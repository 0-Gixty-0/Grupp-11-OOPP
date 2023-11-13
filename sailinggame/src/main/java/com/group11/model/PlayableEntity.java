package com.group11.model;
import java.awt.Point;

/**
 * The PlayableEntity class represents an instance of the player in the game world. 
 */
public class PlayableEntity extends AMovableEntity {

 /**
  * Constructor for a playable entity (commonly just the player)
  * @param body The body the player should use.
  * @param name The name of the player..
  */
  public PlayableEntity(AMovableBody body, String name) {
      super(body, name, true);
  }

  /**
   * A Helper method for movecommand implementation in PlayableEntity using pseudo linear algebra.
   * @param velocity The amount of tiles each move moves.
   * @param dirVector The direction the body should move in.
   */
  private void moveHelper(int velocity, int [] dirVector) {
    for (int i = 0; i < velocity; i++ ) {
        Point currPos = this.getBody().getPos();
        int currX = (int) currPos.getX();
        int currY = (int) currPos.getY();
        this.getBody().move(currX + dirVector[0],currY + dirVector[1]);
    }
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
      int velocity = this.getBody().getVelocity();
      int[][] directions = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
      this.moveHelper(velocity, directions[direction]);
  }

  @Override
  public void attackCommand(Integer direction) {
      //Placeholder for later implementation.
  }

  @Override
  public void interactCommand() {
      //Placeholder for later implementation.
  }
  
}
