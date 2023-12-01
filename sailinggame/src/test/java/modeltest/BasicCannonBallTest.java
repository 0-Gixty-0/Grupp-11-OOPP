package modeltest;

import com.group11.model.gameentites.BasicCannonBall;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicCannonBallTest {



    BasicCannonBall testBall = new BasicCannonBall();
    @Test
    public void testConcreteTravel() {

        testBall.setDirection(new int[] {0, 1});

        testBall.continueTravelPath();

        assertEquals(testBall.getPos().x, 0);
        assertEquals(testBall.getPos().y, 1);
    }
}
