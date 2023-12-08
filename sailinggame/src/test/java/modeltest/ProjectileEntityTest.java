package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameentites.BasicCannonBall;
import com.group11.model.gameentites.ProjectileEntity;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;

public class ProjectileEntityTest {

    private ProjectileEntity setUp() {
        int [] direction = {1,1};
        ProjectileEntity testProjectile = (ProjectileEntity) new ProjectileEntity(new BasicCannonBall(new Point(0,0), direction), "CannonBall");
        Map map = (new BasicMapGenerator()).generateMap(50,50);
        UMovementUtility.setTileMatrix(map.getTileMatrix());
        return testProjectile;
    }

    @Test
    public void testIsOutOfRange() {
        ProjectileEntity testProjectile = setUp();
        assertFalse(testProjectile.isOutOfRange());
        for (int i = 0; i < 19; i++) {
            testProjectile.moveInTravelPath();
        }
        assertFalse(testProjectile.isOutOfRange());
        testProjectile.moveInTravelPath();
        System.out.println(testProjectile.getPos());
        assertTrue(testProjectile.isOutOfRange());
    }

    @Test
    public void testTravel() {
        ProjectileEntity testProjectile = setUp();
        testProjectile.moveInTravelPath();
        assertEquals(new Point(1,1), testProjectile.getPos());
    }

}