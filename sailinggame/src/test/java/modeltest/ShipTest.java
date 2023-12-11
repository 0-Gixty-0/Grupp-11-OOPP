package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.AWeapon;
import com.group11.model.gameentites.BasicCannon;
import com.group11.model.gameentites.BasicCannonBall;
import com.group11.model.gameentites.ProjectileEntity;
import com.group11.model.gameentites.Ship;

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
        public ProjectileEntity getProjectile() {
            return this.getFiredProjectiles().get(0);
        }

    }

    TestShip testShip = new TestShip(new Point(0,0), 0, 0, new TestWeapon(BasicCannonBall.class), 2);

    @Test
    public void testGetShipLevel() {
        assertEquals(0, testShip.getShipLevel());
    }

    @Test
    public void testGetArmor() {
        assertEquals(0, testShip.getArmor(), 0);
    }

    @Test
    public void testFireWeapon() {
        testShip.fireWeapon(new int[] {0, 1});
        Object projectile = testShip.getTestWeapon().debugGetProjectileType();
        Point pos = new Point(0,0);
        assertEquals(1, testShip.getTestWeapon().debugFiredProjectilesSize());
        assertSame(projectile, BasicCannonBall.class);
        assertEquals(pos, testShip.getTestWeapon().getProjectile().getPos());
    }
}