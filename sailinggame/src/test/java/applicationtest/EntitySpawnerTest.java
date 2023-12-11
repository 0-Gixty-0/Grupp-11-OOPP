package applicationtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group11.application.EntitySpawner;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.World;

public class EntitySpawnerTest {

    IMapGenerator testMapGenerator = new BasicMapGenerator();
    World testWorld = (new BasicWorldGenerator(testMapGenerator)).generateWorld(100 ,100);
    EntitySpawner testSpawner = new EntitySpawner(testWorld, new ShipBuilder());

    @Test
    public void spawnEnemyTest() {
        assertEquals(testSpawner.spawnEnemy(1).getClass(), CommandableEntity.class);
    }

    @Test
    public void spawnPlayerTest() {
        assertEquals(testSpawner.spawnPlayer().getClass(), CommandableEntity.class);
    }

}