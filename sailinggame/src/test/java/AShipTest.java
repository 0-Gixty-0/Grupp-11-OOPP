import com.group11.Model.AShip;
import com.group11.Model.SmallShip;

public class AShipTest {
    public static void main(String[] args) {
        testAShipConstruction();
    }

    private static void testAShipConstruction() {
        SmallShip myShip = new SmallShip(1, 2, 3) {
        };

        System.out.println("ok");
    }
}