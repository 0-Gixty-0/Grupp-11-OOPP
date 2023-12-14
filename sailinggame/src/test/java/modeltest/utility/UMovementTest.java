        package modeltest.utility;

import static org.junit.Assert.assertFalse;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovement;

public class UMovementTest {

    @Test
    public void movementIsPossible() {
        Map map = (new BasicMapGenerator()).generateMap(50,50);
        UMovement.setTileMatrix(map.getTileMatrix());
        assertFalse(UMovement.movementIsPossible(new Point(25,11), new int[]{0,1}));
    }

}