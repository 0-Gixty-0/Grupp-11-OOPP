package modeltest;

import static junit.framework.TestCase.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.utility.UEntityMatrixGenerator;

public class UEntityMatrixGeneratorTest {
    @Test
    public void testCreationOfEmptyMatrix() {
        List<List<AEntity>> entityMatrix = UEntityMatrixGenerator.createEntityMatrix(5,5, new ArrayList<>());
        ArrayList<AEntity> testRow = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testRow.add(null);
        }
        for (List<AEntity> row : entityMatrix) {
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
        List<List<AEntity>> entityMatrix = UEntityMatrixGenerator.createEntityMatrix(5,5,entities);
        

        for (AEntity entity : entities) {
            int rowIndex = entity.getBody().getPos().x;
            int columnIndex = entity.getBody().getPos().y;
            assertEquals(entity, entityMatrix.get(rowIndex).get(columnIndex));
        }
    }
}
