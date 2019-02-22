import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public final class Quaternion {
    private final double real;
    private final double i;
    private final double j;
    private final double k;

    public Quaternion (double real, double i, double j, double k) {
        this.real = real;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public Quaternion quaternionSum(Quaternion other) {
        double newReal = real + other.real;
        double new_i = i + other.i;
        double new_j = j + other.j;
        double new_k = k + other.k;
        return new Quaternion(newReal, new_i, new_j, new_k);
    }

    public Quaternion quaternionMinus(Quaternion other) {
        double newReal = real - other.real;
        double new_i = i - other.i;
        double new_j = j - other.j;
        double new_k = k - other.k;
        return new Quaternion(newReal, new_i, new_j, new_k);
    }

    public Quaternion scalarMultiplication (double scalar) {
        double newReal = real * scalar;
        double new_i = i * scalar;
        double new_j = j * scalar;
        double new_k = k * scalar;
        return new Quaternion(newReal, new_i, new_j, new_k);
    }

    public Quaternion quaternionMultiplication (Quaternion other) {
        double newReal = real * other.real - i * other.i - j * other.j - k * other.k;
        double new_i = real * other.i + other.real * i + j * other.k - other.j * k;
        double new_j = real * other.j + other.real * j + k * other.i - other.k * i;
        double new_k = real * other.k + other.real * k + i * other.j - other.i * j;
        return new Quaternion(newReal, new_i, new_j, new_k);
    }

    public Quaternion conjugation() {
        return new Quaternion(real, -i, -j, -k);
    }

    public double module () {
        return sqrt(pow(real, 2) + pow(i, 2) + pow(j, 2) + pow(k, 2));
    }

    public Quaternion rationing () {
        double denominator = this.module();
        if (denominator != 0) {
            double newReal = real / denominator;
            double new_i = i / denominator;
            double new_j = j / denominator;
            double new_k = k / denominator;
            return new Quaternion(newReal, new_i, new_j, new_k);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    public Quaternion div () {
        double denominator = pow(this.module(), 2);
        Quaternion quaternion = this.conjugation();
        if (denominator != 0) {
            double newReal = quaternion.real / denominator;
            double new_i = quaternion.i / denominator;
            double new_j = quaternion.j / denominator;
            double new_k = quaternion.k / denominator;
            return new Quaternion(newReal, new_i, new_j, new_k);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    public Quaternion quaternionScalar () {
        return new Quaternion(real, 0, 0, 0);
    }

    public Quaternion quaternionVector () {
        return new Quaternion(0, i, j, k);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return real == other.real && i == other.i && j == other.j && k == other.k;
        }
        return false;
    }

    public String toString() {
        return (real + " " + i + " " + j + " " + k);
    }
}
