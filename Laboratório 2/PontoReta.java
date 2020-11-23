import java.util.Scanner;

class PontoReta {
    public static void main(String[] args) {
        PontoReta pr = new PontoReta();
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();
        double y = scan.nextDouble();

        pr.belong(x, y);

        scan.close();
    }

    public void belong(double x, double y) {
        if ((2 * x) + y == 3) {
            System.out.printf("Ponto (%.1f, %.1f) pertence a reta 2x + y = 3.\n", x, y);
        } else {
            System.out.printf("Ponto (%.1f, %.1f) nao pertence a reta 2x + y = 3.\n", x, y);
        }
    }
}
