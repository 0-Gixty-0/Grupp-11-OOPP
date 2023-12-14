package modeltest.gameworld;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.World;

public class BasicWorldGeneratorTest {

    IMapGenerator mapGenerator = new BasicMapGenerator();
    World testWorld = new BasicWorldGenerator(mapGenerator).generateWorld(10,10);

    @Test
    public void testGenerateWorld() {
        assertSame(World.class, testWorld.getClass());
    }
}