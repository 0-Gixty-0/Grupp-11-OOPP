package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group11.model.gameentites.BasicCannon;
import com.group11.model.gameentites.BasicCannonBall;


public class BasicCannonTest {

    private class TestWeapon<T> extends BasicCannon<T> {

        public TestWeapon(T projectileType) {
            super(projectileType);
        }

        public int debugFiredProjectilesSize() {
            return this.getFiredProjectilesSize();
        }

        public T debugGetProjectileType() {
            return this.getProjectileType();
        }

    }


    TestWeapon<BasicCannonBall> testCannon = new TestWeapon<>(new BasicCannonBall(null));

    @Test
    public void testGetProjectileType() {
        Object projectile = testCannon.debugGetProjectileType();
        assertTrue(projectile instanceof BasicCannonBall);
    }

    @Test
    public void testGetFiredProjectilesSize() {
        int [] direction = {0,1};
        testCannon.fireWeapon(direction);

        assertEquals(1, testCannon.debugFiredProjectilesSize());
    }

    @Test
    public void testFireWeapon() {
        int [] direction = {0,1};
        testCannon.fireWeapon(direction);

        assertEquals(1, testCannon.debugFiredProjectilesSize());
    }
}