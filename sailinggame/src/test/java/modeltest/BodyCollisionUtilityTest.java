package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.Ship;
import com.group11.model.utility.UBodyCollisionUtility;

public class BodyCollisionUtilityTest {

    private List<List<AEntity>> entites;
    private AEntity testEntity;
    private AEntity testEntity2;
    private Point pos;

    @Before
    public void setUp() {
        this.entites = new ArrayList<>();
        this.pos = new Point(0, 0);
        Point pos2 = new Point(0,0);
        this.testEntity = new CommandableEntity(new Ship(pos, 0, 0, 0, 0), null, null);
        this.testEntity2 = new CommandableEntity(new Ship(pos2, 0, 0, 0, 0), null, null);
        this.entites.add(new ArrayList<AEntity>() {{
                add(testEntity);
            }});
    }

    @Test
    public void testSetBodies() {
        UBodyCollisionUtility.setBodyMatrix(null);
        assertThrows(IllegalStateException.class, ()->UBodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsPositionOccupied() {
        UBodyCollisionUtility.setBodyMatrix(entites);
        assertEquals(testEntity, UBodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsBodyColliding() {
        UBodyCollisionUtility.setBodyMatrix(entites);
       assertEquals(testEntity, UBodyCollisionUtility.isEntityColliding(testEntity2));
    }
}