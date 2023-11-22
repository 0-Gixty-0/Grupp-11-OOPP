import com.group11.model.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class UnplayableEntityTest {
    // Constructor has only a super call so the abstract class it inherits from should be tested for the constructor

    @Test
    public void testTryingToMoveOverImpassableTerrain() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());

        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);

        //Starting position is (0,0) which is the bottom left corner of the map
        for (int i = 0; i < 50; i++) { //Try to move entity to the top of the map. Through the big middle island created by BasicMapNGenerator.
            entity.moveCommand(1); //1 is a right up diagonal move
        }

        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(11, entityY);
        assertEquals(11, entityX);
    }

    @Test
    public void testMoveUp() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(0);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(1, entityY);
        assertEquals(0, entityX);
    }

    @Test
    public void testMoveUpRightAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(1);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(1, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveRight() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(2);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(0, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveDownRightAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(3);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(1, entityY);
        assertEquals(3, entityX);
    }

    @Test
    public void testMoveDown() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(4);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(1, entityY);
        assertEquals(2, entityX);
    }

    @Test
    public void testMoveDownLeftAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(5);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(1, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveLeft() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(6);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(2, entityY);
        assertEquals(1, entityX);
    }

    @Test
    public void testMoveUpLeftAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map.getTileMatrix());
        Ship testShip = new Ship(new Point(2,2), 0, 0, 0, 2);
        UnplayableEntity entity = new UnplayableEntity(testShip, "testy mcTest", true);
        entity.moveCommand(7);
        int entityY = (int) entity.getPos().getY();
        int entityX = (int) entity.getPos().getX();
        assertEquals(3, entityY);
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
    public void testInteractCommand() {
        //Placeholder for later implementation.
    }
}
