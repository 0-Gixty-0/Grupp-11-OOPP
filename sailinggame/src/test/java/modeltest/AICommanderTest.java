package modeltest;

import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.ATile;
import com.group11.model.gameworld.LandTile;
import com.group11.model.gameworld.SeaTile;
import com.group11.model.utility.AICommander;
import com.group11.model.utility.UMovementUtility;
import com.group11.model.utility.UTileMatrixDecoder;
import com.group11.model.utility.UEntityMatrixGenerator;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AICommanderTest {
    private List<List<Integer>> grid = new ArrayList<>();
    private List<List<ATile>> terrainMatrix = new ArrayList<>();
    private EntityDirector director = new EntityDirector(new ShipBuilder());
    private List<AEntity> entities = new ArrayList<>();
    private List<List<AEntity>> entityMatrix = UEntityMatrixGenerator.createEntityMatrix(5,5, entities);

    private class TestAICommander extends AICommander {
        public TestAICommander(List<List<AEntity>> entityMatrix, List<List<ATile>> terrainMatrix) {
            super(entityMatrix);
            super.innerRadius = 1;
        }
    }

    @Before
    public void beforePreconditions() {
        this.grid.add(Arrays.asList(1,1,0,1,1));
        this.grid.add(Arrays.asList(1,0,1,0,1));
        this.grid.add(Arrays.asList(1,1,1,1,1));
        this.grid.add(Arrays.asList(1,0,1,0,1));
        this.grid.add(Arrays.asList(1,1,0,1,1));

        ArrayList<ATile> tileRow = new ArrayList<>();
        tileRow.add(new SeaTile(new Point(0,0)));
        tileRow.add(new SeaTile(new Point(0,1)));
        tileRow.add(new LandTile(new Point(0,2)));
        tileRow.add(new SeaTile(new Point(0,3)));
        tileRow.add(new SeaTile(new Point(0,4)));
        this.terrainMatrix.add(tileRow);
        tileRow = new ArrayList<>();

        tileRow.add(new SeaTile(new Point(1,0)));
        tileRow.add(new LandTile(new Point(1,1)));
        tileRow.add(new SeaTile(new Point(1,2)));
        tileRow.add(new LandTile(new Point(1,3)));
        tileRow.add(new SeaTile(new Point(1,4)));
        this.terrainMatrix.add(tileRow);
        tileRow = new ArrayList<>();

        tileRow.add(new SeaTile(new Point(2,0)));
        tileRow.add(new SeaTile(new Point(2,1)));
        tileRow.add(new SeaTile(new Point(2,2)));
        tileRow.add(new SeaTile(new Point(2,3)));
        tileRow.add(new SeaTile(new Point(2,4)));
        this.terrainMatrix.add(tileRow);
        tileRow = new ArrayList<>();

        tileRow.add(new SeaTile(new Point(3,0)));
        tileRow.add(new LandTile(new Point(3,1)));
        tileRow.add(new SeaTile(new Point(3,2)));
        tileRow.add(new LandTile(new Point(3,3)));
        tileRow.add(new SeaTile(new Point(3,4)));
        this.terrainMatrix.add(tileRow);
        tileRow = new ArrayList<>();

        tileRow.add(new SeaTile(new Point(0,0)));
        tileRow.add(new SeaTile(new Point(0,1)));
        tileRow.add(new LandTile(new Point(0,2)));
        tileRow.add(new SeaTile(new Point(0,3)));
        tileRow.add(new SeaTile(new Point(0,4)));
        this.terrainMatrix.add(tileRow);

        UMovementUtility.setTileMatrix(this.terrainMatrix);
        UTileMatrixDecoder.setTilematrix(terrainMatrix);
    }

    @Test
    public void testEnemyMovesUp() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(3,2), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(1,2)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);

        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,2), enemy.getPos());
    }

    @Test
    public void testEnemyMovesTopRight() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(3,2), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(1,4)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,3), enemy.getPos());
    }

    @Test
    public void testEnemyMovesRight() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(2,0), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(2,4)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,1), enemy.getPos());
    }

    @Test
    public void testEnemyMovesBottomRight() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(0,1), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(3,4)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(1,2), enemy.getPos());
    }

    @Test
    public void testEnemyMovesDown() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(0,4), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(4,4)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(1,4), enemy.getPos());
    }

    @Test
    public void testEnemyMovesBottomLeft() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(0,3), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(2,1)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(1,2), enemy.getPos());
    }

    @Test
    public void testEnemyMovesLeft() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(2,4), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(2,0)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,3), enemy.getPos());
    }

    @Test
    public void testEnemyMovesTopLeft() {
        List<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(3,4), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(0,1)));
        UEntityMatrixGenerator.updateEntityMatrix(entities);
        TestAICommander commander = new TestAICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,3), enemy.getPos());
    }

    @Test
    public void testFireAtPlayer() {
        
    }
}
