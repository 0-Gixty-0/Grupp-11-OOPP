package modelTest;

import com.group11.model.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class BasicCannonTest {

    BasicCannon testCannon = new BasicCannon(new BasicCannonBall());

    @Test
    public void testGetProjectileType() {
        Object projectile = testCannon.getProjectileType();
        assertTrue(projectile instanceof BasicCannonBall);
    }

    @Test
    public void testSetWeapon() {
        // No functionality to test yet.
    }
}
