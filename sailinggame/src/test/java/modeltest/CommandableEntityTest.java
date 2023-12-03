package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.Ship;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;

public class CommandableEntityTest {

    @Test
    public void testTryingToMoveOverImpassableTerrain() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        UMovementUtility.setTileMatrix(map.getTileMatrix());

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

    private void move(int direction, Ship body) {
        Map map = (new BasicMapGenerator()).generateMap(50);
        UMovementUtility.setTileMatrix(map.getTileMatrix());
        CommandableEntity entity = new CommandableEntity(body, "testy mcTest", true);
        entity.moveCommand(direction);
    }

    @Test
    public void testMoveUp() {
        Ship testShip = new Ship(new Point(1,0), 0, 0, 0, 2);
        this.move(0, testShip);
        assertEquals(0, (int) testShip.getPos().getY());
        assertEquals(0, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveUpRightAngle() {
        Ship testShip = new Ship(new Point(1,1), 0, 0, 0, 2);
        this.move(1,testShip);
        assertEquals(2, (int) testShip.getPos().getY());
        assertEquals(0, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveRight() {
        
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        this.move(2,testShip);
        assertEquals(1, (int) testShip.getPos().getY());
        assertEquals(0, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveDownRightAngle() {
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        this.move(3,testShip);
        assertEquals(1, (int) testShip.getPos().getY());
        assertEquals(1, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveDown() {
        Ship testShip = new Ship(new Point(0,0), 0, 0, 0, 2);
        this.move(4,testShip);
        assertEquals(0, (int) testShip.getPos().getY());
        assertEquals(1, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveDownLeftAngle() {
        Ship testShip = new Ship(new Point(1,1), 0, 0, 0, 2);
        this.move(5,testShip);
        assertEquals(0, (int) testShip.getPos().getY());
        assertEquals(2, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveLeft() {
        Ship testShip = new Ship(new Point(1,1), 0, 0, 0, 2);
        this.move(6,testShip);
        assertEquals(0, (int) testShip.getPos().getY());
        assertEquals(1, (int) testShip.getPos().getX());
    }

    @Test
    public void testMoveUpLeftAngle() {
        Ship testShip = new Ship(new Point(1,1), 0, 0, 0, 2);
        this.move(7,testShip);
        assertEquals(0, (int) testShip.getPos().getY());
        assertEquals(0, (int) testShip.getPos().getX());
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