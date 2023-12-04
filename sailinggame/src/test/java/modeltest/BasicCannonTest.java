package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.BasicCannon;
import com.group11.model.gameentites.BasicCannonBall;


public class BasicCannonTest {

    private class TestWeapon extends BasicCannon {

        public TestWeapon(Class<? extends AProjectile> projectileType) {
            super(projectileType);
        }

        public int debugFiredProjectilesSize() {
            return this.getFiredProjectilesSize();
        }

        public Class<? extends AProjectile> debugGetProjectileType() {
            return this.getProjectileType();
        }

    }


    TestWeapon testCannon = new TestWeapon(BasicCannonBall.class);

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