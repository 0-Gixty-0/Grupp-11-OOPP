package modeltest;

import static junit.framework.TestCase.assertEquals;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.utility.UEntityMatrixGenerator;

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
