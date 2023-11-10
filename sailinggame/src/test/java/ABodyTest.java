import com.group11.Model.SmallShip;
import org.junit.Test;
import static org.junit.Assert.*;

import com.group11.Model.AShip;

import java.awt.*;

public class ABodyTest {

    SmallShip smallship = new SmallShip(1,10,0, true);

    @Test
    public void testSetVelocity() {
        smallship.setVelocity(10);
        int test_velocity = smallship.getVelocity();
        assertEquals(test_velocity, 10);
    }

    @Test
    public void testTakeDamage() {
        smallship.setHitPoints(100);
        int testHitPoints = smallship.getHitPoints();
        assertEquals(testHitPoints, 100);
        smallship.takeDamage(75);
        testHitPoints = smallship.getHitPoints();
        assertEquals(testHitPoints, 25);
    }

    @Test
    public void testPositionm() {
        Point test_position = new Point(10, 20);
        smallship.setPos(test_position);
        Point second_position = smallship.getPos();
        assertEquals(test_position, second_position);
    }
}