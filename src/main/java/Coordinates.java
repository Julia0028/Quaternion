
import static java.lang.Math.*;

public class Coordinates {
    private final double angle;
    private final double x;
    private final double y;
    private final double z;

    public Coordinates(double angle, double x, double y, double z) {
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates other = (Coordinates) obj;
            return angle == other.angle && x == other.x && y == other.y && z == other.z;
        }
        return false;
    }

   //утилита: построение кватерниона заданием оси и угла поворота
    public Quaternion createQuaterion() {
        double length = sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
        double NewReal = cos(angle / 2);
        double NewI = x * sin(angle / 2) / length;
        double NewJ = y * sin(angle / 2) / length;
        double NewK = z * sin(angle / 2) / length;
        return new Quaternion(NewReal, NewI, NewJ, NewK);
    }

    public String toString() {
        return angle + " " + x + " " + y + " " + z;
    }


}
