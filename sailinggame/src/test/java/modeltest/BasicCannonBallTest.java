package modeltest;

import com.group11.model.gameentites.BasicCannonBall;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BasicCannonBallTest {



    BasicCannonBall testBall = new BasicCannonBall();
    @Test
    public void testMoveInTravelPath() {

        Map map = (new BasicMapGenerator()).generateMap(10,10);
        UMovementUtility.setTileMatrix(map.getTileMatrix());


        int[] testDir = {0,1};

        testBall.setDirection(testDir);

        testBall.moveInTravelPath();
        assertEquals(testBall.getPos(), new Point(0,1));
    }
}
