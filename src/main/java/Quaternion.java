import static java.lang.Math.*;

public final class Quaternion {
    private final double real;
    private final double i;
    private final double j;
    private final double k;

    public Quaternion(double real, double i, double j, double k) {
        this.real = real;
        this.i = i;
        this.j = j;
        this.k = k;
    }


    //сложение
    public Quaternion quaternionSum(Quaternion other) {
        double newReal = real + other.real;
        double newI = i + other.i;
        double newJ = j + other.j;
        double newK = k + other.k;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //вычитание
    public Quaternion quaternionMinus(Quaternion other) {
        double newReal = real - other.real;
        double newI = i - other.i;
        double newJ = j - other.j;
        double newK = k - other.k;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //умножение на скаляр
    public Quaternion scalarMultiplication(double scalar) {
        double newReal = real * scalar;
        double newI = i * scalar;
        double newJ = j * scalar;
        double newK = k * scalar;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //умножение
    public Quaternion quaternionMultiplication(Quaternion other) {
        double newReal = real * other.real - i * other.i - j * other.j - k * other.k;
        double newI = real * other.i + other.real * i + j * other.k - other.j * k;
        double newJ = real * other.j + other.real * j + k * other.i - other.k * i;
        double newK = real * other.k + other.real * k + i * other.j - other.i * j;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //сопряжение
    public Quaternion inverse() {
        return new Quaternion(real, -i, -j, -k);
    }

    //модуль
    public double module() {
        return sqrt(pow(real, 2) + pow(i, 2) + pow(j, 2) + pow(k, 2));
    }

    //нормирование
    public Quaternion norm() {
        double denominator = this.module();
        if (denominator != 0) {
            return this.scalarMultiplication(1 / denominator);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    //деление
    public Quaternion div(Quaternion other) {
        double denominator = pow(other.module(), 2);
        if (denominator != 0) {
           return this
                   .quaternionMultiplication(other.inverse())
                   .scalarMultiplication(1 / denominator);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    //скалярная часть
    public double quaternionScalar() {
        return real;
    }

    //векторная часть
    public Veсtor quaternionVector() {
        return new Veсtor( i, j, k);
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

    //утилита: определение оси и угла поворота
    public Coordinates createCoord() {
        Quaternion normQuaternion = this.scalarMultiplication(1 / this.module());
        double angle = 2* acos(normQuaternion.real);
        double x = 2* asin(normQuaternion.i);
        double y = 2* asin(normQuaternion.j);
        double z = 2* asin(normQuaternion.k);
        return new Coordinates(angle, x, y, z);

    }
}

