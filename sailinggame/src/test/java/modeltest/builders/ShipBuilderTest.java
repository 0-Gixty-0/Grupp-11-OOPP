package modeltest.builders;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.Ship;

public class ShipBuilderTest {
    @Test
    public void createPlayerTest() {
        EntityDirector entityDirector = new EntityDirector(new ShipBuilder());
        AEntity player = entityDirector.createPlayer(new Point(0,0));
        assertEquals(new Point(0,0), player.getPos());
        assertEquals(player.getBodyType(), Ship.class);
        assertTrue(player.isFriendly());
        assertEquals(player.getName(), "Player");
        assertEquals(player.getHitPoints(), 112);
    }

    @Test
    public void createEnemyLevelOneTest() {
        EntityDirector entityDirector = new EntityDirector(new ShipBuilder());
        AEntity enemy = entityDirector.createEnemy(new Point(0,0), 1);
        assertEquals(new Point(0,0), enemy.getPos());
        assertEquals(enemy.getBodyType(), Ship.class);
        assertFalse(enemy.isFriendly());
        assertEquals(enemy.getName(), "Enemy");
        assertEquals(enemy.getHitPoints(), 22);
    }

    @Test
    public void createEnemyLevelTwoTest() {
        EntityDirector entityDirector = new EntityDirector(new ShipBuilder());
        AEntity enemy = entityDirector.createEnemy(new Point(0,0), 2);
        assertEquals(new Point(0,0), enemy.getPos());
        assertEquals(enemy.getBodyType(), Ship.class);
        assertFalse(enemy.isFriendly());
        assertEquals(enemy.getName(), "Enemy");
        assertEquals(enemy.getHitPoints(), 45);
    }
}
