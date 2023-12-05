package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;

public class AProjectileTest {

    private class TestProjectile extends AProjectile {

        public TestProjectile(Point pos, int maxRange, int damage, int[] direction) {
            super(pos, maxRange, damage, direction);
        }

        @Override
        public void moveInTravelPath() {
            this.moveIfPossible(this.getDirection());
        }
        
    }

    private AProjectile setUp() {
        int [] direction = {1,1};
        AProjectile testProjectile = new TestProjectile(new Point(0,0), 10, 10, direction);
        Map map = (new BasicMapGenerator()).generateMap(50,50);
        UMovementUtility.setTileMatrix(map.getTileMatrix());
        return testProjectile;
    }

    @Test
    public void testIsOutOfRange() {
        AProjectile testProjectile = setUp();
        assertFalse(testProjectile.isOutOfRange());
        for (int i = 0; i < 9; i++) {
            testProjectile.travel();
        }
        assertFalse(testProjectile.isOutOfRange());
        testProjectile.travel();
        assertTrue(testProjectile.isOutOfRange());
    }

    @Test
    public void testTravel() {
        AProjectile testProjectile = setUp();
        testProjectile.travel();
        assertEquals(new Point(1,1), testProjectile.getPos());
    }

}