package applicationtest;

import com.group11.application.EntitySpawner;
import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.World;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EntitySpawnerTest {

    IMapGenerator testMapGenerator = new BasicMapGenerator();
    World testWorld = (new BasicWorldGenerator(testMapGenerator)).generateWorld(100 ,100);
    EntitySpawner testSpawner = new EntitySpawner(testWorld, new EntityDirector(new ShipBuilder()));

    @Test
    public void spawnEnemyTest() {
        assertEquals(testSpawner.spawnEnemy(1).getClass(), CommandableEntity.class);
    }

    @Test
    public void spawnPlayerTest() {
        assertEquals(testSpawner.spawnPlayer().getClass(), CommandableEntity.class);
    }

    @Test
    public void testEnemyWaveLevelOne() {
        List<CommandableEntity> enemyList = this.testSpawner.createEnemyWave(1);
        assertEquals("Enemy: lvl 1", enemyList.get(0).getName());
    }

    @Test
    public void testEnemyWaveLevelTwo() {
        List<CommandableEntity> enemyList = this.testSpawner.createEnemyWave(2);
        int lvl2num = 0;
        int lvl1num = 0;
        for (CommandableEntity enemy : enemyList) {
            System.out.println(enemy.getName());
            switch (enemy.getName()) {
                case "Enemy: lvl 1":
                    lvl1num++;
                    break;
                case "Enemy: lvl 2":
                    lvl2num++;
                    break;
            }
        }
        assertEquals(2, lvl1num);
        assertEquals(1, lvl2num);
    }
}