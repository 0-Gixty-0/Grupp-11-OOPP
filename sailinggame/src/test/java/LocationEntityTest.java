import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.group11.model.LocationEntity;

public class LocationEntityTest {
    

    @Test
    public void testSetBody() {
        // THis tests use null right now because there are no concrete implementations of AImmovableBody
        LocationEntity location = new LocationEntity(null, "ShipTown", false);
        location.setImmovableBody(null);
        assertThrows(NullPointerException.class, () -> location.getPos()); //You should not be able to get a position from a location with no body
    }
}
  
