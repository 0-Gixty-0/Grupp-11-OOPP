package Application;

import com.group11.EntitySpawner;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.World;
import org.junit.Test;

import java.awt.*;

public class EntitySpawnerTest {

    EntitySpawner testEntitySpawner = new EntitySpawner(10, 10, new BasicWorldGenerator(new BasicMapGenerator()).generateWorld(10, 10));

    @Test
    public void testSpawnEntity() {
        int height = 10;
        int width = 10;

        IMapGenerator testMap = new BasicMapGenerator();
        World world = new BasicWorldGenerator(testMap).generateWorld(50, 50);
        Point point = testEntitySpawner.spawnEntity();
        assert point.x >= 0 && point.x < height;
        assert point.y >= 0 && point.y < width;
    }
}
