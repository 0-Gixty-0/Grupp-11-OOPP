        package modelTest;

import static org.junit.Assert.assertFalse;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.MovementUtility;

public class MovementUtilityTest {

    @Test
    public void movementIsPossible() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setTileMatrix(map.getTileMatrix());
        assertFalse(MovementUtility.movementIsPossible(new Point(25,11), new int[]{0,1}));
    }

}