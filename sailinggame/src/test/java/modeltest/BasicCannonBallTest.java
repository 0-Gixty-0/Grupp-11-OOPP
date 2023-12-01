package modelTest;

import org.junit.Test;

import com.group11.model.*;

import static org.junit.Assert.assertEquals;

public class BasicCannonBallTest {



    BasicCannonBall testBall = new BasicCannonBall();
    @Test
    public void testConcreteTravel() {

        testBall.setDirection(new int[] {0, 1});

        testBall.concreteTravel();

        assertEquals(testBall.getPos().x, 0);
        assertEquals(testBall.getPos().y, 1);
    }
}
