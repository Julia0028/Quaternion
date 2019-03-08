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
    public Quaternion plus(Quaternion other) {
        double newReal = real + other.real;
        double newI = i + other.i;
        double newJ = j + other.j;
        double newK = k + other.k;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //вычитание
    public Quaternion minus(Quaternion other) {
        double newReal = real - other.real;
        double newI = i - other.i;
        double newJ = j - other.j;
        double newK = k - other.k;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //умножение на скаляр
    public Quaternion scalarMultiply(double scalar) {
        double newReal = real * scalar;
        double newI = i * scalar;
        double newJ = j * scalar;
        double newK = k * scalar;
        return new Quaternion(newReal, newI, newJ, newK);
    }

    //умножение
    public Quaternion quaternionMultiply(Quaternion other) {
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
            return this.scalarMultiply(1 / denominator);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    //деление
    public Quaternion div(Quaternion other) {
        double denominator = pow(other.module(), 2);
        if (denominator != 0) {
           return this
                   .quaternionMultiply(other.inverse())
                   .scalarMultiply(1 / denominator);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    //скалярная часть
    public double getScalar() {
        return real;
    }

    //векторная часть
    public Veсtor getVector() {
        return new Veсtor( i, j, k);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return real == other.real && i == other.i && j == other.j && k == other.k;
        }
        return false;
    }

    public boolean round(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return  abs(real - other.real) <= (Math.ulp(max(real, other.real))) &&
                    abs(i - other.i) <= (Math.ulp(max(i, other.i))) &&
                    abs(j - other.j) <= (Math.ulp(max(j, other.j))) &&
                    abs(k - other.k) <= (Math.ulp(max(k, other.k)));

        }
        return false;
    }

   @Override
    public String toString() {
        return (real + " " + i + " " + j + " " + k);
    }

    //утилита:

    // определение оси
    public Veсtor getAxis() {
        double denominator = this.module();
        if (denominator != 0) {
            Quaternion normQuaternion = this.scalarMultiply(1 / denominator);
            double x = 2 * asin(normQuaternion.i);
            double y = 2 * asin(normQuaternion.j);
            double z = 2 * asin(normQuaternion.k);
            return new Veсtor(x, y, z);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    //определение угла поворота
    public double getAngle() {
        double denominator = this.module();
        if (denominator != 0) {
            Quaternion normQuaternion = this.scalarMultiply(1 / this.module());
            return 2 * acos(normQuaternion.real);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }

    //создание кватерниона с помощью оси и угла поворота
    public static Quaternion createQuaternion(double angle, Veсtor axis) {
        double length = sqrt(pow(axis.getA(), 2) + pow(axis.getB(), 2) + pow(axis.getC(), 2));
        if (length != 0) {
            double real = cos(angle / 2);
            double i = axis.getA() * sin(angle / 2) / length;
            double j = axis.getB() * sin(angle / 2) / length;
            double k = axis.getC() * sin(angle / 2) / length;
            return new Quaternion(real, i, j, k);
        } else throw new ArithmeticException("Denominator cannot be zero");
    }
}

