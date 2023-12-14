package modeltest.gameentities;

import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.BasicCannon;
import com.group11.model.gameentites.BasicCannonBall;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class AWeaponTest {

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

    @Test
    public void getFiredProjectilesTest() {
        /*
        TestWeapon testWeapon = new TestWeapon(BasicCannonBall.class);
        assertEquals(0, testWeapon.getFiredProjectiles().size());
        testWeapon.fireWeapon(new Point(0,0), new int[]{0,1});
        assertEquals(1, testWeapon.getFiredProjectiles().size());

        // TODO: Write test

         */
    }

    @Test
    public void removeOutOfRangeProjectilesTest() {
        // TODO: Write test
    }

    @Test
    public void removeDeadProjectilesTest() {
        // TODO: Write test
    }
}