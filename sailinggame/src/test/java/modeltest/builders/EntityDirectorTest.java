package modeltest.builders;

import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import org.junit.Test;

import java.awt.*;


import static org.junit.Assert.assertTrue;

public class EntityDirectorTest {

    EntityDirector entityDirector = new EntityDirector(new ShipBuilder());

    @Test
    public void changeBuilderTest() {
        entityDirector.changeBuilder(new ShipBuilder());

        assertTrue(entityDirector instanceof EntityDirector);
    }

    @Test
    public void createPlayerTest() {

        AEntity player = entityDirector.createPlayer(new Point(0,0));

        assertTrue(player instanceof AEntity);
    }

    @Test
    public void createEnemyTest() {

        AEntity enemy = entityDirector.createEnemy(new Point(0,0), 1);

        assertTrue(enemy instanceof AEntity);
    }
}