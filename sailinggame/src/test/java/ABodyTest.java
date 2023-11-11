import org.junit.Test;

import com.group11.model.SmallShip;

import static org.junit.Assert.*;

import java.awt.*;

public class ABodyTest {

    SmallShip smallShip = new SmallShip(1,10,0, true);

    @Test
    public void testSetVelocity() {
        smallShip.setVelocity(10);
        int testVelocity = smallShip.getVelocity();
        assertEquals(testVelocity, 10);
    }

    @Test
    public void testTakeDamage() {
        smallShip.setHitPoints(100);
        int testHitPoints = smallShip.getHitPoints();
        assertEquals(testHitPoints, 100);
        smallShip.takeDamage(75);
        testHitPoints = smallShip.getHitPoints();
        assertEquals(testHitPoints, 25);
    }

    @Test
    public void testPosition() {
        Point testPosition = new Point(10, 20);
        smallShip.setPos(testPosition);
        Point secondPosition = smallShip.getPos();
        assertEquals(testPosition, secondPosition);
    }
}