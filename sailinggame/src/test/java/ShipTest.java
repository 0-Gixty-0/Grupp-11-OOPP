import org.junit.Test;

import com.group11.model.Ship;

import java.awt.*;

import static org.junit.Assert.*;

public class ShipTest {

    Ship testShip = new Ship(null, 0, 0, 0, 2);

    @Test
    public void testAnchor() {
        testShip.anchorUp();
        assertEquals(testShip.getAnchorStatus(), false);
        testShip.anchorDown();
        assertEquals(testShip.getAnchorStatus(), true);
        assertEquals(testShip.getVelocity(), 0);
    }

    @Test
    public void testSail() {
        testShip.raiseSail();
        assertEquals(testShip.getSailStatus(), true);
        testShip.lowerSail();
        assertEquals(testShip.getSailStatus(),false);
    }

    @Test
    public void testDefaultConstructor() {
        Ship ship = new Ship(new Point(0,0));
        assertEquals(1, ship.getShipLevel());
        assertEquals(2.0, ship.getArmor(), 0);
        assertEquals(5, ship.getCannons());
        assertTrue(ship.getSailStatus());
        assertFalse(ship.getAnchorStatus());
    }
}