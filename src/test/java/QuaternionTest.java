
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuaternionTest {

    @Test
    public void quaternionSum() {
        assertEquals(new Quaternion(1, 2, 3, 4),
                new Quaternion(1, 1, 1, 1)
                        .quaternionSum(new Quaternion(0, 1, 2, 3)));
    }

    @Test
    public void quaternionMinus() {
        assertEquals(new Quaternion(5, 5, 6, 7),
                new Quaternion(7, 8, 9, 4)
                        .quaternionMinus(new Quaternion(2, 3, 3, -3)));
    }

    @Test
    public void scalarMultiplication() {
        assertEquals(new Quaternion(4, 8, 12, 16),
                new Quaternion(1, 2, 3, 4).scalarMultiplication(4));
    }

    @Test
    public void quaternionMultiplication() {
        assertEquals(new Quaternion(-26, 15, 49, 26),
                new Quaternion(1, 4, 6, 7)
                        .quaternionMultiplication(new Quaternion(5, 3, 2, 1)));
    }

    @Test
    public void inverse() {
        assertEquals(new Quaternion(4, -8, -12, -16),
                new Quaternion(4, 8, 12, 16).inverse());
    }

    @Test
    public void module() {
        assertEquals(4,
                new Quaternion(2, 2, 2, 2).module(), 1e-10);
    }

    @Test
    public void norm() {
        assertEquals(new Quaternion(0.5, 0.5, 0.5, 0.5),
                new Quaternion(2, 2, 2, 2).norm());
    }

    @Test
    public void div() {
        assertEquals(new Quaternion(0.33333333333333326, 0, 0, 0),
                new Quaternion(10, -5, 0, 15)
                        .div(new Quaternion(30, -15, 0, 45)));
    }

    @Test
    public void quaternionScalar() {
        assertEquals(4,
                new Quaternion(4, 6, 3, 2).quaternionScalar(), 1e-10);
    }

    @Test
    public void quaternionVector() {
        assertEquals(new Veсtor(2, 3, 4),
                new Quaternion(1, 2, 3, 4).quaternionVector());
    }


    @Test
    public void createCoord() {
        assertEquals(new Coordinates(3.141592653589793, -3.141592653589793, 0, 0),
                new Quaternion(0, -1, 0, 0).createCoord());
    }

    }