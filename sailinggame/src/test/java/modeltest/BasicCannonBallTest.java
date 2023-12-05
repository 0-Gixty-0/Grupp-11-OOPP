package modeltest;

import com.group11.model.gameentites.BasicCannonBall;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UMovementUtility;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BasicCannonBallTest {

    BasicCannonBall testBall = new BasicCannonBall(new Point(0,0), new int[]{1,1});

    @Test
    public void testFollowsCorrectPath() {
        Map map = (new BasicMapGenerator()).generateMap(50, 50);
        UMovementUtility.setTileMatrix(map.getTileMatrix());

        for (int i = 1; i <= 5; i++) {
            testBall.travel();
            assertEquals(testBall.getPos(), new Point(i, i));
        }
    }
}
