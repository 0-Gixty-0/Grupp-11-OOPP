package modeltest;

import com.group11.model.gameentites.BasicCannon;
import com.group11.model.gameentites.BasicCannonBall;
import org.junit.Test;

import static org.junit.Assert.*;


public class BasicCannonTest {

    BasicCannon testCannon = new BasicCannon(new BasicCannonBall());

    @Test
    public void testGetProjectileType() {
        Object projectile = testCannon.getProjectileType();
        assertTrue(projectile instanceof BasicCannonBall);
    }

    @Test
    public void testGetFiredProjectilesSize() {

        testCannon.fireWeapon();

        assertEquals(testCannon.getFiredProjectilesSize(), 1);
    }

    @Test
    public void testFireWeapon() {

        testCannon.fireWeapon();

        assertEquals(testCannon.getFiredProjectilesSize(), 1);
    }
}