package modelTest;

import com.group11.model.*;
import com.group11.model.game_entites.CommandableEntity;
import com.group11.model.game_entites.Ship;
import com.group11.model.game_world.BasicMapGenerator;
import com.group11.model.game_world.Map;
import com.group11.model.high_level_components.MovementUtility;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandableEntityTest {

    @Test
    public void testTryingToMoveOverImpassableTerrain() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());

        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);

        //Starting position is (0,0) which is the top left corner of the map
        for (int i = 0; i < 50; i++) { //Try to move entity to the top of the map. Through the big middle island created by BasicMapNGenerator.
            entity.moveCommand(3); //1 is a right down diagonal move
        }

        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(11, entityY);
        assertEquals(11, entityX);
    }

    @Test
    public void testMoveUp() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(0,1), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(0);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(0, entityY);
        assertEquals(0, entityX);
    }

    @Test
    public void testMoveUpRightAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(1,1), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(1);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(0, entityY);
        assertEquals(2, entityX);
    }

    @Test
    public void testMoveRight() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(2);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(0, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveDownRightAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(3);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(3, entityY);
        assertEquals(3, entityX);
    }

    @Test
    public void testMoveDown() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(4);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(3, entityY);
        assertEquals(2, entityX);
    }

    @Test
    public void testMoveDownLeftAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(5);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(3, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveLeft() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(6);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(2, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveUpLeftAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        CommandableEntity entity = new CommandableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(7);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(1, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testAttackCommandHasWeapon() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testAttackCommandDoesNotHaveWeapon() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testMoveCommandCanMove() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testMoveCommandCannotMove() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testInteractCommandCanInteract() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testInteractCommandCannotInteract() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testCreateCommandableEntity() {
        Ship ship = new Ship(new Point(0,0));
        CommandableEntity entity = new CommandableEntity(ship, "testEntity", true);
        assertEquals("testEntity", entity.getName());
        assertEquals(new Point(0,0), entity.getPos());
        assertTrue(entity.isFriendly());
    }
}