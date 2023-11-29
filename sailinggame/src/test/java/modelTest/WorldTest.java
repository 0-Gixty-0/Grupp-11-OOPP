package modelTest;

import org.junit.Test;

import com.group11.model.game_world.BasicMapGenerator;
import com.group11.model.game_world.BasicWorldGenerator;
import com.group11.model.game_world.IMapGenerator;
import com.group11.model.game_world.Map;
import com.group11.model.game_world.World;

import static org.junit.Assert.*;

public class WorldTest {
    
    @Test
    public void testGetMap() {
        IMapGenerator basicMapGenerator = new BasicMapGenerator();
        World world = (new BasicWorldGenerator(basicMapGenerator)).generateWorld(100);
        assertSame(Map.class, world.getMap().getClass());
    }

    @Test
    public void testSetMap() {
        IMapGenerator basicMapGenerator = new BasicMapGenerator();
        World world = (new BasicWorldGenerator(basicMapGenerator)).generateWorld(100);
        Map oldMap = world.getMap();
        Map newMap = basicMapGenerator.generateMap(100);
        world.setMap(newMap);
        assertNotEquals(oldMap, world.getMap());
    }
}