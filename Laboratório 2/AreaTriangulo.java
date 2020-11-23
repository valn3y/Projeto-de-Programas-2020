import java.util.Scanner;

class AreaTriangulo {
    public static void main(String[] args) {
        AreaTriangulo at = new AreaTriangulo();
        Scanner scan = new Scanner(System.in);
        Double x = scan.nextDouble();
        Double y = scan.nextDouble();
        Double z = scan.nextDouble();

        if (at.triangleValid(x, y, z)) {
            Double s = (x + y + z) / 2;
            Double area = Math.sqrt(s * (s - x) * (s - y) * (s - z));
            System.out.printf("%.2f", area);
        } else {
            System.out.println("Triangulo invalido");
        }

        scan.close();
    }

    public Boolean triangleValid(Double x, Double y, Double z) {
        Boolean valid = false;
        if (x + y > z && x + z > y && y + z > x) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }
}
