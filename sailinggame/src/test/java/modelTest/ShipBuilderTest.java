package modelTest;

import com.group11.model.*;
import com.group11.model.buildersAndFactories.EntityDirector;
import com.group11.model.buildersAndFactories.ShipBuilder;
import com.group11.model.gameEntities.AEntity;
import com.group11.model.gameEntities.Ship;

import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

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
        assertFalse(body.getAnchorStatus());
        assertTrue(body.getSailStatus());
        assertEquals(1, body.getShipLevel());
        assertEquals(1, body.getCannons());
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
        assertFalse(body.getAnchorStatus());
        assertTrue(body.getSailStatus());
        assertEquals(1, body.getShipLevel());
        assertEquals(1, body.getCannons());
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
        assertFalse(body.getAnchorStatus());
        assertTrue(body.getSailStatus());
        assertEquals(2, body.getShipLevel());
        assertEquals(2, body.getCannons());
        assertFalse(enemy.isFriendly());
    }
}
