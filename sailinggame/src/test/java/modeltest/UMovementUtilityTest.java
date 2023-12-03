        package modeltest;

import static org.junit.Assert.assertFalse;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;

public class UMovementUtilityTest {

    @Test
    public void movementIsPossible() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        UMovementUtility.setTileMatrix(map.getTileMatrix());
        assertFalse(UMovementUtility.movementIsPossible(new Point(25,11), new int[]{0,1}));
    }

}