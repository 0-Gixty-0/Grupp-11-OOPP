package modeltest;

import org.junit.Test;

import com.group11.model.gameentites.Ship;

import static org.junit.Assert.*;

import java.awt.*;

public class ABodyTest {

    Point testPosition = new Point(10, 20);
    Ship testShip = new Ship(testPosition, 0, 0, 0, 100);

    @Test
    public void testTakeDamage() {
        testShip.takeDamage(10);
        assertEquals(testShip.getHitPoints(), 90, 0);
    }

    @Test
    public void GetHitPoints() {
        assertEquals(testShip.getHitPoints(), 100, 0);
    }

    @Test
    public void testSetDamage() {
        testShip.setHitPoints(20);
        assertEquals(testShip.getHitPoints(), 20, 0);
    }
}