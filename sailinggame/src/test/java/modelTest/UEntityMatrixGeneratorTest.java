package modelTest;

import com.group11.model.builders_and_factories.EntityDirector;
import com.group11.model.builders_and_factories.ShipBuilder;
import com.group11.model.game_entites.AEntity;
import com.group11.model.high_level_components.UEntityMatrixGenerator;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class UEntityMatrixGeneratorTest {
    @Test
    public void testCreationOfEmptyMatrix() {
        ArrayList<ArrayList<AEntity>> entityMatrix = UEntityMatrixGenerator.createEntityMatrix(5,5);
        ArrayList<AEntity> testRow = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testRow.add(null);
        }
        for (ArrayList<AEntity> row : entityMatrix) {
            assertEquals(testRow, row);
        }
    }

    @Test
    public void testPopulateMatrixWithEntities() {
        ArrayList<AEntity> entities = new ArrayList<>();
        EntityDirector director = new EntityDirector(new ShipBuilder());
        for (int i = 0; i < 5; i++) {
            entities.add(director.createEnemy(new Point(2, i), 1));
        }
        ArrayList<ArrayList<AEntity>> entityMatrix = UEntityMatrixGenerator.createEntityMatrix(5,5);
        entityMatrix = UEntityMatrixGenerator.populateEntityMatrix(entities, entityMatrix);

        for (AEntity entity : entities) {
            int rowIndex = entity.getBody().getPos().y;
            int columnIndex = entity.getBody().getPos().x;
            assertEquals(entity, entityMatrix.get(rowIndex).get(columnIndex));
        }
    }
}
