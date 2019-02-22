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
    public void conjugation() {
        assertEquals(new Quaternion(4, -8, -12, -16),
                new Quaternion(4, 8, 12, 16).conjugation());
    }

    @Test
    public void module() {
        assertEquals(4,
                new Quaternion(2, 2, 2, 2).module(), 1e-10);
    }

    @Test
    public void rationing() {
        assertEquals(new Quaternion(0.5, 0.5, 0.5, 0.5),
                new Quaternion(2, 2, 2, 2).rationing());
    }

    @Test
    public void div() {
        assertEquals(new Quaternion(0.125, -0.125, -0.125, -0.125),
                new Quaternion(2, 2, 2, 2).div());
    }

    @Test
    public void quaternionScalar() {
        assertEquals(new Quaternion(4, 0, 0, 0),
                new Quaternion(4, 6, 3, 2).quaternionScalar());
    }

    @Test
    public void quaternionVector() {
        assertEquals(new Quaternion(0, 6, 3, 2),
                new Quaternion(4, 6, 3, 2).quaternionVector());
    }
}