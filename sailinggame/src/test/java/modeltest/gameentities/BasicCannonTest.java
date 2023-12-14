package modeltest.gameentities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.awt.Point;

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

    Point firingPoint = new Point(0,0);
    TestWeapon testCannon = new TestWeapon(BasicCannonBall.class);

    @Test
    public void testGetProjectileType() {
        Object projectile = testCannon.debugGetProjectileType();
        assertSame(projectile, BasicCannonBall.class);
    }

    @Test
    public void testGetFiredProjectilesSize() {
        int [] direction = {0,1};
        testCannon.fireWeapon(firingPoint, direction);

        assertEquals(1, testCannon.debugFiredProjectilesSize());
    }

    @Test
    public void testFireWeapon() {
        int [] direction = {0,1};
        testCannon.fireWeapon(firingPoint, direction);

        assertEquals(1, testCannon.debugFiredProjectilesSize());
    }
}