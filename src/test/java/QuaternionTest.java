
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class QuaternionTest {

    @Test
    public void plus() {
        assertEquals(new Quaternion(1, 2, 3, 4),
                new Quaternion(1, 1, 1, 1)
                        .plus(new Quaternion(0, 1, 2, 3)));
    }

    @Test
    public void minus() {
        assertEquals(new Quaternion(5, 5, 6, 7),
                new Quaternion(7, 8, 9, 4)
                        .minus(new Quaternion(2, 3, 3, -3)));
    }

    @Test
    public void scalarMultiply() {
        assertEquals(new Quaternion(4, 8, 12, 16),
                new Quaternion(1, 2, 3, 4).times(4));
    }

    @Test
    public void quaternionMultiply() {
        assertEquals(new Quaternion(-26, 15, 49, 26),
                new Quaternion(1, 4, 6, 7)
                        .times(new Quaternion(5, 3, 2, 1)));
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
        Quaternion q = new Quaternion(1, -5, 0, 4);
        assertTrue(q.norm()
                .approximatelyEquals(new Quaternion(1.0 / q.module(), -5.0 / q.module(), 0.0 / q.module(), 4.0 / q.module()), 2));
    }

    @Test
    public void div() {
        assertTrue(new Quaternion(1, -5, 0, 4).div(new Quaternion(3, -3, 0, 1))
                .approximatelyEquals(new Quaternion(22.0 / 19,-12.0 / 19,7.0 / 19,11.0 / 19), 2));
    }

    @Test
    public void getScalar() {
        assertEquals(4,
                new Quaternion(4, 6, 3, 2).getScalar(), 1e-10);
    }

    @Test
    public void getVector() {
        assertEquals(new Veсtor(2, 3, 4),
                new Quaternion(1, 2, 3, 4).getVector());
    }

    @Test
    public void getAxis() {
        assertTrue(new Quaternion(1, 0, 0, 0).getAxis()
                .round(new Veсtor(0, 0, 0)));
    }

    @Test
    public void getAngle() {
        assertEquals(0,
                new Quaternion(1, 0, 0, 0).getAngle(), 1e-10);
    }

    @Test
    public void createQuaternion() {
        assertTrue(Quaternion.createQuaternion(0, new Veсtor(0, 0, 1))
                .approximatelyEquals(new Quaternion(1, 0, 0,0), 2
        ));
    }


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void normException() throws ArithmeticException {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Denominator cannot be zero");
        Quaternion q = new Quaternion(0,0,0,0);
        q.norm();
    }

    @Test
    public void divException() {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Denominator cannot be zero");
        Quaternion q2 = new Quaternion(0,0,0,0);
        Quaternion q1 = new Quaternion(1, 2, 3, 4);
        q1.div(q2);
    }

    @Test
    public void getAxisException() {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Denominator cannot be zero");
        Quaternion q = new Quaternion(0,0,0,0);
        q.getAxis();
    }

    @Test
    public void getAngleException() {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Denominator cannot be zero");
        Quaternion q = new Quaternion(0, 0, 0, 0);
        q.getAngle();
    }

    @Test
    public void createQuaternionException() {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Denominator cannot be zero");
        Veсtor axis = new Veсtor(0, 0, 0);
        double angle = Math.PI;
        Quaternion.createQuaternion(angle, axis);
    }
}