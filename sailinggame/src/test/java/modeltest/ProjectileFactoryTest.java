package modeltest;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.factories.ProjectileFactory;
import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.BasicCannonBall;

public class ProjectileFactoryTest {

    @Test
    public void testCreateBasicCannonBall() {
        // Arrange
        Point pos = new Point(1, 1);
        int[] direction = new int[]{0, 1};

        // Act
        AProjectile projectile = ProjectileFactory.createBasicCannonBall(pos, direction);

        // Assert
        assertTrue(projectile instanceof BasicCannonBall);
        assertEquals(pos, projectile.getPos());
    }
}
