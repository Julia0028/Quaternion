
//вспомогательный класс для реализации метода "возвращение векторной части"
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
    }
