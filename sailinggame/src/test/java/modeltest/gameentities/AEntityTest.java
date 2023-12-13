package modeltest.gameentities;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.Ship;

public class AEntityTest {

    Point testPosition = new Point(10, 20);
    Ship testShip = new Ship(testPosition, 0, 0, null, 100);

    CommandableEntity testEntity = new CommandableEntity(testShip, "Ship", true);

    @Test
    public void testGetName() {
        assertEquals("Ship", testEntity.getName());
    }

    @Test
    public void isFriendlyTest() {
        assertEquals(true, testEntity.isFriendly());
    }

    @Test
    public void setFriendlyTest() {
        testEntity.setFriendly(false);
        assertEquals(false, testEntity.isFriendly());
    }

    @Test
    public void getBodyTypeTest() {
        assertEquals(testEntity.getBodyType(), testShip.getClass());
    }

    @Test
    public void getBodyTest() {
        // TODO: Write test
    }

    @Test
    public void takeDamageTest() {
        testEntity.takeDamage(10);
        assertEquals(90, testEntity.getHitPoints());
    }

    @Test
    public void getHitPointsTest() {
        assertEquals(100, testEntity.getHitPoints());
    }

    @Test
    public void setHitPointsTest() {
        testEntity.setHitPoints(50);
        assertEquals(50, testEntity.getHitPoints());
    }

    @Test
    public void getPosTest() {
        assertEquals(testPosition, testEntity.getPos());
    }
}