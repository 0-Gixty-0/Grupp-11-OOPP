package modelTest;

import org.junit.Test;

import com.group11.model.gameEntities.Ship;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShipTest {

    Ship testShip = new Ship(null, 0, 0, 0, 2);

    @Test
    public void testGetShipLevel() {
        assertEquals(testShip.getShipLevel(), 0);
    }

    @Test
    public void testGetArmor() {
        assertEquals(testShip.getArmor(), 0, 0);
    }

    @Test
    public void testGetCannons() {
        assertEquals(testShip.getCannons(), 0);
    }

    @Test
    public void testRaiseSail() {
        testShip.raiseSail();
        assertTrue(testShip.getSailStatus());
    }

    @Test
    public void testLowerSail() {
        testShip.lowerSail();
        assertFalse(testShip.getSailStatus());
    }

    @Test
    public void testGetAnchorStatus() {
        testShip.anchorDown();
        assertTrue(testShip.getAnchorStatus());
    }

    @Test
    public void testAnchorUp() {
        testShip.anchorUp();
        assertFalse(testShip.getAnchorStatus());
    }

    @Test
    public void testAnchorDown() {
        testShip.anchorDown();
        assertTrue(testShip.getAnchorStatus());
    }

    @Test
    public void testFireWeapon() {
        // Method is not implemented yet.
    }
}