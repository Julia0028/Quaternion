import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {

    @Test
    public void createQuaterion() {
        assertEquals(
                new Quaternion(0.7071067811865476, 0, 0, 0.7071067811865475),
                new Coordinates(Math.PI / 2, 0, 0, 10).createQuaterion());
    }
}