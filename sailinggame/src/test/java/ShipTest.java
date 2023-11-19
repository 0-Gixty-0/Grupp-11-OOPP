import org.junit.Test;

import com.group11.model.Ship;

import static org.junit.Assert.*;

public class ShipTest {

    Ship testShip = new Ship(null, null, 0, 0, 0, 2);

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
}