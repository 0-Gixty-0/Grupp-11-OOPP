package Application;

import com.group11.EntitySpawner;
import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.World;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntitySpawnerTest {
    IMapGenerator testMapGenerator = new BasicMapGenerator();
    World testWorld = (new BasicWorldGenerator(testMapGenerator)).generateWorld(100,100);
    EntitySpawner testSpawner = new EntitySpawner(testWorld, new EntityDirector(new ShipBuilder()));
    @Test
    public void spawnEnemyTest() {
        assertEquals(testSpawner.spawnEnemy(1).getClass(), CommandableEntity.class);
    }

    @Test
    public void spawnPlayerTest() {
        assertEquals(testSpawner.spawnPlayer(1).getClass(), CommandableEntity.class);
    }

    @Test
    public void posIsPassableTest() {
        assertEquals(testSpawner.posIsPassable(testSpawner.generateRandomPos()), true);
    }

    @Test
    public void generateRandomPosTest() {
        assertEquals(testSpawner.generateRandomPos().getClass(), java.awt.Point.class);
    }
}
