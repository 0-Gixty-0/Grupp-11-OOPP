package modeltest;

import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;
import org.junit.Test;

import com.group11.model.gameentites.Ship;

import static org.junit.Assert.*;
import java.awt.*;

public class AMovableBodyTest {

    Point position = new Point(0, 0);
    Ship testShip = new Ship(position, 0, 0, 0, 2);

    @Test
    public void testGetVelocity() {
        int velocity = testShip.getVelocity();
        assertEquals(velocity, 0);
    }

    @Test
    public void testSetVelocity() {
        testShip.setVelocity(10);
        assertEquals(testShip.getVelocity(),10);
    }

    @Test
    public void testMoveIfPossible() {

        Map map = (new BasicMapGenerator()).generateMap(10);
        UMovementUtility.setTileMatrix(map.getTileMatrix());

        int[] testDir = {0,1};

        testShip.moveIfPossible(testDir);

        Point testPos = testShip.getPos();

        assertEquals(testPos, new Point(0, 1));
    }
}