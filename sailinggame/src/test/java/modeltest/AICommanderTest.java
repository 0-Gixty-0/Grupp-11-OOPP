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
    private List<List<AEntity>> entityMatrix = UEntityMatrixGenerator.createEntityMatrix(5,5);
    private EntityDirector director = new EntityDirector(new ShipBuilder());
    private ArrayList<AEntity> entities = new ArrayList<>();
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
    }

    @Test
    public void testEnemyMovesUp() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(3,2), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(1,2)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,2), enemy.getPos());
    }

    @Test
    public void testEnemyMovesTopRight() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(3,2), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(1,4)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,3), enemy.getPos());
    }

    @Test
    public void testEnemyMovesRight() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(2,0), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(2,4)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,1), enemy.getPos());
    }

    @Test
    public void testEnemyMovesBottomRight() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(0,1), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(3,4)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(1,2), enemy.getPos());
    }

    @Test
    public void testEnemyMovesDown() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(0,4), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(4,4)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(1,4), enemy.getPos());
    }

    @Test
    public void testEnemyMovesBottomLeft() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(0,3), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(2,1)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(1,2), enemy.getPos());
    }

    @Test
    public void testEnemyMovesLeft() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(2,4), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(2,0)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,3), enemy.getPos());
    }

    @Test
    public void testEnemyMovesTopLeft() {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        CommandableEntity enemy = (CommandableEntity) this.director.createEnemy(new Point(3,4), 1);
        enemyList.add(enemy);
        this.entities.add(enemy);
        this.entities.add(this.director.createPlayer(new Point(0,1)));
        this.entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(this.entities, this.entityMatrix);
        AICommander commander = new AICommander(this.entityMatrix, this.terrainMatrix);
        commander.moveEnemies(enemyList);
        assertEquals(new Point(2,3), enemy.getPos());
    }
}
