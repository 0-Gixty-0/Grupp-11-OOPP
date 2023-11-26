package modelTest;

import com.group11.model.AEntity;
import com.group11.model.IMovableEntityFactory;
import com.group11.model.StandardMovableEntityFactory;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class StandardMovableEntityFactoryTest {
    @Test
    public void testCreationOfPlayerCorrect() {
        IMovableEntityFactory factory = new StandardMovableEntityFactory();

        String name = "player";
        Point point = new Point(0,0);

        AEntity player = factory.createPlayer();

        assertEquals(name, player.getName());
        assertEquals(point, player.getPos());

        // Following attributes for the body of the player are untestable since the body is private without a getter
        int shipLevel = 0;
        int armor = 0;
        int cannons = 0;
        ArrayList<ArrayList<Boolean>> dimensions = new ArrayList<>();
        ArrayList<Boolean> tile = new ArrayList<>();
        tile.add(true);
        dimensions.add(tile);
    }

    // This test is set to check for null since an UnplayableEntity class is not yet implemented
    @Test
    public void testCreationOfEnemyCorrect() {
        IMovableEntityFactory factory = new StandardMovableEntityFactory();
        assertEquals(null, factory.createEnemy());
    }
}