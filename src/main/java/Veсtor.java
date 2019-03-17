import static java.lang.Math.abs;

public class Veсtor {
        private double a;
        private double b;
        private double c;

        public Veсtor(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public String toString() {
            return a + " " + b + " " + c;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Veсtor) {
                Veсtor other = (Veсtor) obj;
                return a == other.a && b == other.b && c == other.c;

            }
            return false;
        }

        public double getA (){
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

    public boolean round(Object obj, double n) {
        if (this == obj) return true;
        if (obj instanceof Veсtor) {
            Veсtor other = (Veсtor) obj;
            return  abs(a - other.a) <= n * Math.ulp(a) &&
                    abs(b - other.b) <= n * Math.ulp(b) &&
                    abs(c - other.c) <= n * Math.ulp(c);
        }
        return false;
    }

}
