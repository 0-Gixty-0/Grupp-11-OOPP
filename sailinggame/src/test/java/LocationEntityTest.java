import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group11.model.ABody;
import com.group11.model.LocationEntity;
import com.group11.model.Ship;

public class LocationEntityTest {
    
    @Test
    public void testGetBody() {
        ABody ship = new Ship(null, null, 0, 0, 0, 0);
        LocationEntity location = new LocationEntity(ship, "ShipTown", false);
        assertEquals(ship, location.getBody());
    }

    @Test
    public void testSetBody() {
        ABody ship = new Ship(null, null, 0, 0, 0, 0);
        LocationEntity location = new LocationEntity(null, "ShipTown", false);
        assertEquals(null, location.getBody());
        location.setBody(ship);
        assertEquals(ship, location.getBody());
    }
}
  
