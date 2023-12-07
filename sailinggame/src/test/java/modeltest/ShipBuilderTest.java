package modeltest;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.awt.Point;

import com.group11.model.gameentites.BasicCannon;
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
        Ship body = (Ship) player.getBody();
        assertEquals("Player", player.getName());
        assertEquals(new Point(0,0), player.getPos());
        assertEquals(22.5, body.getHitPoints());
        assertEquals(6.0, body.getArmor());
        assertEquals(1, body.getShipLevel());
        assertTrue(body.getWeapon() instanceof BasicCannon);
        assertTrue(player.isFriendly());
    }

    @Test
    public void createEnemyLevelOneTest() {
        EntityDirector entityDirector = new EntityDirector(new ShipBuilder());
        AEntity enemy = entityDirector.createEnemy(new Point(0,0), 1);
        Ship body = (Ship) enemy.getBody();
        assertEquals("Enemy: lvl 1", enemy.getName());
        assertEquals(new Point(0,0), enemy.getPos());
        assertEquals(22.5, body.getHitPoints());
        assertEquals(6.0, body.getArmor());
        assertEquals(1, body.getShipLevel());
        assertTrue(body.getWeapon() instanceof BasicCannon);
        assertFalse(enemy.isFriendly());
    }

    @Test
    public void createEnemyLevelTwoTest() {
        EntityDirector entityDirector = new EntityDirector(new ShipBuilder());
        AEntity enemy = entityDirector.createEnemy(new Point(0,0), 2);
        Ship body = (Ship) enemy.getBody();
        assertEquals("Enemy: lvl 2", enemy.getName());
        assertEquals(new Point(0,0), enemy.getPos());
        assertEquals(45.0, body.getHitPoints());
        assertEquals(12.0, body.getArmor());
        assertEquals(2, body.getShipLevel());
        assertTrue(body.getWeapon() instanceof BasicCannon);
        assertFalse(enemy.isFriendly());
    }
}
