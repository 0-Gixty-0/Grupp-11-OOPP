package modeltest;

import com.group11.model.gameentites.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ShipTest {

    private class TestShip extends Ship {
        private TestWeapon weaponBasic;

        public TestShip(Point pos, int shipLevel, double armor, AWeapon weapon, double hitPoints) {
            super(pos, shipLevel, armor, weapon, hitPoints);
            this.weaponBasic = (TestWeapon) weapon;
        }

        public TestWeapon getTestWeapon() {
            return this.weaponBasic;
        }
    }

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
        public AProjectile getProjectile() {
            return this.getFiredProjectiles().get(0);
        }

    }

    TestShip testShip = new TestShip(new Point(0,0), 0, 0, new TestWeapon(BasicCannonBall.class), 2);

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
        assertTrue(testShip.getWeapon() instanceof BasicCannon);
    }

    @Test
    public void testFireWeapon() {
        testShip.fireWeapon(new int[] {0, 1});
        Object projectile = testShip.getTestWeapon().debugGetProjectileType();
        Point pos = new Point(0,1);
        assertEquals(1, testShip.getTestWeapon().debugFiredProjectilesSize());
        assertSame(projectile, BasicCannonBall.class);
        assertTrue(pos.equals(testShip.getTestWeapon().getProjectile().getPos()));
    }
}