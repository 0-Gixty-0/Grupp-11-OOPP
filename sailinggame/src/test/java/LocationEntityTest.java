import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group11.model.AImmovableBody;
import com.group11.model.LocationEntity;

public class LocationEntityTest {
    
    @Test
    public void testGetBody() {
        // THis tests use null right now because there are no concrete implementations of AImmovableBody
        AImmovableBody body = null;
        LocationEntity location = new LocationEntity(body, "ShipTown", false);
        assertEquals(null, location.getBody());
    }

    @Test
    public void testSetBody() {
        // THis tests use null right now because there are no concrete implementations of AImmovableBody
        AImmovableBody body = null;
        LocationEntity location = new LocationEntity(null, "ShipTown", false);
        assertEquals(null, location.getBody());
        location.setBody(null);
        assertEquals(null, location.getBody());
    }
}
  
