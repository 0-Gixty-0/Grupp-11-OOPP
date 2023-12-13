package modeltest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.utility.UEntityMatrixDecoder;

public class UEntityMatrixDecoderTest {

    @Test
    public void testDecodeIntoIntMatrix() {
        // Arrange
        ShipBuilder builder = new ShipBuilder();

        builder.setName("Player");
        builder.setFriendlyStatus(true);
        builder.setBody();
        AEntity player = builder.createEntity();
        builder.reset();

        builder.setName("Enemy");
        builder.setFriendlyStatus(false);
        builder.setBody();
        AEntity enemy = builder.createEntity();
        builder.reset();

        builder.setName("CannonBall");
        builder.setFriendlyStatus(false);
        builder.setBody();
        AEntity cannonBall = builder.createEntity();
        builder.reset();

        List<List<AEntity>> matrix = Arrays.asList(
            Arrays.asList(player, enemy, null),
            Arrays.asList(null, cannonBall, player)
        );

        UEntityMatrixDecoder.setEntityMatrix(matrix);
        List<List<Integer>> intMatrix = UEntityMatrixDecoder.decodeIntoIntMatrix();

        // Assert
        assertEquals(2, intMatrix.size());
        assertEquals(Arrays.asList(0, 1, -1), intMatrix.get(0));
        assertEquals(Arrays.asList(-1, 2, 0), intMatrix.get(1));
    }
}